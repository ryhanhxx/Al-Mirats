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
        getHarta()
        sendData()
    }

    private fun getHarta(){

        binding.tvHarta.text = intent.getLongExtra("HARTA", 0).toCurrencyFormat()
        binding.tvHutang.text = intent.getLongExtra("HUTANG", 0).toCurrencyFormat()
        binding.tvWasiat.text = intent.getLongExtra("WASIAT", 0).toCurrencyFormat()
        binding.tvJenazah.text = intent.getLongExtra("JENAZAH", 0).toCurrencyFormat()
        binding.tvGender.text = intent.getStringExtra("GENDER")
        binding.tvTotal.text= intent.getLongExtra("TOTAL", 0).toCurrencyFormat()
    }

    private fun sendData(){
        val intent = Intent(this, WarisActivity::class.java).apply {
            // Menambahkan data ke Intent
            putExtra("HARTA", intent.getLongExtra("HARTA", 0))
            putExtra("HUTANG", intent.getLongExtra("HUTANG", 0))
            putExtra("WASIAT", intent.getLongExtra("WASIAT", 0))
            putExtra("JENAZAH", intent.getLongExtra("JENAZAH", 0))
            putExtra("GENDER", intent.getStringExtra("GENDER"))
            putExtra("TOTAL", intent.getLongExtra("TOTAL", 0))
        }
// Memulai NextActivity dengan Intent yang telah dikonfigurasi
        startActivity(intent)
    }
}