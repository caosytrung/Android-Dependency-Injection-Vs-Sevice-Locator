package com.trungcs.simple_service_locator.main.register_service_locator

import com.trungcs.simple_service_locator.main.data.repo.HelloServiceLocatorRepository
import com.trungcs.simple_service_locator.main.data.repo.HelloServiceLocatorRepositoryImpl
import com.trungcs.simple_service_locator.main.ui.HelloServiceLocatorViewModel
import com.trungcs.simple_service_locator.service_locator.SimpleServiceLocator
import com.trungcs.simple_service_locator.service_locator.get

fun registerServiceLocator() {
    val serviceLocator = SimpleServiceLocator.instance

    serviceLocator.registerSingleton<HelloServiceLocatorRepository> { HelloServiceLocatorRepositoryImpl() }

    serviceLocator.registerFactory { HelloServiceLocatorViewModel(get()) }
}