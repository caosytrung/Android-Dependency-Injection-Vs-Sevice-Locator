package com.trungcs.simple_dependency_injection.ui.di

import com.trungcs.simple_dependency_injection.data.repo.HelloRepository
import com.trungcs.simple_dependency_injection.data.repo.HelloRepositoryImpl
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleModule
import com.trungcs.simple_dependency_injection.simple_di.annotation.SimpleProvider

@SimpleModule
class DataModule {

    @SimpleProvider
    fun provideModule(): HelloRepository {
        return HelloRepositoryImpl()
    }
}