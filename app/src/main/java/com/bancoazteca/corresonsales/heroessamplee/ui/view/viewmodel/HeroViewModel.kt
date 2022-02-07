package com.bancoazteca.corresonsales.heroessamplee.ui.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import com.bancoazteca.corresonsales.heroessamplee.domain.GetHeroesUC
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.firstscrolling
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.scrolling
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroViewModel : ViewModel() {
    val heroModel = MutableLiveData<MutableList<ApiHeroModel>>()
    var listApiHeroModel: MutableList<ApiHeroModel> = mutableListOf()

    var getHeroesUC = GetHeroesUC()

    fun onCreate() {
        for (i in firstscrolling..scrolling) {
            viewModelScope.launch {
                val result = getHeroById(i)
                result?.let {
                    updateLiveData(it)
                } ?: kotlin.run {
                    val retry = getHeroById(i)
                    retry?.let {
                        updateLiveData(it)
                    }
                }
            }
        }

    }


    private suspend fun updateLiveData(hero: ApiHeroModel) {
        listApiHeroModel.add(hero)
        listApiHeroModel.sortBy {
            it.id.toInt()
        }
        withContext(Dispatchers.Main.immediate) {
            heroModel.value = listApiHeroModel
        }
    }

    private suspend fun getHeroById(i: Int) = getHeroesUC.getHeroById(i)
}