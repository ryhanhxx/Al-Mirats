package com.ch.al_mirats.presentation.kalkulator.harta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityTableHartaBinding
import com.ch.al_mirats.presentation.kalkulator.gender.JenisKelaminPewarisActivity

class TableHartaActivity : AppCompatActivity() {

    private val binding: ActivityTableHartaBinding by lazy {
        ActivityTableHartaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        next()
    }

    private fun next(){
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, JenisKelaminPewarisActivity::class.java)
            startActivity(intent)
        }
    }


}