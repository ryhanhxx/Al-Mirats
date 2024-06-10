package com.ch.al_mirats.presentation.kalkulator.gender

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityJenisKelaminPewarisBinding
import com.ch.al_mirats.presentation.kalkulator.data_waris.AppDatabase
import com.ch.al_mirats.presentation.kalkulator.data_waris.WarisDataDao
import com.ch.al_mirats.presentation.kalkulator.data_waris.WarisUtamaActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JenisKelaminPewarisActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJenisKelaminPewarisBinding
    private lateinit var warisDataDao: WarisDataDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisKelaminPewarisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonBack: ImageView = binding.btnBack
        val buttonDelete: ImageView = binding.btnDelete
        val rgJenisKelaminPewaris: RadioGroup = binding.rgJenisKelaminPewaris
        buttonDelete.visibility = View.GONE

        val harta = intent.getLongExtra("harta", 0)
        val hutang = intent.getLongExtra("hutang", 0)
        val wasiat = intent.getLongExtra("wasiat", 0)
        val biayaPerawatanJenazah = intent.getLongExtra("biayaPerawatanJenazah", 0)

        warisDataDao = AppDatabase.getDatabase(this).warisDataDao()
        checkIfDatabaseNotEmpty()

        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, WarisUtamaActivity::class.java)
            intent.putExtra("harta", harta)
            intent.putExtra("hutang", hutang)
            intent.putExtra("wasiat", wasiat)
            intent.putExtra("biayaPerawatanJenazah", biayaPerawatanJenazah)
            val selectedRadioButtonId = rgJenisKelaminPewaris.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Silakan pilih Jenis Kelamin Pewaris!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val jenisKelaminPewaris: String = when (selectedRadioButtonId) {
                    R.id.rb_laki -> "Laki-Laki"
                    R.id.rb_perempuan -> "Perempuan"
                    else -> "Laki-Laki"
                }
                intent.putExtra("jenisKelaminPewaris", jenisKelaminPewaris)
                startActivity(intent)

            }


        }
        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun checkIfDatabaseNotEmpty() {
        lifecycleScope.launch {
            val isDatabaseNotEmpty = withContext(Dispatchers.IO) {
                warisDataDao.isDataExist() > 0
            }

            if (isDatabaseNotEmpty) {
                displayWarisData()
            } else {
                Log.d("YourActivity", "Database is empty.")
            }
        }
    }

    private fun displayWarisData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val loadedWarisData = warisDataDao.getAllWarisData()
            var jenisKelamin = ""

            for (warisData in loadedWarisData) {
                jenisKelamin = warisData.jenisKelamin
            }
            withContext(Dispatchers.Main) {
                if (jenisKelamin == "Laki-Laki") {
                    binding.rbLaki.isChecked = true
                } else if (jenisKelamin == "Perempuan") {
                    binding.rbPerempuan.isChecked = true
                }
            }
        }
    }
}