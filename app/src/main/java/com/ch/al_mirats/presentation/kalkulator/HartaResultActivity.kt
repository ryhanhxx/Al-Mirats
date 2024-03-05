package com.ch.al_mirats.presentation.kalkulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityHartaResultBinding

class HartaResultActivity : AppCompatActivity() {

    private val binding: ActivityHartaResultBinding by lazy {
        ActivityHartaResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}