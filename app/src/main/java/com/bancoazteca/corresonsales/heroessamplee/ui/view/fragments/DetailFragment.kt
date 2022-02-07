package com.bancoazteca.corresonsales.heroessamplee.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bancoazteca.corresonsales.heroessamplee.databinding.FragmentDetailBinding
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.currentHero
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        setupHeroInfo()
        return binding.root
    }

    private fun setupHeroInfo() {
        setupHeroTitle()
        setupHeroStats()
        setupBiography()
        setupApperance()
        setupWork()
        setupConnections()
    }

    private fun setupConnections() {
        binding.groupAffiliationTv.text =
            "Group affiliation: " + currentHero!!.connections.groupAffiliation
        binding.relativesTv.text = "Relatives: " + currentHero!!.connections.relatives
    }

    private fun setupWork() {
        binding.occupationTv.text = "Occupation: " + currentHero!!.work.occupation
        binding.baseTv.text = "base: " + currentHero!!.work.base
    }

    private fun setupHeroTitle() {
        Glide.with(binding.heroImage.context).load(currentHero!!.image.url).into(binding.heroImage)
        binding.heroName.text = currentHero!!.name
    }

    private fun setupApperance() {
        binding.genderTv.text = "Gender: " + currentHero!!.appearance.gender
        binding.raceTv.text = "Race: " + currentHero!!.appearance.race
        binding.heightTv.text = currentHero!!.appearance.height.toString()
            .substring(1, currentHero!!.appearance.height.toString().length - 1)
        binding.weightTv.text = currentHero!!.appearance.weight.toString()
            .substring(1, currentHero!!.appearance.weight.toString().length - 1)
        binding.eyeColorTv.text = "Eye color: " + currentHero!!.appearance.eyeColor
        binding.hairColorTv.text = "hair color: " + currentHero!!.appearance.hairColor
    }

    private fun setupBiography() {
        binding.fullNameTv.text = "Full name: " + currentHero!!.biography.fullName
        binding.alterEgosTv.text = "Alter egos: " + currentHero!!.biography.alterEgos
        binding.aliasesLv.text = currentHero!!.biography.aliases.toString()
            .substring(1, currentHero!!.biography.aliases.toString().length - 1)
        binding.placeOfBirthTv.text = "Place of birth: " + currentHero!!.biography.placeOfBirth
        binding.firstAppearanceTv.text =
            "First appearance: " + currentHero!!.biography.firstAppearance
        binding.publisherTv.text = "Publisher: " + currentHero!!.biography.publisher
        binding.alignmentTv.text = "Alignment: " + currentHero!!.biography.alignment
    }

    private fun setupHeroStats() {
        binding.Strength.text = currentHero?.powerstats?.strength
        binding.durability.text = currentHero?.powerstats?.durability
        binding.speed.text = currentHero?.powerstats?.speed
        binding.power.text = currentHero?.powerstats?.power
        binding.combat.text = currentHero?.powerstats?.combat
        binding.intelligence.text = currentHero?.powerstats?.intelligence
    }
}