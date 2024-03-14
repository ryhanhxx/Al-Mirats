package com.ch.al_mirats.presentation.kalkulator.gender

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityHartaBinding
import com.ch.al_mirats.databinding.ActivityJenisKelaminPewarisBinding
import com.ch.al_mirats.presentation.kalkulator.data_waris.WarisUtamaActivity

class JenisKelaminPewarisActivity : AppCompatActivity() {

    private val binding: ActivityJenisKelaminPewarisBinding by lazy {
        ActivityJenisKelaminPewarisBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        next()
    }

    private fun next() {
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, WarisUtamaActivity::class.java)
            startActivity(intent)
        }
    }
}