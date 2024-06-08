package com.trungcs.simple_dependency_injection.simple_di_lib.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.trungcs.simple_dependency_injection.main.di.DataModule
import com.trungcs.simple_dependency_injection.simple_di_lib.SimpleDIContainer
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleComponent
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleInject
import com.trungcs.simple_dependency_injection.simple_di_lib.error.SimpleDIException
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.jvm.isAccessible

@SimpleComponent([DataModule::class])
class SimpleAppComponent private constructor(private val diContainer: SimpleDIContainer) :
    AppComponent {

    init {
        setupDiContainer()
    }

    private fun setupDiContainer() {
        val componentAnno = this::class.findAnnotation<SimpleComponent>()
            ?: throw SimpleDIException("Please mark this class as @SimpleComponent")
        diContainer.handleModules(componentAnno.modules)
    }

    override fun injectActivity(activity: Activity) {
        injectDependencies(activity)
    }

    override fun injectFragment(fragment: Fragment) {
        injectDependencies(fragment)
    }

    private fun injectDependencies(target: Any) {
        target::class.declaredMemberProperties.forEach { property ->
            if (property.hasAnnotation<SimpleInject>() && property is KMutableProperty<*>) {
                property.isAccessible = true
                val instance =
                    diContainer.getInstance(property.returnType.classifier as KClass<*>)
                property.setter.call(target, instance)
            }
        }
    }

    companion object {
        fun build(): AppComponent {
            val diContainer = SimpleDIContainer()
            return SimpleAppComponent(diContainer)
        }
    }
}