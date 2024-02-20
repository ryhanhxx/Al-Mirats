package com.ch.al_mirats.presentation.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityAboutBinding
import com.ch.al_mirats.databinding.ActivityFeedbackBinding

class AboutActivity : AppCompatActivity() {
    private val binding: ActivityAboutBinding by lazy{
        ActivityAboutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickBack()

    }

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

}