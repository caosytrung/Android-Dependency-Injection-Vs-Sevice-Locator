package com.trungcs.simple_dependency_injection.main.di

import com.trungcs.simple_dependency_injection.main.repo.HelloDIRepository
import com.trungcs.simple_dependency_injection.main.repo.HelloDIRepositoryImpl
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleModule
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleProvider

@SimpleModule
class DataModule {

    @SimpleProvider
    fun provideModule(): HelloDIRepository {
        return HelloDIRepositoryImpl()
    }
}