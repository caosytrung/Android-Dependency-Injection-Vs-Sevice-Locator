package com.trungcs.simple_dependency_injection.simple_di_lib.annotation

// This annotation is to mark whether the requested instance is Singleton or not.
// Use Retention.RUNTIME to get the annotation in runtime-phase
// Otherwise -> it will be discard after the compile-phase
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SimpleSingleton