package com.bancoazteca.corresonsales.heroessamplee.ui.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bancoazteca.corresonsales.heroessamplee.R
import com.bancoazteca.corresonsales.heroessamplee.databinding.FragmentTittleBinding


class TittleFragment : Fragment() {

    private lateinit var binding: FragmentTittleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTittleBinding.inflate(inflater, container, false)


        binding.startButton.setOnClickListener {
            binding.mainTitle.visibility = View.INVISIBLE
            binding.statusLoad.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed({
                Navigation.findNavController(binding.startButton)
                    .navigate(R.id.action_tittleFragment_to_mainFragment)
            }, 2000)

        }
        return binding.root
    }

}