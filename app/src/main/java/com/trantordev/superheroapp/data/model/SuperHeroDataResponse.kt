package com.trantordev.superheroapp.data.model

import com.google.gson.annotations.SerializedName

class SuperHeroDataResponse {
    @SerializedName("Heroes") val heroes : List<Hero> = ArrayList()
}