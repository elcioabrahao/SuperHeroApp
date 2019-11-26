package com.trantordev.superheroapp.data

import com.trantordev.superheroapp.network.ApiServices

class MainRepository private constructor(
    private val apiServices: ApiServices
) {

    suspend fun getHeroes(resource: String) = apiServices.service.getHeroes("$resource")

    companion object {
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(
            apiServices: ApiServices
        ) =
            instance ?: synchronized(this) {
                instance ?: MainRepository(
                    apiServices
                ).also { instance = it }
            }
    }
}