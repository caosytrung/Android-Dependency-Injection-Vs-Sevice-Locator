package com.trungcs.simple_dependency_injection.simple_di_lib.annotation

// This annotation is to mark a class as a module that provide instance-creation for DI container.
// Use Retention.RUNTIME to get the annotation in runtime-phase
// Otherwise -> it will be discard after the compile-phase
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class SimpleModule