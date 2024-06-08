package com.trungcs.diandservicelocator

import android.app.Application
import com.trungcs.simple_service_locator.main.register_service_locator.registerServiceLocator

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        registerServiceLocator()
    }

}