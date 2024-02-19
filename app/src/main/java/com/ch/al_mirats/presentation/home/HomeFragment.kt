package com.ch.al_mirats.presentation.home

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.FragmentHomeBinding
import com.ch.al_mirats.dummy.DummyMateriDataSourceImpl
import com.ch.al_mirats.presentation.home.adapter.CarouselRVAdapter
import com.ch.al_mirats.presentation.home.adapter.HomeAdapter

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
        setupRecyclerView()
        darkMode()
        setupCarousel()
    }

    private fun setupRecyclerView() {
        binding.rvHome.adapter = adapterHome
        adapterHome.setItems(DummyMateriDataSourceImpl().getMateriData())
    }

    private fun setupCarousel() {
        val viewPager = binding.vBanner

        viewPager.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }

        val demoData = mutableListOf(
            R.drawable.img_banner,
            R.drawable.img_banner,
            R.drawable.img_banner
        )

        viewPager.adapter = CarouselRVAdapter(demoData)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((20 * Resources.getSystem().displayMetrics.density).toInt()))
        viewPager.setPageTransformer(compositePageTransformer)
    }

    private fun darkMode() {
//        binding.ivDarkMode.setOnClickListener {
//            SettingsFragment().show(childFragmentManager, null)
//        }
        binding.swDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}