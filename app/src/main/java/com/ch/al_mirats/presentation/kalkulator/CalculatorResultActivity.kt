package com.ch.al_mirats.presentation.kalkulator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityCalculatorResultBinding
import com.ch.al_mirats.databinding.ActivityWarisBinding
import com.ch.al_mirats.utils.toCurrencyFormat

class CalculatorResultActivity : AppCompatActivity() {

    private val binding: ActivityCalculatorResultBinding by lazy {
        ActivityCalculatorResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        finalResult()

        val harta = intent.getLongExtra("HARTA", 0)
        val hutang = intent.getLongExtra("HUTANG", 0)
        val wasiat = intent.getLongExtra("WASIAT", 0)
        val jenazah = intent.getLongExtra("JENAZAH", 0)
        val gender = intent.getStringExtra("GENDER")
        val total = intent.getLongExtra("TOTAL", 0)
        val bapak = intent.getBooleanExtra("BAPAK", false)
        val ibu = intent.getBooleanExtra("IBU", false)
        val posisi = intent.getStringExtra("POSISI")
        val anakLaki = intent.getLongExtra("ANAK_LAKI", 0)
        val anakPerempuan = intent.getLongExtra("ANAK_PEREMPUAN", 0)
    }

    private fun finalResult(){

    }

}