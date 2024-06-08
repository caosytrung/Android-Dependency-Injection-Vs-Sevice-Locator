package com.trungcs.simple_dependency_injection.main.repo

class HelloDIRepositoryImpl() : HelloDIRepository {
    override fun getHello(): String {
        return "Hello! Hello! Dependency Injection!"
    }
}