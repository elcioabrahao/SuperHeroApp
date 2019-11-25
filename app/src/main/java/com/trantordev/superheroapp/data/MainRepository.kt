package com.trantordev.superheroapp.data

import com.trantordev.superheroapp.network.ApiServices
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainRepository private constructor(
    private val apiServices: ApiServices
) {

    suspend fun getHeroes(resource: String) = apiServices.service.getHeroes("$resource")

//    suspend fun getCurrentLoggedUser() =   GlobalScope.async {
//        loginDao.getLogedUser().userId
//    }.await()
//
//    suspend fun getClientInfo(userId: Long) = GlobalScope.async {
//        clientAccountInfoDao.getAccountInfo(userId)
//    }.await()
//
//    suspend fun getClientInfo() = getClientInfo(getCurrentLoggedUser())

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