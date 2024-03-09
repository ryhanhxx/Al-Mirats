package com.ch.al_mirats.presentation.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityWarisBinding

class WarisActivity : AppCompatActivity() {

    private val binding: ActivityWarisBinding by lazy {
        ActivityWarisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var gender = ""

        val harta = intent.getLongExtra("HARTA", 0)
        val hutang = intent.getLongExtra("HUTANG", 0)
        val wasiat = intent.getLongExtra("WASIAT", 0)
        val jenazah = intent.getLongExtra("JENAZAH", 0)
        gender = intent.getStringExtra("GENDER").toString()
        val total = intent.getLongExtra("TOTAL", 0)

        val bapak = binding.cbBapak.isChecked
        val ibu = binding.cbIbu.isChecked


        binding.rgPosisi.setOnCheckedChangeListener { _, id ->
            var posisi = ""
            if (id == R.id.rb_suami) {
                posisi = "Suami"
            } else if (id == R.id.rb_istri) {
                posisi = "Istri"
            } else {
                posisi = "Suami"
            }

            binding.btnSubmit.setOnClickListener {
                if (binding.etAnakLaki.toString().isEmpty()) {
                    Toast.makeText(this, "ANAK LAKI HARUS DIISI !", Toast.LENGTH_SHORT).show()
                        .toString()
                } else if (binding.etAnakPerempuan.toString().isEmpty()) {
                    Toast.makeText(this, "ANAK PEREMPUAN HARUS DIISI !", Toast.LENGTH_SHORT).show()
                        .toString()
                } else {
                    //TODO : RUMUS
                    val anakLaki = binding.etAnakLaki.text.toString().toLong()
                    val anakPerempuan = binding.etAnakPerempuan.text.toString().toLong()
                    val sendHarta = Intent(this, CalculatorResultActivity::class.java).apply {
                        putExtra("HARTA", harta)
                        putExtra("HUTANG", hutang)
                        putExtra("WASIAT", wasiat)
                        putExtra("JENAZAH", jenazah)
                        putExtra("GENDER", gender)
                        putExtra("TOTAL", total)
                        putExtra("BAPAK", bapak)
                        putExtra("IBU", ibu)
                        putExtra("POSISI", posisi)
                        putExtra("ANAK_LAKI", anakLaki)
                        putExtra("ANAK_PEREMPUAN", anakPerempuan)
                    }
                    startActivity(sendHarta)
                }
            }
        }
    }
}