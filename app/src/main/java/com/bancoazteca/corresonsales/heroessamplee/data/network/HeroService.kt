package com.bancoazteca.corresonsales.heroessamplee.data.network

import android.widget.Toast
import com.bancoazteca.corresonsales.heroessamplee.core.RetrofitHelper
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class HeroService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val client = retrofit.create(HeroApiClient::class.java)

    suspend fun getHeroById(id: Int): ApiHeroModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getHeroById(id)
                if (response.isSuccessful && response.body()?.id != null) {
                    response.body()
                } else {
                    null
                }
            }catch (exception: Exception){
                return@withContext null
            }


        }

    }
}