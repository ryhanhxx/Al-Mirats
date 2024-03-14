package com.ch.al_mirats.presentation.kalkulator.data_waris

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityWarisUtamaBinding
import com.ch.al_mirats.presentation.kalkulator.gender.JenisKelaminPewarisActivity
import com.ch.al_mirats.presentation.kalkulator.hasil_pembagian.HasilKalkulatorActivity

class WarisUtamaActivity : AppCompatActivity() {

    private val binding: ActivityWarisUtamaBinding by lazy {
        ActivityWarisUtamaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        next()
    }

    private fun next(){
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, HasilKalkulatorActivity::class.java)
            startActivity(intent)
        }
    }
}