package com.trungcs.simple_dependency_injection.simple_di_lib

import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleInject
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleProvider
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleSingleton
import com.trungcs.simple_dependency_injection.simple_di_lib.error.SimpleDIException
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions
import kotlin.reflect.full.hasAnnotation

internal class SimpleDIContainer {
    private val cachedInstance = mutableMapOf<KClass<*>, Any>()

    fun <T : Any> getInstance(kClass: KClass<T>): T {
        if (cachedInstance.contains(kClass)) {
            // if cachedSingletonInstance contains an instance of T,
            // it means that T is singleton and was cached before.
            val instance = cachedInstance[kClass]
            return instance as T
        }

        val injectableConstructor = findInjectableConstructor(kClass)
            ?: throw SimpleDIException("Please provide @SimpleInject for the ${kClass.simpleName}")
        val isSingleton = isSingleton(kClass)

        val parameters = injectableConstructor.parameters.map {
            getInstance(it.type.classifier as KClass<*>)
        }

        val newInstance = injectableConstructor.call(*parameters.toTypedArray())

        // if the kClass is marked as Singleton, we should store it's instance to provide the later calls.
        if (isSingleton) cachedInstance[kClass] = newInstance
        return newInstance
    }

    fun handleModules(modules: Array<KClass<*>>) {
        modules.forEach(::handleModuleClass)
    }

    private fun handleModuleClass(moduleClass: KClass<*>) {
        val moduleInstance = moduleClass.createInstance()

        moduleClass.functions.forEach { func ->
            // reject functions that are not marked as @SimpleProvider
            if (!func.hasAnnotation<SimpleProvider>()) return@forEach

            // Get the return-type (generic) and parameters to initiate the instance
            val returnType =
                func.returnType.classifier as? KClass<*> ?: return@forEach
            val parameters = func.parameters.drop(1).map { parameter ->
                getInstance(parameter.type.classifier as KClass<*>)
            }
            val instance = func.call(moduleInstance, *parameters.toTypedArray())
                ?: throw SimpleDIException("DI: Failed to create instance from Modules")
            addToSingletonMap(returnType, instance)
        }
    }

    private fun <T : Any> addToSingletonMap(kClass: KClass<T>, instance: Any) {
        cachedInstance[kClass] = instance
    }

    private fun <T : Any> findInjectableConstructor(type: KClass<T>) =
        type.constructors.find { it.hasAnnotation<SimpleInject>() }

    private fun <T : Any> isSingleton(type: KClass<T>) =
        type::class.hasAnnotation<SimpleSingleton>()

}