package com.bancoazteca.corresonsales.heroessamplee.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bancoazteca.corresonsales.heroessamplee.R
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel

class SuperHeroAdapter(private val onClickListener: (ApiHeroModel) -> Unit) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    var superHeroList: MutableList<ApiHeroModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.hero_item, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = superHeroList.size

    fun setHeroList(heroModel: MutableList<ApiHeroModel>) {
        superHeroList = heroModel
        notifyDataSetChanged()
    }
}