package com.trungcs.simple_service_locator.main.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.trungcs.simple_service_locator.main.data.repo.HelloServiceLocatorRepository


internal class HelloServiceLocatorViewModel(
    private val repository: HelloServiceLocatorRepository,
) : ViewModel() {

    init {
        Log.d("TRUNGCSSS", "Initialized HelloServiceLocatorViewModel")
    }

    fun getHello(): String {
        return repository.getHello()
    }
}