package com.bancoazteca.corresonsales.heroessamplee.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bancoazteca.corresonsales.heroessamplee.R
import com.bancoazteca.corresonsales.heroessamplee.data.model.apimodel.ApiHeroModel
import com.bancoazteca.corresonsales.heroessamplee.databinding.FragmentMainBinding
import com.bancoazteca.corresonsales.heroessamplee.ui.view.viewmodel.HeroViewModel
import com.bancoazteca.corresonsales.heroessamplee.ui.adapter.SuperHeroAdapter
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.currentHero
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.firstscrolling
import com.bancoazteca.corresonsales.heroessamplee.ui.view.MainActivity.Companion.scrolling


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: SuperHeroAdapter
    private val heroViewModel: HeroViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = Unit
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        initRecyclerView()
        heroViewModel.heroModel.observe(this, {
            adapter.setHeroList(it)
        })

        checkIsBottomScroll()

        return binding.root
    }

    private fun checkIsBottomScroll() {
        binding.RV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    updateIndex()
                }
            }
        })
    }

    private fun updateIndex() {
        firstscrolling = scrolling + 1
        scrolling += 50
        heroViewModel.onCreate()
    }

    fun initRecyclerView() {
        binding.RV.layoutManager = LinearLayoutManager(activity)
        adapter = SuperHeroAdapter() { hero ->
            onHeroSelected(
                hero
            )
        }
        binding.RV.adapter = adapter
    }

    fun onHeroSelected(heroModel: ApiHeroModel) {
        currentHero = heroModel
        Navigation.findNavController(binding.RV)
            .navigate(R.id.action_mainFragment_to_detailFragment)
    }
}