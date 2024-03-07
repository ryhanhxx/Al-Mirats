package com.ch.al_mirats.presentation.kalkulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityWarisBinding

class WarisActivity : AppCompatActivity() {

    private val binding: ActivityWarisBinding by lazy {
        ActivityWarisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        submitData()
    }

    private fun submitData() {
        binding.btnSubmit.setOnClickListener {
            if (binding.etAnakLaki.toString().isEmpty()) {
                Toast.makeText(this, "ANAK LAKI HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
            } else if (binding.etAnakPerempuan.toString().isEmpty()) {
                Toast.makeText(this, "ANAK PEREMPUAN HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
            } else {

            }
        }
    }
}