package com.trungcs.simple_dependency_injection.main

import androidx.lifecycle.ViewModel
import com.trungcs.simple_dependency_injection.main.repo.HelloDIRepository
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleInject

class HelloDIViewModel @SimpleInject constructor(
    private val repository: HelloDIRepository,
) : ViewModel() {
    fun getHello(): String {
        return repository.getHello()
    }
}