package com.trungcs.simple_dependency_injection.simple_di.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.trungcs.simple_dependency_injection.simple_di.SimpleDIContainer
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleComponent
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleInject
import com.trungcs.simple_dependency_injection.simple_di.error.SimpleDIException
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.jvm.isAccessible

@SimpleComponent([])
interface AppComponent {
    fun injectActivity(activity: Activity)
    fun injectFragment(fragment: Fragment)

}