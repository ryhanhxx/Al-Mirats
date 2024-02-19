package com.ch.al_mirats.presentation.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
    }
}