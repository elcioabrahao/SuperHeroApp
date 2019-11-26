package com.trantordev.superheroapp.data.model

import com.google.gson.annotations.SerializedName

class SuperHeroDataResponse {
    @SerializedName("Heroes") var heroes : List<Hero> = ArrayList()
}