package com.trungcs.simple_service_locator.main.data.repo

import android.util.Log

internal class HelloServiceLocatorRepositoryImpl : HelloServiceLocatorRepository {
    init {
        Log.d("TRUNGCSSS", "Initialized HelloServiceLocatorRepositoryImpl")
    }
    override fun getHello(): String {
        return "Hello! Hello Service Locator!"
    }
}