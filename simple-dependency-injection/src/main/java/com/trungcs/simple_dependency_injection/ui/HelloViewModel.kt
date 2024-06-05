package com.trungcs.simple_dependency_injection.ui

import androidx.lifecycle.ViewModel
import com.trungcs.simple_dependency_injection.data.repo.HelloRepository
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleInject


class HelloViewModel @SimpleInject constructor(
    private val repository: HelloRepository,
) : ViewModel() {
    fun getHello(): String {
        return repository.getHello()
    }
}