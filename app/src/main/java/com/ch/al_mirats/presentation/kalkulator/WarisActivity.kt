package com.ch.al_mirats.presentation.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityWarisBinding
import com.ch.al_mirats.utils.toCurrencyFormat

class WarisActivity : AppCompatActivity() {

    private val binding: ActivityWarisBinding by lazy {
        ActivityWarisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val harta = intent.getLongExtra("HARTA", 0).toCurrencyFormat()
//        val hutang = intent.getLongExtra("HUTANG", 0).toCurrencyFormat()
//        val wasiat = intent.getLongExtra("WASIAT", 0).toCurrencyFormat()
//        val jenazah = intent.getLongExtra("JENAZAH", 0).toCurrencyFormat()
//        val gender = intent.getStringExtra("GENDER").toString()
//        val total = intent.getLongExtra("TOTAL", 0).toCurrencyFormat()

        val harta = intent.getStringExtra("HARTA")
        val hutang = intent.getStringExtra("HUTANG")
        val wasiat = intent.getStringExtra("WASIAT")
        val jenazah = intent.getStringExtra("JENAZAH")
        val gender = intent.getStringExtra("GENDER")
        val total = intent.getStringExtra("TOTAL")

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
                    var bapak = binding.cbBapak.isChecked
                    var ibu = binding.cbIbu.isChecked
                    var anakLaki = binding.etAnakLaki.text.toString().toInt()
                    var anakPerempuan = binding.etAnakPerempuan.text.toString().toInt()

                    var valueIbu = ""
                    var valueAyah = ""
                    var valueSuami = ""
                    var valueIstri = ""
                    var valueAnakPerempuan = ""
                    var valueAnakLaki = ""

                    var hartaAyah = 0
                    var hartaIbu = 0
                    var hartaSuami = 0
                    var hartaIstri = 0
                    var hartaAnakLaki = 0
                    var hartaAnakPerempuan = 0

                    var sisaHarta = 0

                    //Kelamin Pewaris Laki
                    if (gender.equals("Laki-Laki")) {
                        if (bapak && ibu) {//Memiliki Bapak dan Ibu
                            if (posisi.equals("Suami")) { //Posisi sebagai suami
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else if (posisi.equals("Istri")) { //Posisi sebagai istri
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else {
                                Toast.makeText(this, "POSISI ERROR!", Toast.LENGTH_SHORT).show()
                                    .toString()
                            }
                        } else if (bapak && !ibu) { //Memiliki Bapak, Tidak ada ibu
                            if (posisi.equals("Suami")) { //Posisi sebagai suami
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else if (posisi.equals("Istri")) { //Posisi sebagai istri
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else {
                                Toast.makeText(this, "POSISI ERROR!", Toast.LENGTH_SHORT).show()
                                    .toString()
                            }
                        } else if (!bapak && ibu) { //Mmeiliki ibu, Tidak ada Bapak
                            if (posisi.equals("Suami")) { //Posisi sebagai suami
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else if (posisi.equals("Istri")) { //Posisi Sebagai Istri
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else {
                                Toast.makeText(this, "POSISI ERROR!", Toast.LENGTH_SHORT).show()
                                    .toString()
                            }
                        } else //Tidak Memiliki Bapak dan Ibu {
                            if (posisi.equals("Suami")) { //Posisi sebagai suami
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else if (posisi.equals("Istri")) { //Posisi sebagai istri
                                if (anakLaki >= 0 && anakPerempuan >= 0) {

                                } else {
                                    Toast.makeText(this, "ISI JUMLAH ANAK!", Toast.LENGTH_SHORT)
                                        .show().toString()
                                }
                            } else {
                                Toast.makeText(this, "POSISI ERROR!", Toast.LENGTH_SHORT).show()
                                    .toString()
                            }
                    }

                    //Kelamin Pewaris Perempuan
                    else if (gender.equals("Perempuan")) {

                    }

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