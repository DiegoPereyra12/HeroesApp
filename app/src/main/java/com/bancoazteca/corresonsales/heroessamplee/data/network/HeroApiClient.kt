package com.bancoazteca.corresonsales.heroessamplee.data.network

import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface HeroApiClient {
    @GET("{id}")
    suspend fun getHeroById(@Path("id") id: Int): Response<ApiHeroModel>

//    @GET("api_endpoint")
//    fun getJson(): Call<JsonObject?>?
}