package com.ch.al_mirats.presentation.kalkulator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityCalculatorBinding
import com.ch.al_mirats.utils.toCurrencyFormat

class CalculatorActivity : AppCompatActivity() {

    private val binding: ActivityCalculatorBinding by lazy {
        ActivityCalculatorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickBack()
        submitData()
    }

    private fun setOnClickBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun submitData() {

    }
}