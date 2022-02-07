package com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel

data class ApiHeroModel(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
)