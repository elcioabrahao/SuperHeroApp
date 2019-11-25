package com.trantordev.superheroapp.network

import com.trantordev.superheroapp.data.model.SuperHeroDataResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface WebServicesAPI {

    @GET
    suspend fun getHeroes(@Url url:String):SuperHeroDataResponse

}