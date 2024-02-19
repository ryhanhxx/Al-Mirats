package com.ch.al_mirats.presentation.feedback

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {
    private val binding: ActivityFeedbackBinding by lazy{
        ActivityFeedbackBinding.inflate(layoutInflater)
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