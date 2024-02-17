package com.ch.al_mirats.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ch.al_mirats.databinding.FragmentHomeBinding
import com.ch.al_mirats.dummy.DummyHomeDataSourceImpl
import com.ch.al_mirats.presentation.home.adapter.HomeAdapter
import com.ch.al_mirats.presentation.settings.SettingsFragment

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val adapterHome: HomeAdapter by lazy {
        HomeAdapter {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()
        darkMode()
    }

//    private fun setupRecyclerView() {
//        binding.rvHome.adapter = adapterHome
//        adapterHome.setItems(DummyHomeDataSourceImpl().getHomeData())
//    }

    private fun darkMode(){
        binding.ivDarkMode.setOnClickListener {
            SettingsFragment().show(childFragmentManager, null)
        }
    }

}