package com.trungcs.simple_dependency_injection.simple_di.annotation

import kotlin.reflect.KClass

// This annotation is to mark a class as a component that provide all dependencies.
// Use Retention.RUNTIME to get the annotation in runtime-phase
// Otherwise -> it will be discard after the compile-phase
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class SimpleComponent(val modules: Array<KClass<*>>)