package com.bancoazteca.corresonsales.heroessamplee.domain

import com.bancoazteca.corresonsales.heroessamplee.data.HeroRepository
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel

class GetHeroesUC {

    private val repository = HeroRepository()

    suspend  fun getHeroById(id: Int): ApiHeroModel? {
        return repository.getHeroById(id)
    }
}