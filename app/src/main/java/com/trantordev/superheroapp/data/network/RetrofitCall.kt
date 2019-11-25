package com.trantordev.superheroapp.network

import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCall {

    private var BASE_URL: String = "https://bitbucket.org/dttden/mobile-coding-challenge/raw/259972edefb1eed313b3a8f1a0cc1d822aa5914f/"
    private var retrofit: Retrofit? = null

    fun getCall(): Retrofit {

        if (retrofit == null) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = Builder().addInterceptor(interceptor).build()


            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!
    }

}
