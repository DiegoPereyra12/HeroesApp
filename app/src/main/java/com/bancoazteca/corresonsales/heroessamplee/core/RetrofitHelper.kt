package com.bancoazteca.corresonsales.heroessamplee.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/490326199270841/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}