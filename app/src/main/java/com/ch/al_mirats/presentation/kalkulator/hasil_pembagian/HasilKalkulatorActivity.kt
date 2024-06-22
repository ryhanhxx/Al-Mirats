package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

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
import com.ch.al_mirats.databinding.ActivityHasilKalkulatorBinding
import com.ch.al_mirats.model.WarisData
import com.ch.al_mirats.presentation.kalkulator.data_waris.WarisUtamaActivity
import com.ch.al_mirats.presentation.kalkulator.gender.JenisKelaminPewarisActivity
import com.ch.al_mirats.presentation.main.MainActivity
import com.ch.al_mirats.utils.ConvertToRupiah

class HasilKalkulatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilKalkulatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilKalkulatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonBack: ImageView = binding.btnBack
        val buttonDelete: ImageView = binding.btnDelete
        buttonDelete.visibility = View.GONE

        binding.fabZoomIn.visibility = View.VISIBLE
        binding.fabZoomOut.visibility = View.GONE

        val hutang = intent.getLongExtra("hutang", 0).toDouble()
        val wasiat = intent.getLongExtra("wasiat", 0).toDouble()
        val biayaPerawatanJenazah = intent.getLongExtra("biayaPerawatanJenazah",0).toDouble()
        val totalHarta = intent.getLongExtra("harta", 0).toDouble()
        var harta = (totalHarta - (hutang + biayaPerawatanJenazah + wasiat))

        val jenisKelaminPewaris = intent.getStringExtra("jenisKelaminPewaris")
        val adaAyah = intent.getBooleanExtra("ayah", false)
        val adaIbu = intent.getBooleanExtra("ibu", false)
        val adaSuami = intent.getBooleanExtra("suami", false)
        val adaAyahnyaAyah = intent.getBooleanExtra("ayahnya_ayah", false)
        val adaIbunyaAyah = intent.getBooleanExtra("ibunya_ayah", false)
        val adaSaudaraSeayahSeibu = intent.getIntExtra("saudara_seayah_seibu", 0)
        val adaSaudariSeayahSeibu = intent.getIntExtra("saudari_seayah_seibu", 0)
        val adaIbunyaIbu = intent.getBooleanExtra("ibunya_ibu", false)
        val istri = intent.getIntExtra("istri", 0)
        val anakLaki = intent.getIntExtra("anakLaki", 0)
        val anakPerempuan = intent.getIntExtra("anakPerempuan", 0)
        val cucuLaki = intent.getIntExtra("cucuLaki", 0)
        val cucuPerempuan = intent.getIntExtra("cucuPerempuan", 0)

        var bagianIbu = ""
        var bagianAyah = ""
        var bagianSuami = ""
        var bagianAyahnyaAyah = ""
        var bagianIbunyaAyah = ""
        var bagianSaudaraSeayahSeibu = ""
        var bagianSaudariSeayahSeibu = ""
        var bagianIbunyaIbu = ""
        var bagianIstri = ""
        var bagianAnakPerempuan = ""
        var bagianAnakLaki = ""
        var bagianCucuLaki = ""
        var bagianCucuPerempuan = ""

        var hartaAyah = 0.0
        var hartaIbu = 0.0
        var hartaSuami = 0.0
        var hartaAyahnyaAyah = 0.0
        var hartaIbunyaAyah = 0.0
        var hartaSaudaraSeayahSeibu = 0.0
        var hartaSaudariSeayahSeibu = 0.0
        var hartaIbunyaIbu = 0.0
        var hartaIstri = 0.0
        var hartaAnakLaki = 0.0
        var hartaAnakPerempuan = 0.0
        var hartaCucuLaki = 0.0
        var hartaCucuPerempuan = 0.0

        var sisaHarta = 0.0

        sisaHarta = harta

        if(!adaSuami && istri == 0) {
            val result = TidakAdaSuamiDanIstriSamaDenganNolLogic(
                hutang = hutang,
                wasiat = wasiat,
                biayaPerawatanJenazah = biayaPerawatanJenazah,
                totalHarta = totalHarta,
                harta = harta,

                jenisKelaminPewaris = jenisKelaminPewaris,
                adaAyah = adaAyah,
                adaIbu = adaIbu,
                adaSuami = adaSuami,
                adaAyahnyaAyah = adaAyahnyaAyah,
                adaIbunyaAyah = adaIbunyaAyah,
                adaSaudaraSeayahSeibu = adaSaudaraSeayahSeibu,
                adaSaudariSeayahSeibu = adaSaudariSeayahSeibu,
                adaIbunyaIbu = adaIbunyaIbu,
                istri = istri,
                anakLaki = anakLaki,
                anakPerempuan = anakPerempuan,
                cucuLaki = cucuLaki,
                cucuPerempuan = cucuPerempuan
            )

            bagianIbu = result.bagianIbu
            bagianAyah = result.bagianAyah
            bagianSuami = result.bagianSuami
            bagianAyahnyaAyah = result.bagianAyahnyaAyah
            bagianIbunyaAyah = result.bagianIbunyaAyah
            bagianSaudaraSeayahSeibu = result.bagianSaudaraSeayahSeibu
            bagianSaudariSeayahSeibu = result.bagianSaudariSeayahSeibu
            bagianIbunyaIbu = result.bagianIbunyaIbu
            bagianIstri = result.bagianIstri
            bagianAnakPerempuan = result.bagianAnakPerempuan
            bagianAnakLaki = result.bagianAnakLaki
            bagianCucuLaki = result.bagianCucuLaki
            bagianCucuPerempuan = result.bagianCucuPerempuan

            hartaAyah = result.hartaAyah
            hartaIbu = result.hartaIbu
            hartaSuami = result.hartaSuami
            hartaAyahnyaAyah = result.hartaAyahnyaAyah
            hartaIbunyaAyah = result.hartaIbunyaAyah
            hartaSaudaraSeayahSeibu = result.hartaSaudaraSeayahSeibu
            hartaSaudariSeayahSeibu = result.hartaSaudariSeayahSeibu
            hartaIbunyaIbu = result.hartaIbunyaIbu
            hartaIstri = result.hartaIstri
            hartaAnakLaki = result.hartaAnakLaki
            hartaAnakPerempuan = result.hartaAnakPerempuan
            hartaCucuLaki = result.hartaCucuLaki
            hartaCucuPerempuan = result.hartaCucuPerempuan

            sisaHarta = result.sisaHarta
        }
        if(adaSuami || istri > 0) {
            val result = AdaSuamiAtauIstriLebihDariNolLogic(
                hutang = hutang,
                wasiat = wasiat,
                biayaPerawatanJenazah = biayaPerawatanJenazah,
                totalHarta = totalHarta,
                harta = harta,

                jenisKelaminPewaris = jenisKelaminPewaris,
                adaAyah = adaAyah,
                adaIbu = adaIbu,
                adaSuami = adaSuami,
                adaAyahnyaAyah = adaAyahnyaAyah,
                adaIbunyaAyah = adaIbunyaAyah,
                adaSaudaraSeayahSeibu = adaSaudaraSeayahSeibu,
                adaSaudariSeayahSeibu = adaSaudariSeayahSeibu,
                adaIbunyaIbu = adaIbunyaIbu,
                istri = istri,
                anakLaki = anakLaki,
                anakPerempuan = anakPerempuan,
                cucuLaki = cucuLaki,
                cucuPerempuan = cucuPerempuan
            )

            bagianIbu = result.bagianIbu
            bagianAyah = result.bagianAyah
            bagianSuami = result.bagianSuami
            bagianAyahnyaAyah = result.bagianAyahnyaAyah
            bagianIbunyaAyah = result.bagianIbunyaAyah
            bagianSaudaraSeayahSeibu = result.bagianSaudaraSeayahSeibu
            bagianSaudariSeayahSeibu = result.bagianSaudariSeayahSeibu
            bagianIbunyaIbu = result.bagianIbunyaIbu
            bagianIstri = result.bagianIstri
            bagianAnakPerempuan = result.bagianAnakPerempuan
            bagianAnakLaki = result.bagianAnakLaki
            bagianCucuLaki = result.bagianCucuLaki
            bagianCucuPerempuan = result.bagianCucuPerempuan

            hartaAyah = result.hartaAyah
            hartaIbu = result.hartaIbu
            hartaSuami = result.hartaSuami
            hartaAyahnyaAyah = result.hartaAyahnyaAyah
            hartaIbunyaAyah = result.hartaIbunyaAyah
            hartaSaudaraSeayahSeibu = result.hartaSaudaraSeayahSeibu
            hartaSaudariSeayahSeibu = result.hartaSaudariSeayahSeibu
            hartaIbunyaIbu = result.hartaIbunyaIbu
            hartaIstri = result.hartaIstri
            hartaAnakLaki = result.hartaAnakLaki
            hartaAnakPerempuan = result.hartaAnakPerempuan
            hartaCucuLaki = result.hartaCucuLaki
            hartaCucuPerempuan = result.hartaCucuPerempuan

            sisaHarta = result.sisaHarta
        }

        val data: ArrayList<WarisData> = ArrayList()

        if (adaIbu || adaAyah || adaSuami || istri >= 1 || anakPerempuan >= 1 || anakLaki >= 1 || cucuLaki >= 1 || cucuPerempuan >= 1 || adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1){
            if (adaAyah) {
                data.add(WarisData(getString(R.string.txt_ayah),bagianAyah, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaAyah), ConvertToRupiah().convertToRupiahFormat(hartaAyah)))
            }
            if (adaIbu){
                data.add(WarisData(getString(R.string.txt_ibu),bagianIbu, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbu), ConvertToRupiah().convertToRupiahFormat(hartaIbu)))
            }
            if(jenisKelaminPewaris == "Laki-Laki"){
                if (istri >= 1) {
                    data.add(WarisData(getString(R.string.txt_istri),bagianIstri, istri,
                        ConvertToRupiah().convertToRupiahFormat(hartaIstri), ConvertToRupiah().convertToRupiahFormat(hartaIstri/istri)))
                }
            }else{
                if (adaSuami) {
                    data.add(WarisData(getString(R.string.txt_suami),bagianSuami, 1,
                        ConvertToRupiah().convertToRupiahFormat(hartaSuami), ConvertToRupiah().convertToRupiahFormat(hartaSuami)))
                }
            }
            if (adaAyahnyaAyah) {
                data.add(
                    WarisData(getString(R.string.txt_ayah_dari_ayah), bagianAyahnyaAyah, 1,
                        ConvertToRupiah().convertToRupiahFormat(hartaAyahnyaAyah), ConvertToRupiah().convertToRupiahFormat(hartaAyahnyaAyah))
                )
            }
            if (adaIbunyaAyah) {
                data.add(WarisData(getString(R.string.txt_ibu_dari_ayah), bagianIbunyaAyah, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbunyaAyah), ConvertToRupiah().convertToRupiahFormat(hartaIbunyaAyah)))
            }
            if (adaSaudaraSeayahSeibu >= 1) {
                data.add(WarisData(getString(R.string.txt_saudara_seayah_seibu), bagianSaudaraSeayahSeibu, adaSaudaraSeayahSeibu,
                    ConvertToRupiah().convertToRupiahFormat(hartaSaudaraSeayahSeibu), ConvertToRupiah().convertToRupiahFormat(hartaSaudaraSeayahSeibu/adaSaudaraSeayahSeibu)))
            }
            if (adaSaudariSeayahSeibu >= 1) {
                data.add(WarisData(getString(R.string.txt_saudari_seayah_seibu), bagianSaudariSeayahSeibu, adaSaudariSeayahSeibu,
                    ConvertToRupiah().convertToRupiahFormat(hartaSaudariSeayahSeibu), ConvertToRupiah().convertToRupiahFormat(hartaSaudariSeayahSeibu/adaSaudariSeayahSeibu)))
            }
            if (adaIbunyaIbu) {
                data.add(WarisData(getString(R.string.txt_ibu_dari_ibu), bagianIbunyaIbu, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbunyaIbu), ConvertToRupiah().convertToRupiahFormat(hartaIbunyaIbu)))
            }
            if (anakLaki >= 1) {
                data.add(WarisData(getString(R.string.txt_anak_laki),bagianAnakLaki, anakLaki,
                    ConvertToRupiah().convertToRupiahFormat(hartaAnakLaki), ConvertToRupiah().convertToRupiahFormat(hartaAnakLaki/anakLaki)))
            }
            if (anakPerempuan >= 1) {
                data.add(WarisData(getString(R.string.txt_anak_perempuan),bagianAnakPerempuan, anakPerempuan,
                    ConvertToRupiah().convertToRupiahFormat(hartaAnakPerempuan), ConvertToRupiah().convertToRupiahFormat(hartaAnakPerempuan/anakPerempuan)))
            }
            if (cucuLaki >= 1) {
                data.add(WarisData(getString(R.string.txt_cucu_laki),bagianCucuLaki, cucuLaki,
                    ConvertToRupiah().convertToRupiahFormat(hartaCucuLaki), ConvertToRupiah().convertToRupiahFormat(hartaCucuLaki/cucuLaki)))
            }
            if (cucuPerempuan >= 1) {
                data.add(WarisData(getString(R.string.txt_cucu_perempuan),bagianCucuPerempuan, cucuPerempuan,
                    ConvertToRupiah().convertToRupiahFormat(hartaCucuPerempuan), ConvertToRupiah().convertToRupiahFormat(hartaCucuPerempuan/cucuPerempuan)))
            }
        } else{
            data.add(WarisData("Baitul Mal","1/1", 0,
                ConvertToRupiah().convertToRupiahFormat(harta), ConvertToRupiah().convertToRupiahFormat(harta)))
        }
        if (!adaIbu && !adaAyah && (adaSuami || istri >= 1) && anakPerempuan < 1 && anakLaki < 1 && !adaAyahnyaAyah && !adaIbunyaAyah && adaSaudaraSeayahSeibu < 1 && adaSaudariSeayahSeibu < 1 && cucuLaki < 1 && cucuPerempuan < 1 && !adaIbunyaIbu){
            data.add(WarisData("Baitul Mal", "Ashobah", 0, ConvertToRupiah().convertToRupiahFormat(sisaHarta), ConvertToRupiah().convertToRupiahFormat(sisaHarta)))
        }


        val fragmentDefault = TablePembagianDefaultFragment()
        fragmentDefault.setData(data, ConvertToRupiah().convertToRupiahFormat(harta))
        loadFragment(fragmentDefault)

        val fragmentZoom = TablePembagianZoomFragment()
        fragmentZoom.setData(data, ConvertToRupiah().convertToRupiahFormat(harta))

        binding.fabZoomIn.setOnClickListener {
            loadFragment(fragmentZoom)
            binding.fabZoomIn.visibility = View.GONE
            binding.fabZoomOut.visibility = View.VISIBLE
        }
        binding.fabZoomOut.setOnClickListener {
            loadFragment(fragmentDefault)
            binding.fabZoomIn.visibility = View.VISIBLE
            binding.fabZoomOut.visibility = View.GONE
        }

        buttonBack.setOnClickListener {
            finish()
        }
        binding.btnLanjut.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val intent = Intent(this, WarisUtamaActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flPembagian, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}