package com.trungcs.simple_service_locator.service_locator

import com.trungcs.simple_service_locator.service_locator.error.ServiceLocatorException
import kotlin.reflect.KClass

typealias FactoryCreator<T> = () -> T

@Suppress("UNCHECKED_CAST")
internal class SimpleServiceLocator private constructor() {

    // Store singleton instances
    private val singletons = mutableMapOf<KClass<*>, Lazy<*>>()

    // Store the factory methods to initiate diff instance in each call.
    private val factories = mutableMapOf<KClass<*>, FactoryCreator<*>>()
    inline fun <reified T> registerSingleton(noinline instance: () -> T) {
        val x = T::class
        val singletonInstance = lazy(instance)
        singletons[x] = singletonInstance
    }

    inline fun <reified T> registerFactory(noinline instance: FactoryCreator<T>) {
        val x = T::class
        factories[x] = instance
    }

    inline fun <reified T> get(): T {
        val key = T::class
        if (singletons.contains(key)) {
            return (singletons[T::class] as? Lazy<T>)?.value
                ?: throw ServiceLocatorException("Wrong singleton type")
        }

        if (factories.contains(key)) {
            val creator = factories[T::class] as? FactoryCreator<T>
                ?: throw ServiceLocatorException("Wrong factory type")
            return creator()
        }

        throw ServiceLocatorException("The type ${T::class.simpleName} was not registered yet")
    }

    companion object {
        val instance = SimpleServiceLocator()
    }
}