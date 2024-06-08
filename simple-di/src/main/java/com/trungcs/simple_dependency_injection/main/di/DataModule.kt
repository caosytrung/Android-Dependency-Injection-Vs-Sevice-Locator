package com.trungcs.simple_dependency_injection.main.di

import com.trungcs.simple_dependency_injection.main.data.repo.HelloDIRepository
import com.trungcs.simple_dependency_injection.main.data.repo.HelloDIRepositoryImpl
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleModule
import com.trungcs.simple_dependency_injection.simple_di_lib.annotation.SimpleProvider

@SimpleModule
class DataModule {

    @SimpleProvider
    fun provideModule(): HelloDIRepository {
        return HelloDIRepositoryImpl()
    }
}