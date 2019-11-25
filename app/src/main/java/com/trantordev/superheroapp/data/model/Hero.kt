package com.trantordev.superheroapp.data.model

import com.google.gson.annotations.SerializedName

data class Hero (

    @SerializedName("Name") val name : String,
    @SerializedName("Picture") val picture : String,
    @SerializedName("Score") val score : Int
)