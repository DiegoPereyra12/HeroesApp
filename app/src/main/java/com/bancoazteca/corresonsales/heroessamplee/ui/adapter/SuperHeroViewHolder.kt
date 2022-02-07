package com.bancoazteca.corresonsales.heroessamplee.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import com.bancoazteca.corresonsales.heroessamplee.databinding.HeroItemBinding
import com.bumptech.glide.Glide

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = HeroItemBinding.bind(view)

    fun render(heroModel: ApiHeroModel, onClickListener: (ApiHeroModel) -> Unit) {
        binding.heroNameTv.text = heroModel.name
        binding.heroPublisherTv.text = heroModel.biography.publisher
        Glide.with(binding.heroIv.context).load(heroModel.image.url).into(binding.heroIv)
        itemView.setOnClickListener {
            onClickListener(heroModel) }
    }
}