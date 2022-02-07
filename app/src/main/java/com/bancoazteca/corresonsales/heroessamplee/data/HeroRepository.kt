package com.bancoazteca.corresonsales.heroessamplee.data

import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import com.bancoazteca.corresonsales.heroessamplee.data.network.HeroService

class HeroRepository {

    private val api = HeroService()

    suspend fun getHeroById(id: Int): ApiHeroModel? {
        return api.getHeroById(id)
    }
}