package com.ch.al_mirats.presentation.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityCalculatorBinding
import com.ch.al_mirats.databinding.ActivityMateriBinding

class CalculatorActivity : AppCompatActivity() {

    private val binding: ActivityCalculatorBinding by lazy {
        ActivityCalculatorBinding.inflate(layoutInflater)
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