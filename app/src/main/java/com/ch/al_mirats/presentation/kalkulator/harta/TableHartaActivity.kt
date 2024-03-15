package com.ch.al_mirats.presentation.kalkulator.harta

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityTableHartaBinding
import com.ch.al_mirats.presentation.kalkulator.gender.JenisKelaminPewarisActivity
import com.ch.al_mirats.utils.ConvertToRupiah

class TableHartaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTableHartaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableHartaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title: TextView = binding.txtTitle
        val buttonBack: ImageView = binding.btnBack
        val buttonDelete: ImageView = binding.btnDelete
        buttonDelete.visibility = View.GONE

        title.text = "Harta"

        binding.fabZoomIn.visibility = View.VISIBLE
        binding.fabZoomOut.visibility = View.GONE

        var harta = intent.getLongExtra("harta", 0)
        val hutang = intent.getLongExtra("hutang", 0)
        val wasiat = intent.getLongExtra("wasiat", 0)
        val biayaPerawatanJenazah = intent.getLongExtra("biayaPerawatanJenazah",0)

        val angkaHarta = ConvertToRupiah().convertToRupiahFormat(harta.toDouble())
        val angkaHutang = ConvertToRupiah().convertToRupiahFormat(hutang.toDouble())
        val angkaWasiat = ConvertToRupiah().convertToRupiahFormat(wasiat.toDouble())
        val angkaBiayaPerawatanJenazah = ConvertToRupiah().convertToRupiahFormat(biayaPerawatanJenazah.toDouble())
        val angkaHartaBersih = ConvertToRupiah().convertToRupiahFormat((harta - hutang - wasiat - biayaPerawatanJenazah).toDouble())

        val fragmentDefault = TableHartaDefaultFragment()
        fragmentDefault.setData(angkaHarta, angkaHutang, angkaWasiat, angkaBiayaPerawatanJenazah, angkaHartaBersih)
        loadFragment(fragmentDefault)

        binding.fabZoomIn.setOnClickListener {
            val fragment = TableHartaZoomFragment()
            fragment.setData(angkaHarta, angkaHutang, angkaWasiat, angkaBiayaPerawatanJenazah, angkaHartaBersih)
            loadFragment(fragment)
            binding.fabZoomIn.visibility = View.GONE
            binding.fabZoomOut.visibility = View.VISIBLE
        }
        binding.fabZoomOut.setOnClickListener {
            val fragment = TableHartaDefaultFragment()
            fragment.setData(angkaHarta, angkaHutang, angkaWasiat, angkaBiayaPerawatanJenazah, angkaHartaBersih)
            loadFragment(fragment)
            binding.fabZoomIn.visibility = View.VISIBLE
            binding.fabZoomOut.visibility = View.GONE
        }
        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this, JenisKelaminPewarisActivity::class.java)
            intent.putExtra("harta", harta)
            intent.putExtra("hutang", hutang)
            intent.putExtra("wasiat", wasiat)
            intent.putExtra("biayaPerawatanJenazah", biayaPerawatanJenazah)
            startActivity(intent)
        }
        buttonBack.setOnClickListener {
            finish()
        }
    }
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val intent = Intent(this, HartaActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }
    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flHarta, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}