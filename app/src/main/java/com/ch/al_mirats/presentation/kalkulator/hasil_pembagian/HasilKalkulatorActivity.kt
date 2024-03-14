package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityHasilKalkulatorBinding
import com.ch.al_mirats.presentation.kalkulator.gender.JenisKelaminPewarisActivity
import com.ch.al_mirats.presentation.main.MainActivity

class HasilKalkulatorActivity : AppCompatActivity() {

    private val binding: ActivityHasilKalkulatorBinding by lazy {
        ActivityHasilKalkulatorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        next()
    }

    private fun next(){
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }


}