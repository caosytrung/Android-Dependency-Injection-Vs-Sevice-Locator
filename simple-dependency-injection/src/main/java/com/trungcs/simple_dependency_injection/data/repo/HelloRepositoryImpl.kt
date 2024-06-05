package com.trungcs.simple_dependency_injection.data.repo

class HelloRepositoryImpl () : HelloRepository {
    override fun getHello(): String {
        return "Hello! Hello! Dragon! Sandata!"
    }
}