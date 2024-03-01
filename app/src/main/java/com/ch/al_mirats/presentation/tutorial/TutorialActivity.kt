package com.ch.al_mirats.presentation.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityTutorialBinding
import com.ch.al_mirats.dummy.DummyTutorialDataSourceImpl
import com.ch.al_mirats.model.Tutorial
import com.ch.al_mirats.presentation.tutorial.adapter.TutorialAdapter

class TutorialActivity : AppCompatActivity() {
    private val binding: ActivityTutorialBinding by lazy {
        ActivityTutorialBinding.inflate(layoutInflater)
    }

    private val adapterHome: TutorialAdapter by lazy {
        TutorialAdapter { tutorial: Tutorial ->
            navigateToDetailFragment(tutorial)
        }
    }

    private fun navigateToDetailFragment(tutorial: Tutorial) {
        TutorialDetailActivity.startActivity(this, tutorial)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()

        setOnClickBack()
    }

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        binding.rvTutorial.adapter = adapterHome
        adapterHome.submitData(DummyTutorialDataSourceImpl().getTutorialData(this))
    }
}