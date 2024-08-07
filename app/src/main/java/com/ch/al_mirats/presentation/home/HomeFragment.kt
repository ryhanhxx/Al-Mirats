package com.ch.al_mirats.presentation.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.FragmentHomeBinding
import com.ch.al_mirats.dummy.DummyTopMateriDataSourceImpl
import com.ch.al_mirats.model.Language
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.about.AboutActivity
import com.ch.al_mirats.presentation.feedback.FeedbackActivity
import com.ch.al_mirats.presentation.home.adapter.CarouselAdapter
import com.ch.al_mirats.presentation.home.adapter.HomeAdapter
import com.ch.al_mirats.presentation.home.adapter.LanguageAdapter
import com.ch.al_mirats.presentation.kalkulator.harta.HartaActivity
import com.ch.al_mirats.presentation.main.MainActivity
import com.ch.al_mirats.presentation.materi.MateriActivity
import com.ch.al_mirats.presentation.settings.SettingsDialogFragment
import com.ch.al_mirats.presentation.tutorial.TutorialActivity
import java.util.Locale


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>

    private lateinit var adapterCarousel: CarouselAdapter

    private val adapterHome: HomeAdapter by lazy {
        HomeAdapter { materi: Materi ->
            navigateToDetailFragment(materi)
        }
    }

    private fun navigateToDetailFragment(materi: Materi) {
        MateriActivity.startActivity(requireContext(), materi)
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
        setupNavigate()
        setupCarousel()
        setupTransformer()
        runningCarousel()
        setSpinner()
    }

    private fun setupNavigate() {
        binding.ivSettings.setOnClickListener {
            SettingsDialogFragment().show(childFragmentManager, null)
        }

        binding.llFeedback.setOnClickListener {
            val intent = Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        }

        binding.llAbout.setOnClickListener {
            val intent = Intent(activity, AboutActivity::class.java)
            startActivity(intent)
        }

        binding.llTutorial.setOnClickListener {
            val intent = Intent(activity, TutorialActivity::class.java)
            startActivity(intent)
        }

        binding.llKalkulator.setOnClickListener {
            val intent = Intent(activity, HartaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setSpinner() {
        val myAdapter = LanguageAdapter(requireContext(), Language.getLanguageList())
        binding.spinner.adapter = myAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View?,
                position: Int,
                l: Long
            ) {
                val language = adapterView.adapter.getItem(position) as Language
                if (position != 0) {
                    setLocale(language.code)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }

    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)

        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.rvHome.adapter = adapterHome
        adapterHome.setItems(DummyTopMateriDataSourceImpl().getTopMateriData(requireContext()))
    }

    private fun runningCarousel() {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 5000)
            }
        })
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
    }

    private fun setupTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        binding.viewPager2.setPageTransformer(transformer)
    }

    private fun setupCarousel() {
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.img_ban1)
        imageList.add(R.drawable.img_ban2)
        imageList.add(R.drawable.img_ban3)

        adapterCarousel = CarouselAdapter(imageList, binding.viewPager2)

        binding.viewPager2.adapter = adapterCarousel
        binding.viewPager2.offscreenPageLimit = 3
        binding.viewPager2.clipToPadding = false
        binding.viewPager2.clipChildren = false
        binding.viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

//    private fun setupDarkMode() {
//        binding.swDarkMode.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            }
//        }
//    }
}