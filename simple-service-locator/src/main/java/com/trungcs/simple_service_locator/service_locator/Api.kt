package com.trungcs.simple_service_locator.service_locator


internal inline fun <reified T> get(): T {
    return SimpleServiceLocator.instance.get<T>()
}