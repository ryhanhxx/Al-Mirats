package com.ch.al_mirats.presentation.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private val binding: ActivityCalculatorBinding by lazy {
        ActivityCalculatorBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickBack()
        submitData()
    }

    private fun setOnClickBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun submitData() {
        binding.rgGender.setOnCheckedChangeListener{ _, id ->
            var genderState = ""
            if( id == R.id.rb_laki){
                genderState = "Laki-Laki"
            }else if (id == R.id.rb_perempuan){
                genderState = "Perempuan}"
            }

        binding.btnSubmit.setOnClickListener {
                if(binding.etHarta.toString().isEmpty()){
                    Toast.makeText(this, "HARTA HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
                }else if(binding.etHutang.toString().isEmpty()){
                    Toast.makeText(this, "HUTANG HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
                }else if (binding.etWasiat.toString().isEmpty()){
                    Toast.makeText(this, "WASIAT HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
                }else if (binding.etJenazah.toString().isEmpty()) {
                    Toast.makeText(this, "PERAWATAN JENAZAH HARUS DIISI !", Toast.LENGTH_SHORT).show().toString()
                }else {
                    val harta = binding.etHarta.text.toString().toLong()
                    val hutang = binding.etHutang.text.toString().toLong()
                    val wasiat = binding.etWasiat.text.toString().toLong()
                    val jenazah = binding.etJenazah.text.toString().toLong()

                    // Menghitung total jumlah (kecuali gender)
                    val total = harta - hutang - wasiat - jenazah
                    if(harta > hutang && harta > wasiat && harta > jenazah){
                        Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show().toString()
                    }else {
                        Toast.makeText(this, "HARTA HABIS !", Toast.LENGTH_SHORT).show().toString()
                    }

                    val sendHarta = Intent(this, HartaResultActivity::class.java).apply {
                        putExtra("HARTA", harta)
                        putExtra("HUTANG", hutang)
                        putExtra("WASIAT", wasiat)
                        putExtra("JENAZAH", jenazah)
                        putExtra("GENDER", genderState)
                        putExtra("TOTAL", total)
                    }
                    startActivity(sendHarta)
                }
            }
        }
    }


}