package com.trungcs.simple_dependency_injection.simple_di_lib.annotation

// This annotation is to mark to constructor of filed will be injected by the DI container.
// Use Retention.RUNTIME to get the annotation in runtime-phase
// Otherwise -> it will be discard after the compile-phase
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class SimpleInject