package com.ch.al_mirats.presentation.kalkulator.harta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityHartaBinding


class HartaActivity : AppCompatActivity() {

    private val binding: ActivityHartaBinding by lazy {
        ActivityHartaBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        next()

    }

    private fun next(){
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, TableHartaActivity::class.java)
            startActivity(intent)
        }
    }



}