package com.ch.al_mirats.presentation.kalkulator

import android.os.Bundle
import android.view.View
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

        val harta = intent.getStringExtra("HARTA")
        val hutang = intent.getStringExtra("HUTANG")
        val wasiat = intent.getStringExtra("WASIAT")
        val jenazah = intent.getStringExtra("JENAZAH")
        val gender = intent.getStringExtra("GENDER")
        val total = intent.getStringExtra("TOTAL")
        val bapak = intent.getStringExtra("BAPAK")
        val ibu = intent.getStringExtra("IBU")
        val posisi = intent.getStringExtra("POSISI")
        val anakLaki = intent.getStringExtra("ANAK_LAKI")
        val anakPerempuan = intent.getStringExtra("ANAK_PEREMPUAN")

//        binding.cvHasil2.visibility = View.INVISIBLE
//        binding.cvHasil3.visibility = View.INVISIBLE
//        binding.cvHasil4.visibility = View.INVISIBLE
    }


}