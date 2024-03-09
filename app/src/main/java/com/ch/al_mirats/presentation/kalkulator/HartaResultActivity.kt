package com.ch.al_mirats.presentation.kalkulator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityHartaResultBinding
import com.ch.al_mirats.utils.toCurrencyFormat

class HartaResultActivity : AppCompatActivity() {

    private val binding: ActivityHartaResultBinding by lazy {
        ActivityHartaResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val harta = intent.getLongExtra("HARTA", 0).toCurrencyFormat()
        val hutang = intent.getLongExtra("HUTANG", 0).toCurrencyFormat()
        val wasiat = intent.getLongExtra("WASIAT", 0).toCurrencyFormat()
        val jenazah = intent.getLongExtra("JENAZAH", 0).toCurrencyFormat()
        val gender = intent.getStringExtra("GENDER").toString()
        val total = intent.getLongExtra("TOTAL", 0).toCurrencyFormat()

        binding.tvHarta.text = harta
        binding.tvHutang.text = hutang
        binding.tvWasiat.text = wasiat
        binding.tvJenazah.text = jenazah
        binding.tvGender.text = gender
        binding.tvTotal.text= total

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this, WarisActivity::class.java).apply {
                putExtra("HARTA", harta)
                putExtra("HUTANG", hutang)
                putExtra("WASIAT", wasiat)
                putExtra("JENAZAH", jenazah)
                putExtra("GENDER", gender)
                putExtra("TOTAL", total)
            }
            startActivity(intent)
        }
    }


}