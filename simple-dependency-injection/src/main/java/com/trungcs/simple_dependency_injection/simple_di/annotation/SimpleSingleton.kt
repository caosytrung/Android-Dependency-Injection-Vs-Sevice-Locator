package com.trungcs.simple_dependency_injection.simple_di.annotation

// This annotation is to mark an requested instance is Singleton or not.
// Use Retention.RUNTIME to get the annotation in runtime-phase
// Otherwise -> it will be discard after the compile-phase
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SimpleSingleton