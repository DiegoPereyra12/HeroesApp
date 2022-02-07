package com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel

import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    val relatives: String
)