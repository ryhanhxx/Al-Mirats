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



        binding.fabZoomIn.visibility = View.VISIBLE
        binding.fabZoomOut.visibility = View.GONE



        var keterangan = ""

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

        var sisaHarta = harta

        if(!adaSuami && istri == 0){
            if (!adaAyah && !adaIbu) {
                if (anakPerempuan == 0) {
                    if (anakLaki >= 1) {
                        if(adaAyahnyaAyah) {
                            bagianAyahnyaAyah = "1/6 → 1/6"
                            hartaAyahnyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaAyahnyaAyah
                        }

                        if(adaIbunyaAyah) {
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaAyah
                        }

                        if(adaIbunyaIbu) {
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaIbu
                        }
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = sisaHarta
                        bagianCucuLaki = "Mahjub"
                        bagianCucuPerempuan = "Mahjub"
                    }else if(anakLaki == 0){
                        if(cucuLaki == 0) {
                            if(adaSaudaraSeayahSeibu > 0 || adaSaudariSeayahSeibu > 0) {
                                if(adaSaudaraSeayahSeibu > 0 && adaSaudariSeayahSeibu > 0) {
                                    if(adaIbunyaIbu || adaIbunyaAyah || adaAyahnyaAyah) {
                                        sisaHarta = harta
                                        if(adaIbunyaIbu) {
                                            bagianIbunyaIbu = "1/6 → 1/6"
                                            hartaIbunyaIbu = harta*(1.0/6.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }
                                        if(adaIbunyaAyah) {
                                            bagianIbunyaAyah = "1/6 → 1/6"
                                            hartaIbunyaAyah = harta*(1.0/6.0)
                                            sisaHarta -= hartaIbunyaAyah
                                        }
                                        if(adaAyahnyaAyah) {
                                            bagianAyahnyaAyah = "Ashobah"
                                            hartaAyahnyaAyah = sisaHarta
                                            sisaHarta -= hartaAyahnyaAyah
                                        }
                                    }
                                    if(!adaAyahnyaAyah) {
                                        bagianSaudaraSeayahSeibu = "Ashobah"
                                        hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                        sisaHarta -= hartaSaudaraSeayahSeibu

                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaSaudariSeayahSeibu = sisaHarta
                                    }
                                }else {
                                    if(!adaAyahnyaAyah) {
                                        bagianSaudaraSeayahSeibu = "Ashobah"
                                        hartaSaudaraSeayahSeibu = sisaHarta
                                    }
                                }
                            }
                        }
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"

                        if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                            if(cucuPerempuan > 1 && cucuLaki == 0) {
                                bagianCucuPerempuan = "2/3 → 4/7"
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta*(1.0/7.0)
                                sisaHarta -= hartaAyahnyaAyah

                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta*(1.0/7.0)
                                sisaHarta -= hartaIbunyaAyah

                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta*(1.0/7.0)
                            }else {
                                bagianCucuPerempuan = "1/2 → 3/6"
                                if(cucuLaki >= 1) bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah

                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaIbunyaAyah

                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta*(1.0/6.0)
                            }
                            sisaHarta -= hartaIbunyaIbu
                        }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                            bagianCucuPerempuan = "1/2 → 6/13"
                            if(cucuPerempuan > 1) {
                                bagianCucuPerempuan = "2/3 → 4/6"
                            }
                            if(adaAyahnyaAyah && adaIbunyaAyah) {
                                if(cucuPerempuan > 1 || cucuLaki >= 1) {
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }else {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }
                            }

                            if(adaIbunyaAyah && adaIbunyaIbu) {
                                if(cucuPerempuan > 1 || cucuLaki >= 1) {
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                            }

                            if(adaIbunyaIbu && adaAyahnyaAyah) {
                                if(cucuPerempuan > 1 || cucuLaki >= 1) {
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                            }
                            if(cucuLaki >= 1) bagianCucuPerempuan = "Ashobah"

                        }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                            bagianCucuPerempuan = "1/2 → 3/4"
                            if(cucuPerempuan > 1) {
                                bagianCucuPerempuan = "2/3 → 4/5"
                            }
                            if(cucuLaki >= 1) {
                                bagianCucuPerempuan = "Ashobah"
                            }
                            if(adaAyahnyaAyah && (cucuLaki >= 1 || cucuPerempuan >= 1)) {
                                bagianAyahnyaAyah = "1/6 → 1/4"
                                hartaAyahnyaAyah = harta*(1.0/4.0)
                                if(cucuPerempuan > 1 && cucuLaki == 0) {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                }
                                if(cucuLaki >= 1) {
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                }
                                sisaHarta -= hartaAyahnyaAyah
                            }
                            if(adaIbunyaAyah && (cucuLaki >= 1 || cucuPerempuan >= 1)) {
                                bagianIbunyaAyah = "1/6 → 1/4"
                                hartaIbunyaAyah = harta*(1.0/4.0)
                                if(cucuPerempuan > 1 && cucuLaki == 0) {
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                }
                                if(cucuLaki >= 1) {
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                }
                                sisaHarta -= hartaIbunyaAyah
                            }
                            if(adaIbunyaIbu && (cucuLaki >= 1 || cucuPerempuan >= 1)) {
                                bagianIbunyaIbu = "1/6 → 1/4"
                                hartaIbunyaIbu = harta*(1.0/4.0)
                                if(cucuPerempuan > 1 && cucuLaki == 0) {
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                }
                                if(cucuLaki >= 1) {
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                }
                                sisaHarta -= hartaIbunyaIbu
                            }
                        }

                        if(cucuLaki >= 1) {
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            sisaHarta -= hartaCucuLaki
                        }

                        if(cucuPerempuan >= 1) {
                            if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && cucuLaki == 0 && !adaAyahnyaAyah) {
                                hartaCucuPerempuan = harta*(1.0/2.0)
                                bagianCucuPerempuan = "1/2 → 1/2"
                                if(cucuPerempuan > 1) {
                                    hartaCucuPerempuan = harta*(2.0/3.0)
                                    bagianCucuPerempuan = "2/3 → 2/3"
                                }
                                sisaHarta -= hartaCucuPerempuan
                                if(adaIbunyaAyah) {
                                    if(hartaIbunyaAyah > 0) {
                                        sisaHarta += hartaIbunyaAyah
                                    }

                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }
                                if(adaIbunyaIbu) {
                                    if(hartaIbunyaIbu > 0) {
                                        sisaHarta += hartaIbunyaIbu
                                    }

                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                if(adaSaudaraSeayahSeibu >= 1) {
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                }
                                if(adaSaudariSeayahSeibu >= 1) {
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                }
                            }else {
                                hartaCucuPerempuan = sisaHarta
                                sisaHarta -= hartaCucuPerempuan
                            }
                        }
                    }
                } else if (anakPerempuan == 1) {
                    if (anakLaki == 0) {
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            bagianAnakPerempuan = "1/2 → 1/1"
                            if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah

                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaIbunyaAyah

                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta*(1.0/6.0)
                                sisaHarta -= hartaIbunyaIbu
                            }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                bagianAnakPerempuan = "1/2 → 3/5"
                                if(adaAyahnyaAyah && adaIbunyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }

                                if(adaIbunyaAyah && adaIbunyaIbu) {
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                                if(adaIbunyaIbu && adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                            }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                bagianAnakPerempuan = "1/2 → 3/4"
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/4"
                                    hartaAyahnyaAyah = harta*(1.0/4.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                }
                                if(adaIbunyaAyah) {
                                    bagianIbunyaAyah = "1/6 → 1/4"
                                    hartaIbunyaAyah = harta*(1.0/4.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 1/4"
                                    hartaIbunyaIbu = harta*(1.0/4.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                            }
                            hartaAnakPerempuan = sisaHarta
                            keterangan = "Radd"
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianAnakPerempuan = "1/2 → 1/2"
                            hartaAnakPerempuan = harta * 0.5
//                            sisaHarta = sisaHarta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1.0/2.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAnakPerempuan = "1/2 → 1/2"
                            hartaAnakPerempuan = harta * 0.5
                            sisaHarta = sisaHarta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAnakPerempuan = "1/2 → 1/4"
                            hartaAnakPerempuan = harta * 3.0/4.0
//                            sisaHarta = sisaHarta - hartaAnakPerempuan
                            bagianCucuPerempuan = "1/6 → 1/4"
                            hartaCucuPerempuan = harta * 1.0/4.0
                        }

                    } else if (anakLaki >= 1) {
                        if(adaAyahnyaAyah) {
                            bagianAyahnyaAyah = "1/6 → 1/6"
                            hartaAyahnyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaAyahnyaAyah
                        }

                        if(adaIbunyaAyah) {
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaAyah
                        }

                        if(adaIbunyaIbu) {
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaIbu
                        }
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        bagianCucuLaki = "Mahjub"
                        bagianCucuPerempuan = "Mahjub"
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }

                } else if(anakPerempuan > 1){
                    if (anakLaki == 0) {
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) {
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta*(1.0/7.0)
                                sisaHarta -= hartaAyahnyaAyah

                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta*(1.0/7.0)
                                sisaHarta -= hartaIbunyaAyah

                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta*(1.0/7.0)
                                sisaHarta -= hartaIbunyaIbu
                            }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                if(adaAyahnyaAyah && adaIbunyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }

                                if(adaIbunyaAyah && adaIbunyaIbu) {
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                                if(adaIbunyaIbu && adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                            }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                }
                                if(adaIbunyaAyah) {
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta*(1.0/5.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                            }

                            bagianAnakPerempuan = "1/2 → 1/1"
                            hartaAnakPerempuan = sisaHarta
                            keterangan = "Radd"
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAnakPerempuan = "2/3 → 1/1"
                            hartaAnakPerempuan = harta * 1.0/1.0
                            sisaHarta = sisaHarta - hartaAnakPerempuan
                            bagianCucuPerempuan = "Mahjub"
                        } else if(cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianAnakPerempuan = "2/3 → 2/3"
                            hartaAnakPerempuan = harta * 2.0/3.0
                            sisaHarta = sisaHarta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }

                    } else if (anakLaki >= 1) {
                        if(adaAyahnyaAyah) {
                            bagianAyahnyaAyah = "1/6 → 1/6"
                            hartaAyahnyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaAyahnyaAyah
                        }
                        if(adaIbunyaIbu) {
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaIbu
                        }
                        if(adaIbunyaAyah) {
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta*(1.0/6.0)
                            sisaHarta -= hartaIbunyaAyah
                        }
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        bagianCucuPerempuan = "Mahjub"
                        bagianCucuLaki = "Mahjub"
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
            }else if (!adaAyah && adaIbu){
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIbu = "1/3 → 1/1"
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta*(1.0/6.0)
                                sisaHarta -= hartaIbu
                                hartaAyahnyaAyah = sisaHarta
                                sisaHarta -= hartaAyahnyaAyah
                            }else if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) {
                                hartaIbu = harta*(1.0/3.0)
                                sisaHarta -= hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta
                                sisaHarta -= hartaSaudaraSeayahSeibu
                            }
                            else{
                                if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1) {
                                    hartaIbu = harta*(1.0/6.0)
                                    bagianIbu = "1/6 → 1/6"
                                    sisaHarta -= hartaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                }else {
                                    hartaIbu = sisaHarta
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (cucuPerempuan == 1){
                                if(adaAyahnyaAyah) {
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1.0/5.0
                                    sisaHarta -= hartaIbu
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    hartaCucuPerempuan = harta * 3.0/5.0
                                    sisaHarta -= hartaCucuPerempuan
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    hartaAyahnyaAyah = harta*(1.0/5.0)
                                }else {
                                    bagianIbu = "1/6 → 1/4"
                                    hartaIbu = harta * 1.0/4.0
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    hartaCucuPerempuan = harta * 3.0/4.0
                                }
                            }else if(cucuPerempuan > 1){
                                if(adaAyahnyaAyah) {
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1.0/6.0
                                    sisaHarta -= hartaIbu
                                    bagianCucuPerempuan = "1/2 → 4/6"
                                    hartaCucuPerempuan = harta * 4.0/6.0
                                    sisaHarta -= hartaCucuPerempuan
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    hartaAyahnyaAyah = harta*(1.0/6.0)
                                }else {
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1.0/5.0
                                    bagianCucuPerempuan = "2/3 → 4/5"
                                    hartaCucuPerempuan = harta * 4.0/5.0
                                }
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1.0/6.0
                                sisaHarta -= hartaIbu
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4.0/6.0
                                sisaHarta -= hartaCucuLaki
                            }else {
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1.0/6.0
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5.0/6.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1.0/6.0
                                sisaHarta -= hartaIbu
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else {
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1.0/6.0
                                sisaHarta = sisaHarta - hartaIbu
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }

                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/5"
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaIbu = harta * (1.0/5.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta*(3.0/5.0)
                                sisaHarta -= hartaAnakPerempuan
                                bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                hartaAyahnyaAyah = harta*(1.0/5.0)
                                sisaHarta -= hartaAyahnyaAyah
                                keterangan = "Radd"
                            }else {
                                bagianIbu = "1/6 → 1/4"
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaIbu = harta * (1.0/4.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = sisaHarta
                                keterangan = "Radd"
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaIbu = harta * (1.0/6.0)
//                            sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 3.0/6.0
                                hartaCucuPerempuan = harta * 1.0/6.0
                            }else {
                                bagianIbu = "1/6 → 1/5"
                                bagianAnakPerempuan = "1/2 → 3/5"
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaIbu = harta * (1.0/5.0)
//                            sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 3.0/5.0
                                hartaCucuPerempuan = harta * 1.0/5.0

                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuLaki = "Ashobah"
                                hartaIbu = harta * (1.0/6.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 3.0/6.0
                                sisaHarta -= hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta
                            }else {
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuLaki = "Ashobah"
                                hartaIbu = harta * (1.0/6.0)
                                //                            sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 3.0/6.0
                                hartaCucuLaki = harta * 2.0/6.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                            }
                            bagianIbu = "1/6 → 1/6"
                            bagianAnakPerempuan = "1/2 → 3/6"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaIbu = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 3.0/6.0
                            sisaHarta = sisaHarta - hartaIbu - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaIbu = harta * (1.0 / 6.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta*(4.0/6.0)
                                sisaHarta -= hartaAnakPerempuan
                                bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                keterangan = "Radd"
                            }else {
                                bagianIbu = "1/6 → 1/5"
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaIbu = harta * (1.0 / 5.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = sisaHarta
                                keterangan = "Radd"
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "2/3 → 4/6"
                                bagianCucuPerempuan = "Mahjub"
                                hartaIbu = harta * (1.0 / 6.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = sisaHarta
                            }else {
                                bagianIbu = "1/6 → 1/5"
                                bagianAnakPerempuan = "2/3 → 4/5"
                                bagianCucuPerempuan = "Mahjub"
                                hartaIbu = harta * (1.0 / 5.0)
                                sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = sisaHarta
                            }

                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                hartaAyahnyaAyah = harta*(1.0/6.0)
                                sisaHarta -= hartaAyahnyaAyah
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 4/6"
                                bagianCucuLaki = "Ashobah"
                                hartaIbu = harta * (1.0/6.0)
//                            sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 4.0/6.0
                            }else {
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 4/6"
                                bagianCucuLaki = "Ashobah"
                                hartaIbu = harta * (1.0/6.0)
//                            sisaHarta = sisaHarta - hartaIbu
                                hartaAnakPerempuan = harta * 4.0/6.0
                                hartaCucuLaki = harta * 1.0/6.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(adaAyahnyaAyah) {
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 4/6"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta * 4.0/6.0
                                sisaHarta = sisaHarta - hartaIbu - hartaAnakPerempuan
                            }else {
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 4/6"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta * 4.0/6.0
                                sisaHarta = sisaHarta - hartaIbu - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }

                }else if (anakLaki >= 1) {
                    bagianIbu = "1/6 → 1/6"
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    hartaIbu = harta * (1.0/6.0)
                    sisaHarta = sisaHarta - hartaIbu
                    if(adaAyahnyaAyah) {
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta*(1.0/6.0)
                        sisaHarta -= hartaAyahnyaAyah
                    }
                    if (anakPerempuan == 0) {
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = sisaHarta
                    }else if (anakPerempuan >= 1) {
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                    }
                }
                // Batas suciiiii
                // Batas suciiiii
                // Batas suciiiii
            }else if (adaAyah && !adaIbu) {
                if (anakLaki == 0) {
                    if (anakPerempuan == 0){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta*(1.0/6.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            bagianAyah = "Ashobah"
                            hartaAyah = sisaHarta
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (cucuPerempuan == 1){
                                bagianAyah = "1/6+sisa → 1/4"
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaAyah = harta * 1.0/4.0
                                hartaCucuPerempuan = harta * 3.0/4.0
                            }else if(cucuPerempuan > 1){
                                bagianAyah = "1/6+sisa → 1/5"
                                bagianCucuPerempuan = "2/3 → 4/5"
                                hartaAyah= harta * 1.0/5.0
                                hartaCucuPerempuan = harta * 4.0/5.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if (cucuLaki == 1){
                                bagianAyah = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                hartaAyah = harta * 1.0/2.0
                                hartaCucuLaki = harta * 1.0/2.0
                            }else if(cucuLaki > 1){
                                bagianAyah = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                hartaAyah = harta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = harta * (cucuLaki) / (cucuLaki + 1).toDouble()
                                hartaAnakLaki = harta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (harta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }

                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAyah = "1/6+sisa → 1/6"
                            hartaAyah = harta * 1.0/6.0
                            sisaHarta = sisaHarta - hartaAyah
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                        //Batas Suci
                        //Batas Suci
                        //Batas Suci
                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaAnakPerempuan = harta*(3.0/4.0)
                            hartaAyah = sisaHarta - hartaAnakPerempuan
                            bagianAyah = "1/6+sisa → 1/4"
                            bagianAnakPerempuan = "1/2 → 3/4"
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAyah = "1/6+sisa → 1/5"
                            bagianCucuPerempuan = "1/6 → 1/5"
                            bagianAnakPerempuan = "1/2 → 3/5"
                            hartaAyah = harta * 1.0/5.0
                            hartaAnakPerempuan = harta * 3.0/5.0
                            hartaCucuPerempuan = harta * 1.0/5.0

                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianCucuLaki = "Ashobah"
                            bagianAnakPerempuan = "1/2 → 3/6"
                            hartaAyah = harta * 1.0/6.0
                            hartaCucuLaki = harta * 2.0/6.0
                            hartaAnakPerempuan = harta * 3.0/6.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianAnakPerempuan = "1/2 → 3/6"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaAyah = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 3.0/6.0
                            sisaHarta = sisaHarta - hartaAyah - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if (anakPerempuan > 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaAnakPerempuan = harta*(4.0/5.0)
                            hartaAyah = sisaHarta - hartaAnakPerempuan
                            bagianAyah = "1/6+Ashobah → 1/5"
                            bagianAnakPerempuan = "2/3 → 4/5"
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAyah = "1/6+sisa → 1/5"
                            bagianCucuPerempuan = "Mahjub"
                            bagianAnakPerempuan = "2/3 → 4/5"
                            hartaAyah = harta * 1.0/5.0
                            hartaAnakPerempuan = harta * 4.0/5.0
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianCucuLaki = "Ashobah"
                            bagianAnakPerempuan = "2/3 → 4/6"
                            hartaAyah = harta * 1.0/6.0
                            hartaCucuLaki = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 4.0/6.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianAnakPerempuan = "2/3 → 4/6"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaAyah = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 4.0/6.0
                            sisaHarta = sisaHarta - hartaAyah - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }else if (anakLaki >= 1){
                    bagianAyah = "1/6 → 1/6"
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    hartaAyah = harta * (1.0/6.0)
                    sisaHarta = sisaHarta - hartaAyah
                    if (anakPerempuan == 0) {
                        if(adaIbunyaIbu) {
                            bagianIbunyaIbu = "	1/6 → 1/6"
                            hartaIbunyaIbu = harta*(1.0/6.0)
                            sisaHarta-=hartaIbunyaIbu
                        }
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = sisaHarta
                    }else if (anakPerempuan >= 1) {
                        if(adaIbunyaIbu) {
                            bagianIbunyaIbu = "	1/6 → 1/6"
                            hartaIbunyaIbu = harta*(1.0/6.0)
                            sisaHarta-=hartaIbunyaIbu
                        }
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                        hartaAnakPerempuan = sisaHarta * (anakPerempuan/(anakLaki + anakLaki + anakPerempuan).toDouble())
                    }
                }
                // Batas Suci
                // Batas Suci
                // Batas Suci
            }else if (adaAyah && adaIbu){
                hartaAyah = harta*(1.0/6.0)
                hartaIbu = harta*(1.0/6.0)
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianAyah = "Ashobah"
                            bagianIbu = "1/3 → 1/3"
                            hartaAyah = harta * (2.0 / 3.0)
                            hartaIbu = harta * (1.0 / 3.0)
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (cucuPerempuan == 1){
                                bagianAyah = "1/6+sisa → 1/5"
                                bagianIbu = "1/6 → 1/5"
                                bagianCucuPerempuan = "1/2 → 3/5"
                                hartaAyah = harta * 1.0/5.0
                                hartaIbu = harta * 1.0/5.0
                                hartaCucuPerempuan = harta * 3.0/5.0
                            }else if(cucuPerempuan > 1){
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaAyah = harta * 1.0/6.0
                                hartaIbu = harta * 1.0/6.0
                                hartaCucuPerempuan = harta * 4.0/6.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianAyah = "Ashobah"
                            bagianCucuLaki = "Ashobah"
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1.0/6.0
                            sisaHarta = sisaHarta - hartaIbu
                            hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                            hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianIbu = "1/6 → 1/6"
                            hartaAyah = harta * 1.0/6.0
                            hartaIbu = harta * 1.0/6.0
                            sisaHarta = sisaHarta - hartaAyah - hartaIbu
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                        //Batas suci
                        //Batas suci
                        //Batas suci
                    }else if (anakPerempuan >= 1) {
                        if (anakPerempuan == 1) {
                            if(cucuPerempuan == 0 && cucuLaki == 0){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                bagianIbu = "1/6 → 1/5"
                                bagianAyah = "1/6+sisa → 1/5"
                                hartaAnakPerempuan = harta*(3.0/5.0)
                                hartaIbu = harta * 1.0/5.0
                                sisaHarta = sisaHarta - (hartaIbu + hartaAnakPerempuan + hartaAyah)
                                hartaAyah += sisaHarta
                            }else if(cucuPerempuan > 0 && cucuLaki == 0){
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaAyah = harta * 1.0/6.0
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta*(3.0/6.0)
                                hartaCucuPerempuan = harta * 1.0/6.0
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuLaki = "Ashobah"
                                hartaAyah = harta * 1.0/6.0
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta*(3.0/6.0)
                                hartaCucuLaki = harta * 1.0/6.0
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "1/2 → 3/6"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaAyah = harta * 1.0/6.0
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta*(3.0/6.0)
                                sisaHarta = sisaHarta - hartaAyah - hartaIbu - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if (anakPerempuan > 1) {
                            if(cucuPerempuan == 0 && cucuLaki == 0){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAyah = "1/6+sisa → 1/6"
                                hartaAnakPerempuan = (harta*(4.0/6.0))
                            }else if(cucuPerempuan > 0 && cucuLaki == 0){
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "2/3 → 4/6"
                                bagianCucuPerempuan = "Mahjub"
                                hartaAyah = harta * 1.0/6.0
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta*(4.0/6.0)
                            }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                                bagianAyah = "1/6+sisa → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                bagianAnakPerempuan = "2/3 → 4/6"
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                hartaAyah = harta * 1.0 / 6.0
                                hartaIbu = harta * 1.0 / 6.0
                                hartaAnakPerempuan = harta * (4.0 / 6.0)
                            }
                        }
                    }
                }else if (anakLaki >= 1) {
                    bagianAyah = "1/6 → 1/6"
                    bagianIbu = "1/6 → 1/6"
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    if (anakPerempuan == 0) {
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * (4.0/6.0)

                    }else if(anakPerempuan >= 1) {
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        sisaHarta = sisaHarta - (harta * (1.0/6.0) * 2)
                        hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                        hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                    }
                }
            }
            //Batas Suci
            //Batas Suci
            //Batas Suci
        }
        else if(adaSuami || istri > 0){
            if (!adaAyah && !adaIbu) {
                if (anakPerempuan == 0) {
                    if (anakLaki == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIstri = "1/4 → 1/4"
                            bagianSuami = "1/2 → 1/2"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    if(adaIbunyaAyah) {
                                        if(adaIbunyaIbu) {
                                            bagianIstri = "1/4 → 3/12"
                                            hartaIstri = harta*(3.0/12.0)
                                            sisaHarta = sisaHarta - hartaIstri
                                            bagianIbunyaAyah = "1/6 → 2/12"
                                            hartaIbunyaAyah = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianIbunyaIbu = "1/6 → 2/12"
                                            hartaIbunyaIbu = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaIbu
                                            bagianAyahnyaAyah = "Ashobah"
                                            hartaAyahnyaAyah = sisaHarta
                                            sisaHarta -= hartaAyahnyaAyah
                                        }else {
                                            bagianIstri = "1/4 → 3/12"
                                            hartaIstri = harta*(3.0/12.0)
                                            sisaHarta = sisaHarta - hartaIstri
                                            bagianIbunyaAyah = "1/6 → 2/12"
                                            hartaIbunyaAyah = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianAyahnyaAyah = "Ashobah"
                                            hartaAyahnyaAyah = sisaHarta
                                            sisaHarta -= hartaAyahnyaAyah
                                        }
                                    }else if(adaIbunyaIbu){
                                        hartaIstri = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        bagianIbunyaIbu = "1/6 → 2/12"
                                        hartaIbunyaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }else {
                                        hartaIstri = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                }else if(adaIbunyaIbu) {
                                    sisaHarta = harta
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta*(2.0/12.0)
                                    sisaHarta -= hartaIbunyaIbu

                                    if(adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) {
                                        bagianIstri = "1/4 → 3/12"
                                        hartaIstri = harta*(3.0/12.0)
                                        sisaHarta -= hartaIstri
                                        bagianSaudaraSeayahSeibu = "Ashobah"
                                        hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                        sisaHarta -= hartaSaudaraSeayahSeibu
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaSaudariSeayahSeibu = sisaHarta
                                        sisaHarta -= hartaSaudariSeayahSeibu
                                    }
                                    if(adaIbunyaAyah) {
                                        hartaIstri = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        bagianIbunyaIbu = "1/6 → 3/8"
                                        hartaIbunyaIbu = harta*(3.0/8.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianIbunyaAyah = "1/6 → 3/8"
                                        hartaIbunyaAyah = harta*(3.0/8.0)
                                        sisaHarta -= hartaIbunyaAyah
                                    }else if(adaAyahnyaAyah){
                                        hartaIstri = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        bagianIbunyaIbu = "1/6 → 2/12"
                                        hartaIbunyaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                }else {
                                    hartaIstri = harta * (1.0/4.0)
                                    sisaHarta = sisaHarta - hartaIstri
                                }

                                if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && !adaAyahnyaAyah) {
                                    sisaHarta = harta
                                    bagianIstri = "1/4 → 3/12"
                                    hartaIstri = harta*(3.0/12.0)
                                    sisaHarta -= hartaIstri
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                }

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    if(adaIbunyaAyah) {
                                        if(adaIbunyaIbu) {
                                            bagianSuami = "1/2 → 3/6"
                                            hartaSuami = harta*(3.0/6.0)
                                            sisaHarta = sisaHarta - hartaSuami
                                            bagianIbunyaAyah = "1/6"
                                            hartaIbunyaAyah = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianIbunyaIbu = "1/6"
                                            hartaIbunyaIbu = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaIbu
                                            bagianAyahnyaAyah = "Ashobah"
                                            hartaAyahnyaAyah = sisaHarta
                                            sisaHarta -= hartaAyahnyaAyah
                                        }else {
                                            bagianSuami = "1/2 → 1/2"
                                            hartaSuami = harta*(3.0/12.0)
                                            sisaHarta = sisaHarta - hartaSuami
                                            bagianIbunyaAyah = "1/6 → 2/12"
                                            hartaIbunyaAyah = harta*(2.0/12.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianAyahnyaAyah = "Ashobah"
                                            hartaAyahnyaAyah = sisaHarta
                                            sisaHarta -= hartaAyahnyaAyah
                                        }
                                    }else if(adaIbunyaIbu){
                                        hartaSuami = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        bagianIbunyaIbu = "1/6 → 2/12"
                                        hartaIbunyaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }else {
                                        hartaSuami = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                }else if(adaIbunyaIbu) {
                                    if(adaIbunyaAyah) {
                                        hartaSuami = harta * (1.0/2.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        bagianIbunyaIbu = "1/6 → 1/4"
                                        hartaIbunyaIbu = harta*(1.0/4.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianIbunyaAyah = "1/6 → 1/4"
                                        hartaIbunyaAyah = harta*(1.0/4.0)
                                        sisaHarta -= hartaIbunyaAyah
                                    }else if(adaAyahnyaAyah){
                                        hartaSuami = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        bagianIbunyaIbu = "1/6 → 2/12"
                                        hartaIbunyaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaIbunyaIbu
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }else {
                                        hartaSuami = harta * (1.0/2.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        bagianIbunyaIbu = "1/6 → 1/2"
                                        hartaIbunyaIbu = harta*(1.0/2.0)
                                        sisaHarta -= hartaIbunyaIbu
                                    }
                                }else {
                                    hartaSuami = harta * (1.0/2.0)
                                    sisaHarta = sisaHarta - hartaSuami
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "1/2 → 7/8"
                                if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                    if(cucuPerempuan > 1) {
                                        hartaIstri = harta * (3.0/31.0)
                                        bagianIstri = "1/8 → 3/31"
                                        bagianCucuPerempuan = "2/3 → 16/31"
                                        bagianAyahnyaAyah = "1/6 → 4/31"
                                        hartaAyahnyaAyah = harta*(4.0/31.0)
                                        sisaHarta -= hartaAyahnyaAyah

                                        bagianIbunyaAyah = "1/6 → 4/31"
                                        hartaIbunyaAyah = harta*(4.0/31.0)
                                        sisaHarta -= hartaIbunyaAyah

                                        bagianIbunyaIbu = "1/6 → 4/31"
                                        hartaIbunyaIbu = harta*(4.0/31.0)
                                    }else {
                                        hartaIstri = harta * (3.0/27.0)
                                        bagianIstri = "1/8 → 3/27"
                                        bagianCucuPerempuan = "1/2 → 12/27"
                                        bagianAyahnyaAyah = "1/6 → 4/27"
                                        hartaAyahnyaAyah = harta*(4.0/27.0)
                                        sisaHarta -= hartaAyahnyaAyah

                                        bagianIbunyaAyah = "1/6 → 4/27"
                                        hartaIbunyaAyah = harta*(4.0/27.0)
                                        sisaHarta -= hartaIbunyaAyah

                                        bagianIbunyaIbu = "1/6 → 4/27"
                                        hartaIbunyaIbu = harta*(4.0/27.0)
                                    }
                                    sisaHarta -= hartaIbunyaIbu
                                }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                    if(cucuPerempuan > 1) {
                                        bagianIstri = "1/8 → 3/27"
                                        hartaIstri = harta * (3.0/27.0)
                                        bagianCucuPerempuan = "2/3 → 16/27"
                                    }else {
                                        bagianCucuPerempuan = "1/2 → 21/40"
                                    }
                                    if(adaAyahnyaAyah && adaIbunyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 4/27"
                                            hartaAyahnyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 4/27"
                                            hartaIbunyaAyah = harta*(4.0/27.0)
                                        }else {
                                            bagianAyahnyaAyah = "1/6 → 7/40"
                                            hartaAyahnyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 7/40"
                                            hartaIbunyaAyah = harta*(7.0/40.0)
                                        }
                                        sisaHarta -= hartaIbunyaAyah
                                    }

                                    if(adaIbunyaAyah && adaIbunyaIbu) {
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaAyah = "1/6 → 4/27"
                                            hartaIbunyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 4/27"
                                            hartaIbunyaIbu = harta*(4.0/27.0)
                                        }else {
                                            bagianIbunyaAyah = "1/6 → 7/40"
                                            hartaIbunyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 7/40"
                                            hartaIbunyaIbu = harta*(7.0/40.0)
                                        }
                                        sisaHarta -= hartaIbunyaIbu
                                    }

                                    if(adaIbunyaIbu && adaAyahnyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 4/27"
                                            hartaAyahnyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaIbu = "1/6 → 4/27"
                                            hartaIbunyaIbu = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else {
                                            bagianAyahnyaAyah = "1/6 → 7/40"
                                            hartaAyahnyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaIbu = "1/6 → 7/40"
                                            hartaIbunyaIbu = harta*(7.0/40.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }
                                    }

                                }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                    if(cucuPerempuan > 1) {
                                        bagianCucuPerempuan = "2/3 → 7/10"
                                    }else {
                                        bagianCucuPerempuan = "1/2 → 21/32"
                                    }
                                    if(adaAyahnyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 7/40"
                                            hartaAyahnyaAyah = harta*(7.0/40.0)
                                        }else {
                                            bagianAyahnyaAyah = "1/6 → 7/32"
                                            hartaAyahnyaAyah = harta*(7.0/32.0)
                                        }
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                    if(adaIbunyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaAyah = "1/6 → 7/40"
                                            hartaIbunyaAyah = harta*(7.0/40.0)
                                        }else {
                                            bagianIbunyaAyah = "1/6 → 7/32"
                                            hartaIbunyaAyah = harta*(7.0/32.0)
                                        }
                                        sisaHarta -= hartaIbunyaAyah
                                    }
                                    if(adaIbunyaIbu) {
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaIbu = "1/6 → 7/40"
                                            hartaIbunyaIbu = harta*(7.0/40.0)
                                        }else {
                                            bagianIbunyaIbu = "1/6 → 7/32"
                                            hartaIbunyaIbu = harta*(7.0/32.0)
                                        }
                                        sisaHarta -= hartaIbunyaIbu
                                    }
                                }

                                sisaHarta -= hartaIstri
                                hartaCucuPerempuan = sisaHarta

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaSuami = harta * (1.0/4.0)

                                if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                    if(cucuPerempuan > 1) {
                                        hartaSuami = harta * (3.0/17.0)
                                        bagianSuami = "1/4 → 3/17"
                                        bagianCucuPerempuan = "2/3 → 8/17"
                                        bagianAyahnyaAyah = "1/6 → 2/17"
                                        hartaAyahnyaAyah = harta*(2.0/17.0)
                                        sisaHarta -= hartaAyahnyaAyah

                                        bagianIbunyaAyah = "1/6 → 2/17"
                                        hartaIbunyaAyah = harta*(2.0/17.0)
                                        sisaHarta -= hartaIbunyaAyah

                                        bagianIbunyaIbu = "1/6 → 2/17"
                                        hartaIbunyaIbu = harta*(2.0/17.0)
                                    }else {
                                        hartaSuami = harta * (3.0/15.0)
                                        bagianSuami = "1/4 → 3/15"
                                        bagianCucuPerempuan = "1/2 → 6/15"
                                        bagianAyahnyaAyah = "1/6 → 2/15"
                                        hartaAyahnyaAyah = harta*(2.0/15.0)
                                        sisaHarta -= hartaAyahnyaAyah

                                        bagianIbunyaAyah = "1/6 → 2/15"
                                        hartaIbunyaAyah = harta*(2.0/15.0)
                                        sisaHarta -= hartaIbunyaAyah

                                        bagianIbunyaIbu = "1/6 → 2/15"
                                        hartaIbunyaIbu = harta*(2.0/15.0)
                                    }
                                    sisaHarta -= hartaIbunyaIbu
                                }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                    bagianCucuPerempuan = "1/2 → 6/13"
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianSuami = "1/4 → 3/13"
                                    if(cucuPerempuan > 1) {
                                        bagianCucuPerempuan = "2/3 → 8/15"
                                        hartaSuami = harta * (3.0/15.0)
                                        bagianSuami = "1/4 → 3/15"
                                    }
                                    if(adaAyahnyaAyah && adaIbunyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 2/15"
                                            hartaAyahnyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 2/15"
                                            hartaIbunyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaAyah
                                        }else {
                                            bagianAyahnyaAyah = "1/6 → 2/13"
                                            hartaAyahnyaAyah = harta*(2.0/13.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 2/13"
                                            hartaIbunyaAyah = harta*(2.0/13.0)
                                            sisaHarta -= hartaIbunyaAyah
                                        }
                                    }

                                    if(adaIbunyaAyah && adaIbunyaIbu) {
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaAyah = "1/6 → 2/15"
                                            hartaIbunyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 2/15"
                                            hartaIbunyaIbu = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else {
                                            bagianIbunyaAyah = "1/6 → 2/13"
                                            hartaIbunyaAyah = harta*(2.0/13.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 2/13"
                                            hartaIbunyaIbu = harta*(2.0/13.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }
                                    }

                                    if(adaIbunyaIbu && adaAyahnyaAyah) {
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 2/15"
                                            hartaAyahnyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaIbu = "1/6 → 2/15"
                                            hartaIbunyaIbu = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else {
                                            bagianAyahnyaAyah = "1/6 → 2/13"
                                            hartaAyahnyaAyah = harta*(2.0/13.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaIbu = "1/6 → 2/13"
                                            hartaIbunyaIbu = harta*(2.0/13.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }
                                    }

                                }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                    bagianCucuPerempuan = "1/2 → 9/16"
                                    if(cucuPerempuan > 1) {
                                        bagianCucuPerempuan = "2/3 → 8/13"
                                        bagianSuami = "1/4 → 3/13"
                                        hartaSuami = harta*(3.0/13.0)
                                    }
                                    if(adaAyahnyaAyah) {
                                        bagianAyahnyaAyah = "1/6 → 3/16"
                                        hartaAyahnyaAyah = harta*(3.0/16.0)
                                        if(cucuPerempuan > 1) {
                                            bagianAyahnyaAyah = "1/6 → 2/13"
                                            hartaAyahnyaAyah = harta*(2.0/13.0)
                                        }
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                    if(adaIbunyaAyah) {
                                        bagianIbunyaAyah = "1/6 → 3/16"
                                        hartaIbunyaAyah = harta*(3.0/16.0)
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaAyah = "1/6 → 2/13"
                                            hartaIbunyaAyah = harta*(2.0/13.0)
                                        }
                                        sisaHarta -= hartaIbunyaAyah
                                    }
                                    if(adaIbunyaIbu) {
                                        bagianIbunyaIbu = "1/6 → 3/16"
                                        hartaIbunyaIbu = harta*(3.0/16.0)
                                        if(cucuPerempuan > 1) {
                                            bagianIbunyaIbu = "1/6 → 2/13"
                                            hartaIbunyaIbu = harta*(2.0/13.0)
                                        }
                                        sisaHarta -= hartaIbunyaIbu
                                    }
                                }
                                sisaHarta -= hartaSuami
                                hartaCucuPerempuan = sisaHarta
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                }

                                if(adaIbunyaAyah) {
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }

                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                sisaHarta = sisaHarta - hartaIstri
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                sisaHarta = sisaHarta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                }

                                if(adaIbunyaAyah) {
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaAyah
                                }

                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }

                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                sisaHarta = sisaHarta - hartaSuami
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                sisaHarta = sisaHarta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                            }
                        }

                    } else if (anakLaki >= 1) {
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianAnakLaki = "Ashobah"
                        bagianCucuPerempuan = "Mahjub"
                        bagianCucuLaki = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta*(1.0/8.0)
                            hartaAnakLaki = harta*(7.0/8.0)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            sisaHarta-= hartaSuami
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                sisaHarta -= hartaAyahnyaAyah
                            }
                            if(adaIbunyaAyah) {
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaAyah
                            }
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            hartaAnakLaki = sisaHarta
                            sisaHarta -= hartaAnakLaki
                        }
                    }
                } else if (anakPerempuan >= 1) {
                    if (anakLaki == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianSuami = "1/4 → 1/4"
                            bagianIstri = "1/8 → 1/8"
                            hartaSuami = harta*(1.0/4.0)
                            hartaIstri = harta*(1.0/8.0)
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && !adaAyahnyaAyah) {
                                    sisaHarta -= hartaIstri
                                    if(anakPerempuan > 1) {
                                        hartaAnakPerempuan = harta*(16.0/24.0)
                                        bagianAnakPerempuan = "2/3 → 16/24"
                                    }else {
                                        hartaAnakPerempuan = harta*(12.0/24.0)
                                        bagianAnakPerempuan = "1/2 → 12/24"
                                    }
                                    sisaHarta -= hartaAnakPerempuan
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                    keterangan = "Radd"
                                }else {
                                    hartaAnakPerempuan = harta*(7.0/8.0)
                                    bagianAnakPerempuan = if (anakPerempuan > 1) "2/3 → 7/8" else "1/2 → 7/8"
                                    keterangan = "Radd"
                                }

                                if(adaAyahnyaAyah) {
                                    if(anakPerempuan > 1) {
                                        if(adaIbunyaAyah && adaIbunyaIbu) {
                                            bagianAyahnyaAyah = "1/6+sisa → 4/31"
                                            hartaAyahnyaAyah = harta*(4.0/31.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            bagianIstri = "1/8 → 3/31"
                                            hartaIstri = harta*(3.0/31.0)
                                            sisaHarta -= hartaIstri
                                            hartaAnakPerempuan = harta*(16.0/31.0)
                                            bagianAnakPerempuan = "2/3 → 16/31"
                                            bagianIbunyaAyah = "1/6 → 4/31"
                                            hartaIbunyaAyah = harta*(4.0/31.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianIbunyaIbu = "1/6 → 4/31"
                                            hartaIbunyaIbu = harta*(4.0/31.0)
                                            sisaHarta -= hartaIbunyaIbu
                                            keterangan = "Radd"
                                        }else if(adaIbunyaAyah && !adaIbunyaIbu){
                                            bagianAyahnyaAyah = "1/6+sisa → 4/27"
                                            hartaAyahnyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            hartaAnakPerempuan = harta*(16.0/27.0)
                                            bagianAnakPerempuan = "2/3 → 16/27"
                                            bagianIbunyaAyah = "1/6 → 4/27"
                                            hartaIbunyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            keterangan = "Radd"
                                        }else {
                                            bagianAyahnyaAyah = "1/6+sisa → 7/40"
                                            hartaAyahnyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            hartaAnakPerempuan = harta*(7.0/10.0)
                                            bagianAnakPerempuan = "2/3 → 7/10"
                                            keterangan = "Radd"
                                        }
                                    }else {
                                        if(adaIbunyaAyah && adaIbunyaIbu) {
                                            bagianAyahnyaAyah = "1/6+sisa → 4/27"
                                            hartaAyahnyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            hartaAnakPerempuan = harta*(12.0/27.0)
                                            bagianAnakPerempuan = "1/2 → 12/27"
                                            bagianIstri = "1/8 → 3/27"
                                            hartaIstri = harta*(3.0/27.0)
                                            sisaHarta -= hartaIstri
                                            bagianIbunyaAyah = "1/6 → 4/27"
                                            hartaIbunyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            bagianIbunyaIbu = "1/6 → 4/27"
                                            hartaIbunyaIbu = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaIbu
                                            keterangan = "Radd"
                                        }else if(adaIbunyaAyah && !adaIbunyaIbu){
                                            bagianAyahnyaAyah = "1/6+sisa → 7/40"
                                            hartaAyahnyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            hartaAnakPerempuan = harta*(21.0/40.0)
                                            bagianAnakPerempuan = "1/2 → 21/40"
                                            bagianIbunyaAyah = "1/6 → 7/40"
                                            hartaIbunyaAyah = harta*(7.0/40.0)
                                            sisaHarta -= hartaIbunyaAyah
                                            keterangan = "Radd"
                                        }else {
                                            bagianAyahnyaAyah = "1/6+sisa → 7/32"
                                            hartaAyahnyaAyah = harta*(7.0/32.0)
                                            sisaHarta -= hartaAyahnyaAyah
                                            hartaAnakPerempuan = harta*(21.0/32.0)
                                            bagianAnakPerempuan = "1/2 → 21/32"
                                            keterangan = "Radd"
                                        }
                                    }
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    hartaAnakPerempuan = harta*(9.0/16.0)
                                    bagianAyahnyaAyah = "1/6+sisa → 3/16"
                                    hartaAyahnyaAyah = harta*(3.0/16.0)
                                    if(adaIbunyaAyah) {
                                        bagianSuami = "1/4 → 3/13"
                                        hartaSuami = harta*(3.0/13.0)
                                        bagianAnakPerempuan = "1/2 → 6/13"
                                        hartaAnakPerempuan = harta*(6.0/13.0)
                                        bagianAyahnyaAyah = "1/6+sisa → 2/13"
                                        hartaAyahnyaAyah = harta*(2.0/13.0)
                                        bagianIbunyaAyah = "1/6 → 2/13"
                                        hartaIbunyaAyah = harta*(2.0/13.0)
                                        if(adaIbunyaIbu) {
                                            bagianSuami = "1/4 → 3/15"
                                            hartaSuami = harta*(3.0/15.0)
                                            bagianAnakPerempuan = "1/2 → 6/15"
                                            hartaAnakPerempuan = harta*(6.0/15.0)
                                            bagianAyahnyaAyah = "1/6+sisa → 2/15"
                                            hartaAyahnyaAyah = harta*(2.0/15.0)
                                            bagianIbunyaAyah = "1/6 → 2/15"
                                            hartaIbunyaAyah = harta*(2.0/15.0)
                                            bagianIbunyaIbu = "1/6 → 2/15"
                                            hartaIbunyaIbu = harta*(2.0/15.0)
                                        }
                                    }
                                    sisaHarta -= hartaIbunyaIbu
                                    sisaHarta-=hartaIbunyaAyah
                                    sisaHarta-=hartaAyahnyaAyah
                                    sisaHarta -= hartaSuami
                                    sisaHarta -= hartaAnakPerempuan
                                }else if(adaIbunyaIbu){
                                    bagianSuami = "1/4 → 1/4"
                                    hartaSuami = harta*(1.0/4.0)
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    hartaAnakPerempuan = harta*(9.0/16.0)
                                    bagianIbunyaIbu = "1/6 → 3/16"
                                    hartaIbunyaIbu = harta*(3.0/16.0)
                                    if(adaIbunyaAyah) {
                                        bagianSuami = "1/4 → 1/4"
                                        hartaSuami = harta*(1.0/4.0)
                                        bagianAnakPerempuan = "1/2 → 6/13"
                                        hartaAnakPerempuan = harta*(6.0/13.0)
                                        bagianIbunyaIbu = "1/6 → 3/16"
                                        hartaIbunyaIbu = harta*(3.0/16.0)
                                        bagianIbunyaAyah = "1/6 → 3/16"
                                        hartaIbunyaAyah = harta*(3.0/16.0)
                                    }
                                    if(adaSaudaraSeayahSeibu >= 1) {
                                        bagianSuami = "1/4 → 3/12"
                                        hartaSuami = harta*(3.0/12.0)
                                        bagianAnakPerempuan = "1/2 → 6/12"
                                        hartaAnakPerempuan = harta*(6.0/12.0)
                                        bagianIbunyaIbu = "1/6 → 2/12"
                                        hartaIbunyaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaSuami
                                        sisaHarta -= hartaAnakPerempuan
                                        sisaHarta -= hartaIbunyaIbu
                                        sisaHarta -= hartaIbunyaAyah
                                        if(adaSaudariSeayahSeibu >= 1) {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                            sisaHarta -= hartaSaudaraSeayahSeibu
                                            bagianSaudariSeayahSeibu = "Ashobah"
                                            hartaSaudariSeayahSeibu = sisaHarta
                                        }else {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta
                                        }
                                    }
                                    sisaHarta -= hartaSuami
                                    sisaHarta -= hartaAnakPerempuan
                                    sisaHarta -= hartaIbunyaIbu
                                    sisaHarta -= hartaIbunyaAyah
                                }else {
                                    hartaAnakPerempuan = harta*(3.0/4.0)
                                    bagianAnakPerempuan = if (anakPerempuan > 1) "2/3 → 3/4" else "1/2 → 3/4"
                                    keterangan = "Radd"
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            bagianSuami = "1/4 → 1/4"
                            bagianIstri = "1/8 → 1/8"
                            hartaSuami = harta*(1.0/4.0)
                            hartaIstri = harta*(1.0/8.0)
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(anakPerempuan == 1){
                                    bagianAnakPerempuan = "1/2 → 21/32"
                                    bagianCucuPerempuan = "1/6 → 7/32"
                                    hartaAnakPerempuan = harta*(21.0/32.0)
                                    hartaCucuPerempuan = harta * 7.0/32.0
                                }else if(anakPerempuan > 1){
                                    bagianAnakPerempuan = "2/3 → 7/8"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaAnakPerempuan = harta*(7.0/8.0)
                                }
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(anakPerempuan == 1){
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    bagianCucuPerempuan = "1/6 → 3/16"
                                    hartaAnakPerempuan = harta*(9.0/16.0)
                                    hartaCucuPerempuan = harta * 3.0/16.0
                                }else if(anakPerempuan > 1){
                                    bagianAnakPerempuan = "2/3 → 3/4"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaAnakPerempuan = harta*(3.0/4.0)
                                }
                                keterangan = "Radd"
                            }
                            // Batas Suci
                            // Batas Suci
                            // Batas Suci
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianSuami = "1/4 → 1/4"
                            bagianIstri = "1/8 → 1/8"
                            hartaIstri = harta*(1.0/8.0)
                            hartaSuami = harta*(1.0/4.0)
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                if(anakPerempuan == 1){
                                    if(adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu) {
                                        sisaHarta = sisaHarta - hartaIstri - hartaAnakPerempuan
                                        if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                            bagianAnakPerempuan = "1/2 → 12/27"
                                            hartaAnakPerempuan = harta * 12.0/27.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianAyahnyaAyah = "1/6 → 4/27"
                                            hartaAyahnyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 4/27"
                                            hartaIbunyaAyah = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 4/27"
                                            hartaIbunyaIbu = harta*(4.0/27.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 12/24"
                                            hartaAnakPerempuan = harta * 12.0/24.0
                                            sisaHarta -= hartaAnakPerempuan

                                            if(adaAyahnyaAyah && adaIbunyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/24"
                                                hartaAyahnyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaAyah = "1/6 → 4/24"
                                                hartaIbunyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }

                                            if(adaIbunyaAyah && adaIbunyaIbu) {
                                                bagianIbunyaAyah = "1/6 → 4/24"
                                                hartaIbunyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                bagianIbunyaIbu = "1/6 → 4/24"
                                                hartaIbunyaIbu = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaIbu

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }

                                            if(adaIbunyaIbu && adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/24"
                                                hartaAyahnyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaIbu = "1/6 → 4/24"
                                                hartaIbunyaIbu = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaIbu

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }

                                        }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 12/24"
                                            hartaAnakPerempuan = harta * 12.0/24.0
                                            sisaHarta -= hartaAnakPerempuan

                                            if(adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/24"
                                                hartaAyahnyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaAyah) {
                                                bagianIbunyaAyah = "1/6 → 4/24"
                                                hartaIbunyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaIbu) {
                                                bagianIbunyaIbu = "1/6 → 4/24"
                                                hartaIbunyaIbu = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaIbu

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                        }
                                    }else {
                                        bagianAnakPerempuan = "1/2 → 4/8"
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"
                                        hartaAnakPerempuan = harta * 4.0/8.0
                                        sisaHarta = sisaHarta - hartaIstri - hartaAnakPerempuan
                                        hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                        hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    }
                                }else if(anakPerempuan > 1){
                                    if(adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu) {
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"
                                        if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                            bagianIstri = "1/8 → 3/31"
                                            hartaIstri = harta*(3.0/31.0)
                                            sisaHarta -= hartaIstri

                                            bagianAnakPerempuan = "1/2 → 16/31"
                                            hartaAnakPerempuan = harta * 16.0/31.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianAyahnyaAyah = "1/6 → 4/31"
                                            hartaAyahnyaAyah = harta*(4.0/31.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 4/31"
                                            hartaIbunyaAyah = harta*(4.0/31.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 4/31"
                                            hartaIbunyaIbu = harta*(4.0/31.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 16/27"
                                            hartaAnakPerempuan = harta * 16.0/27.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianIstri = "1/8 → 3/27"
                                            hartaIstri = harta*(3.0/27.0)
                                            sisaHarta -= hartaIstri

                                            if(adaAyahnyaAyah && adaIbunyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/27"
                                                hartaAyahnyaAyah = harta*(4.0/27.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaAyah = "1/6 → 4/27"
                                                hartaIbunyaAyah = harta*(4.0/27.0)
                                                sisaHarta -= hartaIbunyaAyah
                                            }

                                            if(adaIbunyaAyah && adaIbunyaIbu) {
                                                bagianIbunyaAyah = "1/6 → 4/27"
                                                hartaIbunyaAyah = harta*(4.0/27.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                bagianIbunyaIbu = "1/6 → 4/27"
                                                hartaIbunyaIbu = harta*(4.0/27.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                            if(adaIbunyaIbu && adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/27"
                                                hartaAyahnyaAyah = harta*(4.0/27.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaIbu = "1/6 → 4/27"
                                                hartaIbunyaIbu = harta*(4.0/27.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                        }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 16/24"
                                            hartaAnakPerempuan = harta * 16.0/24.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianIstri = "1/8 → 3/24"
                                            hartaIstri = harta*(3.0/24.0)
                                            sisaHarta -= hartaIstri

                                            if(adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 4/24"
                                                hartaAyahnyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaAyah) {
                                                bagianIbunyaAyah = "1/6 → 4/24"
                                                hartaIbunyaAyah = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaIbu) {
                                                bagianIbunyaIbu = "1/6 → 4/24"
                                                hartaIbunyaIbu = harta*(4.0/24.0)
                                                sisaHarta -= hartaIbunyaIbu

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                        }
                                    }else {
                                        bagianAnakPerempuan = "2/3 → 16/24"
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"
                                        hartaAnakPerempuan = harta * 16.0/24.0
                                        sisaHarta = sisaHarta - hartaIstri - hartaAnakPerempuan
                                        hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                        hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    }
                                }
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(anakPerempuan == 1){
                                    if(adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu) {
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"

                                        if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                            bagianSuami = "1/8 → 3/15"
                                            hartaSuami = harta*(3.0/15.0)
                                            sisaHarta -= hartaSuami

                                            bagianAnakPerempuan = "1/2 → 6/15"
                                            hartaAnakPerempuan = harta * 6.0/15.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianAyahnyaAyah = "1/6 → 2/15"
                                            hartaAyahnyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 2/15"
                                            hartaIbunyaAyah = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 2/15"
                                            hartaIbunyaIbu = harta*(2.0/15.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 6/13"
                                            hartaAnakPerempuan = harta * 6.0/13.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianSuami = "1/8 → 3/13"
                                            hartaSuami = harta*(3.0/13.0)
                                            sisaHarta -= hartaSuami

                                            if(adaAyahnyaAyah && adaIbunyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/13"
                                                hartaAyahnyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaAyah = "1/6 → 2/13"
                                                hartaIbunyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaAyah
                                            }

                                            if(adaIbunyaAyah && adaIbunyaIbu) {
                                                bagianIbunyaAyah = "1/6 → 2/13"
                                                hartaIbunyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                bagianIbunyaIbu = "1/6 → 2/13"
                                                hartaIbunyaIbu = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                            if(adaIbunyaIbu && adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/13"
                                                hartaAyahnyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaIbu = "1/6 → 2/13"
                                                hartaIbunyaIbu = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                        }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 6/12"
                                            hartaAnakPerempuan = harta * 6.0/12.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianSuami = "1/8 → 3/12"
                                            hartaSuami = harta*(3.0/12.0)
                                            sisaHarta -= hartaSuami

                                            if(adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/12"
                                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaAyah) {
                                                bagianIbunyaAyah = "1/6 → 2/12"
                                                hartaIbunyaAyah = harta*(2.0/12.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                            if(adaIbunyaIbu) {
                                                bagianIbunyaIbu = "1/6 → 2/12"
                                                hartaIbunyaIbu = harta*(2.0/12.0)
                                                sisaHarta -= hartaIbunyaIbu

                                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                            }
                                        }
                                    }else {
                                        bagianAnakPerempuan = "1/2 → 2/4"
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"
                                        hartaAnakPerempuan = harta * 2.0/4.0
                                        sisaHarta = sisaHarta - hartaSuami - hartaAnakPerempuan
                                        hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                        hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    }
                                }else if(anakPerempuan > 1){
                                    if(adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu) {
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"

                                        if((adaAyahnyaAyah && adaIbunyaAyah) && adaIbunyaIbu) {
                                            bagianSuami = "1/8 → 3/17"
                                            hartaSuami = harta*(3.0/17.0)
                                            sisaHarta -= hartaSuami

                                            bagianAnakPerempuan = "1/2 → 8/17"
                                            hartaAnakPerempuan = harta * 8.0/17.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianAyahnyaAyah = "1/6 → 3/17"
                                            hartaAyahnyaAyah = harta*(2.0/17.0)
                                            sisaHarta -= hartaAyahnyaAyah

                                            bagianIbunyaAyah = "1/6 → 3/17"
                                            hartaIbunyaAyah = harta*(2.0/17.0)
                                            sisaHarta -= hartaIbunyaAyah

                                            bagianIbunyaIbu = "1/6 → 3/17"
                                            hartaIbunyaIbu = harta*(2.0/17.0)
                                            sisaHarta -= hartaIbunyaIbu
                                        }else if((adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && adaIbunyaIbu) || (adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 8/15"
                                            hartaAnakPerempuan = harta * 8.0/15.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianSuami = "1/8 → 3/15"
                                            hartaSuami = harta*(3.0/15.0)
                                            sisaHarta -= hartaSuami

                                            if(adaAyahnyaAyah && adaIbunyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/15"
                                                hartaAyahnyaAyah = harta*(2.0/15.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaAyah = "1/6 → 2/15"
                                                hartaIbunyaAyah = harta*(2.0/15.0)
                                                sisaHarta -= hartaIbunyaAyah
                                            }

                                            if(adaIbunyaAyah && adaIbunyaIbu) {
                                                bagianIbunyaAyah = "1/6 → 2/15"
                                                hartaIbunyaAyah = harta*(2.0/15.0)
                                                sisaHarta -= hartaIbunyaAyah

                                                bagianIbunyaIbu = "1/6 → 2/15"
                                                hartaIbunyaIbu = harta*(2.0/15.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                            if(adaIbunyaIbu && adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/15"
                                                hartaAyahnyaAyah = harta*(2.0/15.0)
                                                sisaHarta -= hartaAyahnyaAyah

                                                bagianIbunyaIbu = "1/6 → 2/15"
                                                hartaIbunyaIbu = harta*(2.0/15.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }

                                        }else if((adaAyahnyaAyah && !adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && adaIbunyaAyah && !adaIbunyaIbu) || (!adaAyahnyaAyah && !adaIbunyaAyah && adaIbunyaIbu)) {
                                            bagianAnakPerempuan = "1/2 → 8/13"
                                            hartaAnakPerempuan = harta * 8.0/13.0
                                            sisaHarta -= hartaAnakPerempuan

                                            bagianSuami = "1/8 → 3/13"
                                            hartaSuami = harta*(3.0/13.0)
                                            sisaHarta -= hartaSuami

                                            if(adaAyahnyaAyah) {
                                                bagianAyahnyaAyah = "1/6 → 2/13"
                                                hartaAyahnyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaAyahnyaAyah
                                            }
                                            if(adaIbunyaAyah) {
                                                bagianIbunyaAyah = "1/6 → 2/13"
                                                hartaIbunyaAyah = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaAyah
                                            }
                                            if(adaIbunyaIbu) {
                                                bagianIbunyaIbu = "1/6 → 2/13"
                                                hartaIbunyaIbu = harta*(2.0/13.0)
                                                sisaHarta -= hartaIbunyaIbu
                                            }
                                        }
                                    }else {
                                        bagianAnakPerempuan = "2/3 → 8/12"
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianCucuLaki = "Ashobah"
                                        hartaAnakPerempuan = harta * 8.0/12.0
                                        sisaHarta = sisaHarta - hartaSuami - hartaAnakPerempuan
                                        hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                        hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    }
                                }
                                keterangan = "Radd"
                            }
                        }

                    } else if (anakLaki >= 1) {
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta * (1.0/8.0)
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        bagianCucuPerempuan = "Mahjub"
                        bagianCucuLaki = "Mahjub"

                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            if(adaAyahnyaAyah) {
                                bagianIstri = "1/8 → 3/24"
                                bagianAyahnyaAyah = "1/6 → 4/24"
                                hartaAyahnyaAyah = harta*(4.0/24.0)
                                sisaHarta -= hartaAyahnyaAyah
                            }

                            if(adaIbunyaAyah) {
                                bagianIstri = "1/8 → 3/24"
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta*(4.0/24.0)
                                sisaHarta -= hartaIbunyaAyah
                            }

                            if(adaIbunyaIbu) {
                                bagianIstri = "1/8 → 3/24"
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta*(4.0/24.0)
                                sisaHarta -= hartaIbunyaIbu
                            }

                            sisaHarta = sisaHarta - hartaIstri
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            hartaAnakLaki = (sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()))

                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            sisaHarta = sisaHarta - hartaSuami
                            if(adaAyahnyaAyah) {
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                sisaHarta -= hartaAyahnyaAyah
                            }
                            if(adaIbunyaAyah) {
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaAyah
                            }
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            hartaAnakLaki = (sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            sisaHarta = sisaHarta - hartaAnakPerempuan - hartaAnakLaki
                        }
                    }
                }
                // Batas Suci
                // Batas Suci
                // Batas Suci
            }else if (!adaAyah && adaIbu){
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0 && !adaAyahnyaAyah) {
                                    bagianIstri = "1/4 → 3/12"
                                    bagianIbu = "1/6 → 2/12"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaIstri = harta*(3.0/12.0)
                                    sisaHarta -= hartaIstri
                                    hartaIbu = harta*(2.0/12.0)
                                    sisaHarta -= hartaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                }else if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1 && !adaAyahnyaAyah) {
                                    bagianIstri = "1/4 → 3/12"
                                    bagianIbu = "1/6 → 2/12"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaIstri = harta*(3.0/12.0)
                                    sisaHarta -= hartaIstri
                                    hartaIbu = harta*(2.0/12.0)
                                    sisaHarta -= hartaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                }else {
                                    if(adaAyahnyaAyah) {
                                        bagianIbu = "1/6 → 2/12"
                                        bagianIstri = "1/4 → 3/12"
                                        hartaIbu = harta*(2.0/12.0)
                                        hartaIstri = harta*(3.0/12.0)
                                        sisaHarta -= hartaIbu
                                        sisaHarta -= hartaIstri
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = sisaHarta
                                        sisaHarta -= hartaAyahnyaAyah
                                    }else {
                                        bagianIbu = "1/3 → 3/4"
                                        bagianIstri = "1/4 → 1/4"
                                        hartaIbu = harta*(3.0/4.0)
                                        hartaIstri = harta*(1.0/4.0)
                                        sisaHarta -= hartaIbu
                                        sisaHarta -= hartaIstri
                                    }
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) {
                                    bagianSuami = "1/2 → 3/6"
                                    bagianIbu = "1/3 → 2/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSuami = harta*(3.0/6.0)
                                    sisaHarta -= hartaSuami
                                    hartaIbu = harta*(2.0/6.0)
                                    sisaHarta -= hartaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                }else if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1) {
                                    bagianSuami = "1/2 → 3/6"
                                    bagianIbu = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSuami = harta*(3.0/6.0)
                                    sisaHarta -= hartaSuami
                                    hartaIbu = harta*(1.0/6.0)
                                    sisaHarta -= hartaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    sisaHarta -= hartaSaudaraSeayahSeibu
                                    hartaSaudariSeayahSeibu = sisaHarta
                                    sisaHarta -= hartaSaudariSeayahSeibu
                                }else {
                                    bagianSuami = "1/2 → 1/2"
                                    bagianIbu = "1/3 → 2/6"
                                    hartaSuami = harta*(1.0/2.0)
                                    hartaIbu = harta*(2.0/6.0)
                                    sisaHarta = sisaHarta - hartaSuami - hartaIbu
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianIbu = "1/6 → 7/32"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "1/2 → 21/32"
                                    hartaIbu = harta*(7.0/32.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 21.0/32.0
                                    if(adaAyahnyaAyah) {
                                        bagianIbu = "1/6 → 7/40"
                                        bagianCucuPerempuan = "1/2 → 21/40"
                                        hartaIbu = harta*(7.0/40.0)
                                        hartaCucuPerempuan = harta * 21.0/40.0
                                        bagianAyahnyaAyah = "1/6+sisa → 7/40"
                                        hartaAyahnyaAyah = harta*(7.0/40.0)
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                    sisaHarta = sisaHarta - hartaIstri - hartaIbu - hartaCucuPerempuan
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    if(adaAyahnyaAyah) {
                                        bagianAyahnyaAyah = "1/6+sisa → 2/13"
                                        hartaAyahnyaAyah = harta*(2.0/13.0)
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                    bagianSuami = "1/4 → 3/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianCucuPerempuan = "1/2 → 6/13"
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaIbu = harta*(2.0/13.0)
                                    hartaCucuPerempuan = harta *(6.0/13.0)
                                    sisaHarta = sisaHarta - hartaSuami - hartaIbu - hartaCucuPerempuan
                                }
                            }else if(cucuPerempuan > 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "2/3 → 7/10"
                                    hartaIbu = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 7.0/10.0
                                    if(adaAyahnyaAyah) {
                                        bagianIbu = "1/6 → 4/27"
                                        bagianCucuPerempuan = "2/3 → 16/27"
                                        hartaIbu = harta*(4.0/27.0)
                                        bagianIstri = "1/8 → 3/27"
                                        hartaIstri = harta*(3.0/27.0)
                                        hartaCucuPerempuan = harta * 16.0/27.0
                                        bagianAyahnyaAyah = "1/6+sisa → 4/27"
                                        hartaAyahnyaAyah = harta*(4.0/27.0)
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianSuami = "1/4 → 3/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaIbu = harta*(2.0/13.0)
                                    hartaCucuPerempuan = harta * 8.0/13.0
                                    if(adaAyahnyaAyah) {
                                        bagianSuami = "1/4 → 3/15"
                                        bagianIbu = "1/6 → 2/15"
                                        bagianCucuPerempuan = "1/2 → 8/15"
                                        hartaSuami = harta*(3.0/15.0)
                                        hartaIbu = harta*(2.0/15.0)
                                        hartaCucuPerempuan = harta * 8.0/15.0
                                        bagianAyahnyaAyah = "1/6+sisa → 2/15"
                                        hartaAyahnyaAyah = harta*(2.0/15.0)
                                        sisaHarta -= hartaAyahnyaAyah
                                    }
                                }
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 4/24"
                                hartaIbu = harta * 1.0/6.0
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                }
                                sisaHarta = sisaHarta - hartaIstri - hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = sisaHarta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 2/12"
                                hartaIbu = harta * 1.0/6.0
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 2/12"
                                    hartaAyahnyaAyah = harta*(2.0/12.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    hartaSuami = harta * (3.0/12.0)
                                    bagianSuami = "1/4 → 3/12"
                                }
                                sisaHarta = sisaHarta - hartaSuami
                                sisaHarta -= hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                sisaHarta = sisaHarta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                            }
                        }
                        //Batas Suci
                        //Batas Suci
                        //Batas Suci
                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6+sisa → 7/40"
                                    hartaAyahnyaAyah = harta*(7.0/40.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaIstri = harta * (1.0/8.0)
                                    sisaHarta = sisaHarta - hartaSuami
                                    hartaIbu = harta * (7.0/40.0)
                                    hartaAnakPerempuan = harta*(21.0/40.0)
                                }else {
                                    if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && !adaAyahnyaAyah) {
                                        bagianIbu = "1/6 → 4/24"
                                        bagianIstri = "1/8 → 3/24"
                                        bagianAnakPerempuan = "1/2 → 12/24"
                                        hartaIstri = harta*(3.0/24.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        hartaIbu = harta * (4.0/24.0)
                                        sisaHarta -= hartaIbu
                                        hartaAnakPerempuan = harta*(12.0/24.0)
                                        sisaHarta -= hartaAnakPerempuan
                                        keterangan = "Radd"

                                        if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1) {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                            sisaHarta -= hartaSaudaraSeayahSeibu
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudariSeayahSeibu = sisaHarta
                                            sisaHarta -= hartaSaudariSeayahSeibu
                                        }else if(adaSaudariSeayahSeibu == 0) {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta
                                        }else if(adaSaudaraSeayahSeibu == 0) {
                                            bagianSaudariSeayahSeibu = "Ashobah"
                                            hartaSaudariSeayahSeibu = sisaHarta
                                        }

                                    }else {
                                        bagianIbu = "1/6 → 7/32"
                                        bagianIstri = "1/8 → 1/8"
                                        bagianAnakPerempuan = "1/2 → 21/32"
                                        hartaIstri = harta*(1.0/8.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        hartaIbu = sisaHarta * (1.0/4.0)
                                        hartaAnakPerempuan = sisaHarta*(3.0/4.0)
                                        keterangan = "Radd"
                                    }
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6+sisa → 2/13"
                                    hartaAyahnyaAyah = harta*(2.0/13.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaSuami = harta * (3.0/13.0)
                                    sisaHarta = sisaHarta - hartaSuami
                                    hartaIbu = harta * (2.0/13.0)
                                    hartaAnakPerempuan = harta*(6.0/13.0)
                                }else {
                                    if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && !adaAyahnyaAyah){
                                        bagianIbu = "1/6 → 2/12"
                                        hartaIbu = harta*(2.0/12.0)
                                        sisaHarta -= hartaIbu
                                        bagianSuami = "1/4 → 3/12"
                                        hartaSuami = harta*(3.0/12.0)
                                        sisaHarta -= hartaSuami
                                        bagianAnakPerempuan = "1/2 → 6/12"
                                        hartaAnakPerempuan = harta*(6.0/12.0)
                                        sisaHarta -= hartaAnakPerempuan
                                        if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1) {
                                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            sisaHarta -= hartaSaudaraSeayahSeibu
                                            hartaSaudariSeayahSeibu = sisaHarta
                                            bagianSaudariSeayahSeibu = "Ashobah"
                                        }else if(adaSaudariSeayahSeibu == 0) {
                                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            sisaHarta -= hartaSaudaraSeayahSeibu
                                        }else if(adaSaudaraSeayahSeibu == 0) {
                                            hartaSaudariSeayahSeibu = sisaHarta * (adaSaudariSeayahSeibu + adaSaudariSeayahSeibu) / (adaSaudariSeayahSeibu + adaSaudariSeayahSeibu + adaSaudaraSeayahSeibu).toDouble()
                                            bagianSaudariSeayahSeibu = "Ashobah"
                                        }
                                    }else {
                                        bagianIbu = "1/6 → 3/16"
                                        bagianSuami = "1/4 → 1/4"
                                        bagianAnakPerempuan = "1/2 → 9/16"
                                        hartaSuami = harta * (1.0/4.0)
                                        sisaHarta = sisaHarta - hartaSuami
                                        hartaIbu = sisaHarta * (1.0/4.0)
                                        hartaAnakPerempuan = sisaHarta*(3.0/4.0)
                                        keterangan = "Radd"
                                    }
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6+sisa → 4/27"
                                    hartaAyahnyaAyah = harta*(4.0/27.0)
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    bagianCucuPerempuan = "1/2 → 4/27"
                                    hartaIbu = harta*(4.0/27.0)
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 12.0/27.0
                                    hartaCucuPerempuan = harta * 4.0/27.0
                                }else {
                                    if((adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1) && !adaAyahnyaAyah) {
                                        bagianIbu = "1/6 → 4/24"
                                        bagianIstri = "1/8 → 3/24"
                                        bagianAnakPerempuan = "1/2 → 12/24"
                                        hartaIstri = harta*(3.0/24.0)
                                        sisaHarta = sisaHarta - hartaIstri
                                        hartaIbu = harta * (4.0/24.0)
                                        sisaHarta -= hartaIbu
                                        hartaAnakPerempuan = harta*(12.0/24.0)
                                        sisaHarta -= hartaAnakPerempuan
                                        bagianCucuPerempuan = "1/6 → 4/24"
                                        hartaCucuPerempuan = harta*(4.0/24.0)
                                        sisaHarta -= hartaCucuPerempuan

                                        if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >= 1) {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                            sisaHarta -= hartaSaudaraSeayahSeibu
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudariSeayahSeibu = sisaHarta
                                            sisaHarta -= hartaSaudariSeayahSeibu
                                        }else if(adaSaudariSeayahSeibu == 0) {
                                            bagianSaudaraSeayahSeibu = "Ashobah"
                                            hartaSaudaraSeayahSeibu = sisaHarta
                                        }else if(adaSaudaraSeayahSeibu == 0) {
                                            bagianSaudariSeayahSeibu = "Ashobah"
                                            hartaSaudariSeayahSeibu = sisaHarta
                                        }

                                    }else {
                                        bagianIbu = "1/6 → 7/40"
                                        bagianIstri = "1/8 → 1/8"
                                        bagianAnakPerempuan = "1/2 → 21/40"
                                        bagianCucuPerempuan = "1/2 → 7/40"
                                        hartaIbu = harta*(7.0/40.0)
                                        hartaIstri = harta*(1.0/8.0)
                                        hartaAnakPerempuan = harta * 21.0/40.0
                                        hartaCucuPerempuan = harta * 7.0/40.0
                                    }
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6+sisa → 2/15"
                                    hartaAyahnyaAyah = harta*(2.0/15.0)
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    bagianCucuPerempuan = "1/2 → 2/15"
                                    hartaIbu = harta*(2.0/15.0)
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 6.0/15.0
                                    hartaCucuPerempuan = harta * 2.0/15.0
                                    keterangan = "Radd"
                                }else {
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaSuami = harta * (3.0/13.0)
                                    hartaIbu = harta * 2.0/13.0
                                    hartaAnakPerempuan = harta * 6.0/13.0
                                    hartaCucuPerempuan = harta * 2.0/13.0
                                    keterangan = "Radd"
                                }
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta*(4.0/24.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    hartaIstri = harta * (3.0/24.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbu = "1/6 → 4/24"
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaIbu = harta * 4.0/24.0
                                    hartaAnakPerempuan = harta * 12.0/24.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaIbu - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }else {
                                    hartaIstri = harta * (1.0/8.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbu = "1/6 → 4/24"
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaIbu = harta * 1.0/6.0
                                    hartaAnakPerempuan = harta * 12.0/24.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaIbu - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = sisaHarta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                                }

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 2/13"
                                    hartaAyahnyaAyah = harta*(2.0/13.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaIbu = harta * 2.0/13.0
                                    hartaAnakPerempuan = harta * 6.0/13.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaIbu - hartaAnakPerempuan
                                }else {
                                    hartaSuami = harta * (1.0/4.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbu = "1/6 → 2/12"
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaIbu = harta * 1.0/6.0
                                    hartaAnakPerempuan = harta * 6.0/12.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaIbu - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = sisaHarta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                                }
                            }
                        }
                        // batas suciii
                        // batas suciii
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta*(4.0/27.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaIstri = harta*(3.0/27.0)
                                    sisaHarta = sisaHarta - hartaIstri
                                    hartaIbu = harta * (4.0/27.0)
                                    hartaAnakPerempuan = harta*(16.0/27.0)
                                    keterangan = "Radd"
                                }else {
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianAnakPerempuan = "2/3 → 7/10"
                                    hartaIstri = harta*(1.0/8.0)
                                    sisaHarta = sisaHarta - hartaIstri
                                    hartaIbu = sisaHarta * (1.0/5.0)
                                    hartaAnakPerempuan = sisaHarta*(4.0/5.0)
                                    keterangan = "Radd"
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta*(2.0/15.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaSuami = harta *(3.0/15.0)
                                    hartaIbu = harta * (2.0/15.0)
                                    hartaAnakPerempuan = harta*(8.0/15.0)
                                    keterangan = "Aul"
                                }else {
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaSuami = harta *(3.0/13.0)
                                    hartaIbu = harta * (2.0/13.0)
                                    hartaAnakPerempuan = harta*(8.0/13.0)
                                    keterangan = "Aul"
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta*(4.0/27.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaIstri = harta*(3.0/27.0)
                                    sisaHarta = sisaHarta - hartaIstri
                                    hartaIbu = harta * (4.0/27.0)
                                    hartaAnakPerempuan = harta*(16.0/27.0)
                                    bagianCucuPerempuan = "Ashobah"
                                }else {
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianAnakPerempuan = "1/2 → 7/10"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaIbu = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaAnakPerempuan = harta * 7.0/10.0
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta*(2.0/15.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaSuami = harta *(3.0/15.0)
                                    hartaIbu = harta * (2.0/15.0)
                                    hartaAnakPerempuan = harta*(8.0/15.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    keterangan = "Radd"
                                }else {
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaSuami = harta * (3.0/13.0)
                                    hartaIbu = harta * 2.0/13.0
                                    hartaAnakPerempuan = harta * 8.0/13.0
                                    keterangan = "Radd"
                                }
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 3/13"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta*(4.0/27.0)
                                    sisaHarta -= hartaAyahnyaAyah
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaIstri = harta*(3.0/27.0)
                                    sisaHarta = sisaHarta - hartaIstri
                                    hartaIbu = harta * (4.0/27.0)
                                    hartaAnakPerempuan = harta*(16.0/27.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    keterangan = "Radd"
                                }else {
                                    hartaIstri = harta * (1.0/8.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbu = "1/6 → 4/24"
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaIbu = harta * 1.0/6.0
                                    hartaAnakPerempuan = harta * 16.0/24.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaIbu - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = sisaHarta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan
                                }

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaAyahnyaAyah) {
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta*(2.0/15.0)
                                    sisaHarta -= hartaAyahnyaAyah

                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaSuami = harta *(3.0/15.0)
                                    hartaIbu = harta * (2.0/15.0)
                                    hartaAnakPerempuan = harta*(8.0/15.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    keterangan = "Radd"
                                }else {
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaIbu = harta * 2.0/13.0
                                    hartaAnakPerempuan = harta * 8.0/13.0
//                                sisaHarta = sisaHarta - hartaSuami - hartaIbu - hartaAnakPerempuan
//                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = sisaHarta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                                }
                            }
                        }

                    }
                    //batas suci
                    //batas suci
                    //batas suci
                    //batas suci
                }else if (anakLaki >= 1) {
                    // Ada Ibu, ada suami/istri, ada anak laki
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    if (anakPerempuan == 0) {
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)
                        hartaIbu = harta * (1.0/6.0)

                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbu = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            bagianAnakLaki = "Ashobah"
                            sisaHarta = sisaHarta - (hartaIstri + hartaIbu)
                            if(adaAyahnyaAyah) {
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                sisaHarta -= hartaAyahnyaAyah
                                hartaAnakLaki = sisaHarta
                            }else {
                                hartaAnakLaki = sisaHarta
                                sisaHarta -= hartaAnakLaki
                            }
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianIbu = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            bagianAnakLaki = "Ashobah"
                            sisaHarta = sisaHarta - (hartaSuami + hartaIbu)
                            if(adaAyahnyaAyah) {
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                sisaHarta -= hartaAyahnyaAyah
                                hartaAnakLaki = sisaHarta
                            }else {
                                hartaAnakLaki = sisaHarta
                                sisaHarta -= hartaAnakLaki
                            }
                        }
                    }else if (anakPerempuan >= 1) {
                        hartaIbu = harta * (1.0/6.0)
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)

                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"

                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIstri = "1/8 → 3/24"
                            bagianIbu = "1/6 → 4/24"
                            sisaHarta = sisaHarta - (hartaIstri + hartaIbu)
                            if(adaAyahnyaAyah) {
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                sisaHarta -= hartaAyahnyaAyah
                                hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                                hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            }else {
                                hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                                hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            }
                            sisaHarta -= hartaAnakLaki
                            sisaHarta -= hartaAnakPerempuan
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianIbu = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = sisaHarta - (hartaSuami + hartaIbu)

                            if(adaAyahnyaAyah) {
                                hartaAyahnyaAyah = harta*(2.0/12.0)
                                bagianAyahnyaAyah = "1/6 → 2/12"
                                sisaHarta -= hartaAyahnyaAyah
                                hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                                hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            }else {
                                hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                                hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            }

                            sisaHarta -= hartaAnakLaki
                            sisaHarta -= hartaAnakPerempuan
                        }
                    }
                }
                // Batas suci
                // Batas suci
                // Batas suci                // Batas suci (titik akhir)

            }else if (adaAyah && !adaIbu){
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaIstri = harta * (1.0 / 4.0)
                            hartaSuami = harta * (1.0 / 2.0)
                            bagianAyah = "Ashobah"
                            bagianSuami = "1/2 → 1/2"
                            bagianIstri = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")) {
                                if(adaIbunyaIbu) {
                                    hartaIbunyaIbu = harta*(2.0/12.0)
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    sisaHarta -= hartaIbunyaIbu
                                    sisaHarta -= hartaIstri
                                    hartaAyah = sisaHarta
                                }else {
                                    hartaAyah = harta*(3.0/4.0)
                                }
                            } else if (jenisKelaminPewaris.equals("Perempuan")) {
                                if(adaIbunyaIbu) {
                                    sisaHarta -= hartaSuami
                                    hartaIbunyaIbu = harta*(1.0/6.0)
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    sisaHarta -= hartaIbunyaIbu
                                    hartaAyah = sisaHarta
                                }else {
                                    hartaAyah = harta*(1.0/2.0)
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    if(adaIbunyaIbu) {
                                        bagianAyah = "1/6+sisa → 7/40"
                                        bagianIstri = "1/8 → 1/8"
                                        bagianCucuPerempuan = "1/2 → 21/40"
                                        hartaAyah = harta*(7.0/40.0)
                                        hartaIstri = harta*(1.0/8.0)
                                        hartaCucuPerempuan = harta * 21.0/40.0
                                        bagianIbunyaIbu = "1/6 → 7/40"
                                        hartaIbunyaIbu = harta*(7.0/40.0)
                                    }else {
                                        bagianAyah = "1/6+sisa → 7/32"
                                        bagianIstri = "1/8 → 1/8"
                                        bagianCucuPerempuan = "1/2 → 21/32"
                                        hartaAyah = harta*(7.0/32.0)
                                        hartaIstri = harta*(1.0/8.0)
                                        hartaCucuPerempuan = harta * 21.0/32.0
                                    }
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    if(adaIbunyaIbu) {
                                        bagianSuami = "1/4 → 3/13"
                                        bagianAyah = "1/6+sisa → 2/13"
                                        bagianCucuPerempuan = "1/2 → 6/13"
                                        hartaSuami = harta*(3.0/13.0)
                                        hartaAyah = harta*(2.0/13.0)
                                        hartaCucuPerempuan = harta * 6.0/13.0
                                        bagianIbunyaIbu = "1/6 → 2/13"
                                        hartaIbunyaIbu = harta*(2.0/13.0)
                                    }else {
                                        bagianSuami = "1/4 → 1/4"
                                        bagianAyah = "1/6+sisa → 3/16"
                                        bagianCucuPerempuan = "1/2 → 9/16"
                                        hartaSuami = harta*(1.0/4.0)
                                        hartaAyah = harta*(3.0/16.0)
                                        hartaCucuPerempuan = harta * 9.0/16.0
                                    }
                                }
                            }else if(cucuPerempuan > 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    if(adaIbunyaIbu) {
                                        bagianAyah = "1/6+sisa → 4/27"
                                        bagianIstri = "1/8 → 3/27"
                                        bagianCucuPerempuan = "2/3 → 16/27"
                                        hartaAyah = harta*(4.0/27.0)
                                        hartaIstri = harta*(3.0/27.0)
                                        hartaCucuPerempuan = harta * 16.0/27.0
                                        bagianIbunyaIbu = "1/6 → 4/27"
                                        hartaIbunyaIbu = harta*(4.0/27.0)
                                    }else {
                                        bagianAyah = "1/6+sisa → 7/40"
                                        bagianIstri = "1/8 → 1/8"
                                        bagianCucuPerempuan = "2/3 → 7/10"
                                        hartaAyah = harta*(7.0/40.0)
                                        hartaIstri = harta*(1.0/8.0)
                                        hartaCucuPerempuan = harta * 7.0/10.0
                                    }
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    if(adaIbunyaIbu) {
                                        bagianSuami = "1/4 → 3/15"
                                        bagianAyah = "1/6+sisa → 2/15"
                                        bagianCucuPerempuan = "2/3 → 8/15"
                                        hartaSuami = harta*(3.0/15.0)
                                        hartaAyah = harta*(2.0/15.0)
                                        hartaCucuPerempuan = harta * 8.0/15.0
                                        bagianIbunyaIbu = "1/6 → 2/15"
                                        hartaIbunyaIbu = harta*(2.0/15.0)
                                    }else {
                                        bagianSuami = "1/4 → 3/13"
                                        bagianAyah = "1/6+sisa → 2/13"
                                        bagianCucuPerempuan = "1/2 → 8/13"
                                        hartaSuami = harta*(3.0/13.0)
                                        hartaAyah = harta*(2.0/13.0)
                                        hartaCucuPerempuan = harta * 8.0/13.0
                                    }
                                }
                            }
                        }else if(cucuLaki > 0 && cucuPerempuan == 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                sisaHarta = sisaHarta - hartaIstri
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta*(2.0/12.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                sisaHarta = sisaHarta - hartaSuami
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()
                            }

                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyah = "1/6+sisa → 4/24"
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = sisaHarta - hartaIstri - hartaAyah
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta*(2.0/12.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6+sisa → 2/12"
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = sisaHarta - hartaSuami - hartaAyah
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                            }
                        }
                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaAyah = harta*(1.0/6.0)
                            hartaSuami = harta * (1.0/4.0)
                            hartaIstri = harta*(1.0/8.0)
                            hartaAnakPerempuan = harta*(1.0/2.0)

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIstri = "1/8 → 1/8"
                                hartaIstri = harta*(1.0/8.0)
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6+sisa → 7/40"
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaAnakPerempuan = harta*(21.0/40.0)
                                    bagianIbunyaIbu = "1/6 → 7/40"
                                    hartaIbunyaIbu = harta*(7.0/40.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+Ashobah → 7/32"
                                    bagianAnakPerempuan = "1/2 → 21/32"
                                    hartaAyah = harta*(7.0/32.0)
                                    hartaAnakPerempuan = harta*(21.0/32.0)
                                }

                            } else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaSuami = harta * (3.0/13.0)
                                    hartaAnakPerempuan = harta*(6.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta*(2.0/13.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+Ashobah → 3/16"
                                    bagianSuami = "1/4 → 1/4"
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    hartaAyah = harta*(3.0/16.0)
                                    hartaSuami = harta * (1.0/4.0)
                                    hartaAnakPerempuan = harta*(9.0/16.0)
                                }

                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6+ → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianCucuPerempuan = "1/2 → 4/27"
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 12.0/27.0
                                    hartaCucuPerempuan = harta * 4.0/27.0
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta*(4.0/27.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+sisa → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "1/2 → 7/40"
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaAnakPerempuan = harta * 21.0/40.0
                                    hartaCucuPerempuan = harta * 7.0/40.0
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianCucuPerempuan = "1/6 → 2/15"
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 6.0/15.0
                                    hartaCucuPerempuan = harta * 2.0/15.0
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta*(2.0/15.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaAnakPerempuan = harta * 6.0/13.0
                                    hartaCucuPerempuan = harta * 2.0/13.0
                                }
                            }

                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta*(4.0/24.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyah = "1/6+sisa → 4/24"
                                bagianAnakPerempuan = "1/2 → 12/24"
                                hartaAyah = harta * (1.0/6.0)
                                hartaAnakPerempuan = harta * 12.0/24.0
                                sisaHarta = sisaHarta - hartaIstri - hartaAyah - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianSuami = "1/4 → 3/13"
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta*(2.0/13.0)
                                    sisaHarta -= hartaIbunyaIbu
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAyah = harta * (2.0/13.0)
                                    hartaAnakPerempuan = harta * 6.0/13.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                }else {
                                    hartaSuami = harta * (1.0/4.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyah = "1/6+sisa → 2/12"
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAyah = harta * (1.0/6.0)
                                    hartaAnakPerempuan = harta * 6.0/12.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }
                            }
                        }
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaAnakPerempuan = harta*(16.0/27.0)
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta*(4.0/27.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+Ashobah → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianAnakPerempuan = "2/3 → 7/10"
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaAnakPerempuan = harta*(7.0/10.0)
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaSuami = harta *(3.0/15.0)
                                    hartaAnakPerempuan = harta*(8.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta*(2.0/15.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+Ashobah → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaSuami = harta *(3.0/13.0)
                                    hartaAnakPerempuan = harta*(8.0/13.0)
                                    keterangan = "Aul"
                                }
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianCucuPerempuan = "Mahjub"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 16.0/27.0
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta*(4.0/27.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+sisa → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "Mahjub"
                                    bagianAnakPerempuan = "2/3 → 7/10"
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaAnakPerempuan = harta * 7.0/10.0
                                }
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianAyah = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianCucuPerempuan = "Mahjub"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 8.0/15.0
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta*(2.0/15.0)
                                    sisaHarta -= hartaIbunyaIbu
                                }else {
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianCucuPerempuan = "Mahjub"
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaAnakPerempuan = harta * 8.0/13.0
                                }
                            }
// Batas suci part 3
                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta*(4.0/27.0)
                                    sisaHarta -= hartaIbunyaIbu
                                    hartaIstri = harta * (3.0/27.0)
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyah = "1/6 → 4/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    bagianIstri = "1/8 → 3/27"
                                    hartaAyah = harta * (4.0/27.0)
                                    hartaAnakPerempuan = harta * 16.0/27.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaAyah - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }else {
                                    hartaIstri = harta * (1.0/8.0)
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyah = "1/6+sisa → 4/24"
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    bagianIstri = "1/8 → 1/8"
                                    hartaAyah = harta * (1.0/6.0)
                                    hartaAnakPerempuan = harta * 16.0/24.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaAyah - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(adaIbunyaIbu) {
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta*(2.0/15.0)
                                    sisaHarta -= hartaIbunyaIbu
                                    hartaSuami = harta * (3.0/15.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyah = "1/6+sisa → 2/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    bagianSuami = "1/4 → 3/15"
                                    hartaAyah = harta * (2.0/15.0)
                                    hartaAnakPerempuan = harta * 8.0/15.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }else {
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    bagianSuami = "1/4 → 3/13"
                                    hartaAyah = harta * (2.0/13.0)
                                    hartaAnakPerempuan = harta * 8.0/13.0
                                    sisaHarta = sisaHarta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }
                            }
                        }
                    }
                }else if (anakLaki >= 1) {
                    // Ada Ayah, ada suami/istri, ada anak laki
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    if (anakPerempuan == 0) {
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)
                        hartaAyah = harta * (1.0/6.0)

                        bagianAnakLaki = "Ashobah"

                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta*(4.0/24.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            bagianAyah = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            sisaHarta = sisaHarta - (hartaIstri + hartaAyah)
                            hartaAnakLaki = sisaHarta
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            bagianAyah = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = sisaHarta - (hartaSuami + hartaAyah)
                            hartaAnakLaki = sisaHarta
                        }
                    }else if (anakPerempuan >= 1) {
                        hartaAyah = harta * (1.0/6.0)
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)




                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"


                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta*(4.0/24.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            bagianAyah = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            sisaHarta = sisaHarta - (hartaIstri + hartaAyah)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            if(adaIbunyaIbu) {
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta*(2.0/12.0)
                                sisaHarta -= hartaIbunyaIbu
                            }
                            bagianAyah = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = sisaHarta - (hartaSuami + hartaAyah)
                        }
                        hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                        hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                    }
                }
                // Batas suci ini bang
            }else if (adaAyah && adaIbu){
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaAyah = harta * (2.0 / 6.0)
                            hartaSuami = harta *(1.0/2.0)
                            hartaIstri = harta*(1.0/4.0)
                            bagianAyah = "Ashobah"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIbu = "U"
                                bagianIstri = "1/4 → 1/4"
                                hartaIbu = harta*(1.0/4.0)
                                sisaHarta = sisaHarta - (hartaAyah + hartaIbu + hartaIstri)
                                hartaAyah += sisaHarta

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianIbu = "U"
                                bagianSuami = "1/2 → 1/2"
                                hartaIbu = harta*(1.0/6.0)
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 7/40"
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "1/2 → 21/40"
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaIbu = harta * 7.0/40.0
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 21.0/40.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianCucuPerempuan = "1/2 → 6/13"
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaIbu = harta * 2.0/13.0
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaCucuPerempuan = harta * 6.0/13.0
                                }
                            }else if(cucuPerempuan > 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 4/27"
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianCucuPerempuan = "2/3 → 16/27"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIbu = harta * 4.0/27.0
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaCucuPerempuan = harta * 16.0/27.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianAyah = "1/6+sisa → 2/15"
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianCucuPerempuan = "2/3 → 8/15"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaIbu = harta * 2.0/15.0
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaCucuPerempuan = harta * 8.0/15.0
                                }
                            }
                        }else if(cucuLaki > 0 && cucuPerempuan == 0) {
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                bagianIbu = "1/4 → 4/24"
                                bagianIstri = "1/8 → 1/8"
                                hartaIbu = harta * 4.0/24.0
                                sisaHarta = sisaHarta - hartaIstri -hartaIbu
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                bagianSuami= "1/4 → 3/12"
                                bagianIbu = "1/6 → 2/12"
                                sisaHarta = sisaHarta - hartaSuami - hartaIbu
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()
                            }

                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyah = "1/6+sisa → 4/24"
                                bagianIbu = "1/6 → 4/24"
                                hartaIbu = harta * 4.0/24.0
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = sisaHarta - hartaIstri - hartaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6+sisa → 2/12"
                                bagianIbu = "1/6 → 2/12"
                                hartaIbu = harta * 2.0/12.0
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = sisaHarta - hartaSuami - hartaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                            }
                        }
                        // Batas suci selanjut
                    }else if (anakPerempuan >= 1) {
                        if (anakPerempuan == 1) {

                            if(cucuPerempuan == 0 && cucuLaki == 0){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaAyah = harta * 7.0/40.0
                                    hartaIbu = harta*(1.0/6.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaAnakPerempuan = harta*(1.0/2.0)
                                    bagianAyah = "1/6+Ashobah → 7/40"
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri ="1/8 → 1/8"
                                    bagianAnakPerempuan = "1/2 → 21/40"
//                                    sisaHarta = sisaHarta - (hartaAyah + hartaIbu + hartaIstri + hartaAnakPerempuan)
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaIbu = harta*(2.0/13.0)
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaAnakPerempuan = harta*(6.0/13.0)
                                    bagianAyah = "1/6+Ashobah → 2/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    keterangan = "Aul"
                                }
                                // batas suci part 6
                            }else if(cucuPerempuan > 0 && cucuLaki == 0){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 4/27"
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    bagianCucuPerempuan = "1/6 → 4/27"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIbu = harta * 4.0/27.0
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 12.0/27.0
                                    hartaCucuPerempuan = harta * 4.0/27.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianAyah = "1/6+sisa → 2/15"
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    bagianCucuPerempuan = "1/6 → 2/15"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaIbu = harta * 2.0/15.0
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 6.0/15.0
                                    hartaCucuPerempuan = harta * 2.0/15.0
                                }

                            }else if(cucuLaki > 0 || cucuPerempuan > 0){

                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * (1.0/8.0)
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyah = "1/6+sisa → 4/24"
                                    bagianIbu = "1/6 → 4/24"
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaIbu = harta * 4.0/24.0
                                    hartaAyah = harta * (1.0/6.0)
                                    hartaAnakPerempuan = harta * 12.0/24.0
                                    sisaHarta = sisaHarta - hartaIstri - hartaAyah - hartaIbu - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta * (3.0/13.0)
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    bagianSuami = "1/4 → 1/4"
                                    hartaIbu = harta * 2.0/13.0
                                    hartaAyah = harta * (2.0/13.0)
                                    hartaAnakPerempuan = harta * 6.0/13.0
                                }
                            }
                            // batas suciiii 90
                        }else if (anakPerempuan > 1) {
                            if(cucuPerempuan == 0 && cucuLaki == 0){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIbu = harta*(4.0/27.0)
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta*(16.0/27.0)
                                    bagianAyah = "1/6+Ashobah → 4/27"
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri ="1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"

                                    sisaHarta = sisaHarta - (hartaAyah + hartaIbu + hartaIstri + hartaAnakPerempuan)
                                    hartaAyah += sisaHarta
                                    keterangan = "Aul"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaIbu = harta*(2.0/15.0)
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta*(8.0/15.0)
                                    bagianAyah = "2/15+Ashobah → 2/15"
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami ="1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    keterangan = "Aul"
                                }
                            }else if(cucuPerempuan > 0 && cucuLaki == 0){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 4/27"
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIbu = harta * 4.0/27.0
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 16.0/27.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianAyah = "1/6+sisa → 2/15"
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaIbu = harta * 2.0/15.0
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 8.0/15.0
                                }

                            }else if(cucuLaki > 0 || cucuPerempuan > 0){

                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 4/27"
                                    bagianIbu = "1/6 → 4/27"
                                    bagianIstri = "1/8 → 3/27"
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAyah = harta*(4.0/27.0)
                                    hartaIbu = harta * 4.0/27.0
                                    hartaIstri = harta*(3.0/27.0)
                                    hartaAnakPerempuan = harta * 16.0/27.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianAyah = "1/6+sisa → 2/15"
                                    bagianIbu = "1/6 → 2/15"
                                    bagianSuami = "1/4 → 3/15"
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAyah = harta*(2.0/15.0)
                                    hartaIbu = harta * 2.0/15.0
                                    hartaSuami = harta*(3.0/15.0)
                                    hartaAnakPerempuan = harta * 8.0/15.0
                                }
                            }
                        }
                    }
                }else if (anakLaki >= 1) {
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    if (anakPerempuan == 0) {
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIbu = harta*(1.0/6.0)
                            hartaAyah = harta * (1.0 / 6.0)
                            hartaIstri = harta *(1.0/8.0)
                            sisaHarta = sisaHarta - (hartaIbu + hartaAyah + hartaIstri)
                            hartaAnakLaki = sisaHarta
                            bagianAyah = "1/6 → 4/24"
                            bagianIbu = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            bagianAnakLaki = "Ashobah"

                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaIbu = harta*(1.0/6.0)
                            hartaAyah = harta * (1.0 / 6.0)
                            hartaSuami = harta *(1.0/4.0)
                            sisaHarta = sisaHarta - (hartaIbu + hartaAyah + hartaSuami)
                            hartaAnakLaki = sisaHarta
                            bagianAyah = "1/6 → 2/12"
                            bagianIbu = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            bagianAnakLaki = "Ashobah"
                        }
                    }else if (anakPerempuan >= 1) {
                        if (anakPerempuan >= 1) {
                            bagianAyah = "1/6 → 4/24"
                            bagianIbu = "1/6 → 4/24"
                            bagianAnakLaki = "Ashobah"
                            bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                            hartaIbu = harta*(1.0/6.0)
                            hartaAyah = harta * (1.0 / 6.0)
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta*(1.0/8.0)
                                sisaHarta = sisaHarta - (hartaIbu + hartaAyah + hartaIstri)
                                bagianIstri ="1/8 → 3/24"

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta *(1.0/4.0)
                                sisaHarta = sisaHarta - (hartaIbu + hartaAyah + hartaSuami)
                                bagianSuami = "1/4 → 3/12"

                            }
                            hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            hartaAnakPerempuan = sisaHarta * anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        }
                    }
                }
            }
        }

        // Bagian ayahnya ayah (kakek paternal)
        if(adaAyahnyaAyah && !adaIbu && istri == 0 && !adaSuami && anakLaki == 0 && anakPerempuan == 0 && cucuLaki == 0 && cucuPerempuan == 0 && adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) {
            if(adaIbunyaAyah || adaIbunyaIbu) {
                sisaHarta = harta
            }
            if(adaIbunyaAyah) sisaHarta -= harta*(1.0/6.0)
            if(adaIbunyaIbu) sisaHarta -= harta*(1.0/6.0)
            if (!adaAyah) {
                hartaAyahnyaAyah = sisaHarta
                bagianAyahnyaAyah = "Ashobah"
            } else {
                bagianAyahnyaAyah = "Mahjub"
                hartaAyahnyaAyah = 0.0
            }
        }
        if (adaAyahnyaAyah && (hartaAyahnyaAyah < 1)) {
            if (!adaAyah) {
                hartaAyahnyaAyah = sisaHarta
                bagianAyahnyaAyah = "Ashobah"
            } else {
                bagianAyahnyaAyah = "Mahjub"
                hartaAyahnyaAyah = 0.0
            }
            sisaHarta -= hartaAyahnyaAyah
        }

        if(adaAyahnyaAyah && hartaAyahnyaAyah < 1) {
            if(adaIbu && istri == 0 && !adaAyah && !adaSuami && anakLaki == 0 && anakPerempuan == 0 && cucuLaki == 0 && cucuPerempuan == 0 && adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) {
                sisaHarta = harta
                bagianIbu = "1/3 → 1/3"
                hartaIbu = harta*(1.0/3.0)
                sisaHarta -= hartaIbu
                bagianAyahnyaAyah = "Ashobah"
                hartaAyahnyaAyah = sisaHarta
            }
        }

        // Bagian ibunya ayah (nenek paternal)
        if (adaIbunyaAyah && hartaIbunyaAyah < 1) {
            if (!adaAyah && !adaIbu) {
                hartaIbunyaAyah = sisaHarta
                bagianIbunyaAyah = "Ashobah"
            } else {
                bagianIbunyaAyah = "Mahjub"
                hartaIbunyaAyah = 0.0
            }
            sisaHarta -= hartaIbunyaAyah
        }

        // Bagian ibunya ibu (nenek maternal)
        if(adaIbunyaIbu && adaIbunyaAyah && !adaAyah && !adaIbu && !adaAyahnyaAyah && istri == 0 && !adaSuami && anakLaki == 0 && anakPerempuan == 0 && cucuLaki == 0 && cucuPerempuan == 0){
            hartaIbunyaIbu = harta*(1.0/2.0)
            bagianIbunyaIbu = "1/6 → 1/2"
            bagianIbunyaAyah = "1/6 → 1/2"
            hartaIbunyaAyah = harta*(1.0/2.0)
        }
        if (adaIbunyaIbu && hartaIbunyaIbu < 1) {
            if (!adaIbu) {
                hartaIbunyaIbu = sisaHarta
                bagianIbunyaIbu = "Ashobah"
            } else {
                bagianIbunyaIbu = "Mahjub"
                hartaIbunyaIbu = 0.0
            }
            sisaHarta -= hartaIbunyaIbu
        }

        // Bagian saudari seayah seibu
        if (adaSaudariSeayahSeibu >= 1 && hartaSaudariSeayahSeibu < 1) {
            if (anakLaki > 0 || cucuLaki > 0 || adaSaudaraSeayahSeibu >= 1) {
                bagianSaudariSeayahSeibu = "Mahjub"
                hartaSaudariSeayahSeibu = 0.0
            } else {
                hartaSaudariSeayahSeibu = sisaHarta * ((adaSaudariSeayahSeibu + adaSaudariSeayahSeibu) / (adaSaudariSeayahSeibu + adaSaudariSeayahSeibu + adaSaudaraSeayahSeibu).toDouble())
                if (anakPerempuan > 0 || adaIbu) {
                    bagianSaudariSeayahSeibu = "Mahjub"
                    hartaSaudariSeayahSeibu = 0.0
                } else {
                    bagianSaudariSeayahSeibu = "Ashobah"
                }
                sisaHarta -= hartaSaudariSeayahSeibu
            }
        }

        // Bagian saudara seayah seibu
        if (adaSaudaraSeayahSeibu >= 1 && hartaSaudaraSeayahSeibu < 1 && !adaAyahnyaAyah) {
            if (anakLaki > 0 || cucuLaki > 0 || adaSaudariSeayahSeibu >= 1) {
                bagianSaudaraSeayahSeibu = "Mahjub"
                hartaSaudaraSeayahSeibu = 0.0
            } else {
                hartaSaudaraSeayahSeibu = sisaHarta * ((adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble())
                if (anakPerempuan > 0 || adaIbu) {
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    hartaSaudaraSeayahSeibu = 0.0
                } else {
                    bagianSaudaraSeayahSeibu = "Ashobah"
                }
                sisaHarta -= hartaSaudaraSeayahSeibu
            }
        }

        val data: ArrayList<WarisData> = ArrayList()

        if (adaIbu || adaAyah || adaSuami || istri >= 1 || anakPerempuan >= 1 || anakLaki >= 1 || cucuLaki >= 1 || cucuPerempuan >= 1 || adaAyahnyaAyah || adaIbunyaAyah || adaIbunyaIbu || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1){
            if (adaAyah) {
                data.add(WarisData("Ayah",bagianAyah, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaAyah), ConvertToRupiah().convertToRupiahFormat(hartaAyah), keterangan))
            }
            if (adaIbu){
                data.add(WarisData("Ibu",bagianIbu, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbu), ConvertToRupiah().convertToRupiahFormat(hartaIbu), keterangan))
            }
            if(jenisKelaminPewaris == "Laki-Laki"){
                if (istri >= 1) {
                    data.add(WarisData("Istri",bagianIstri, istri,
                        ConvertToRupiah().convertToRupiahFormat(hartaIstri), ConvertToRupiah().convertToRupiahFormat(hartaIstri/istri), keterangan))
                }
            }else{
                if (adaSuami) {
                    data.add(WarisData("Suami",bagianSuami, 1,
                        ConvertToRupiah().convertToRupiahFormat(hartaSuami), ConvertToRupiah().convertToRupiahFormat(hartaSuami), keterangan))
                }
            }
            if (adaAyahnyaAyah) {
                data.add(
                    WarisData("Ayahnya ayah", bagianAyahnyaAyah, 1,
                        ConvertToRupiah().convertToRupiahFormat(hartaAyahnyaAyah), ConvertToRupiah().convertToRupiahFormat(hartaAyahnyaAyah), keterangan)
                )
            }
            if (adaIbunyaAyah) {
                data.add(WarisData("Ibunya ayah", bagianIbunyaAyah, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbunyaAyah), ConvertToRupiah().convertToRupiahFormat(hartaIbunyaAyah), keterangan))
            }
            if (adaSaudaraSeayahSeibu >= 1) {
                data.add(WarisData("Saudara seayah-seibu", bagianSaudaraSeayahSeibu, adaSaudaraSeayahSeibu,
                    ConvertToRupiah().convertToRupiahFormat(hartaSaudaraSeayahSeibu), ConvertToRupiah().convertToRupiahFormat(hartaSaudaraSeayahSeibu/adaSaudaraSeayahSeibu), keterangan))
            }
            if (adaSaudariSeayahSeibu >= 1) {
                data.add(WarisData("Saudari seayah-seibu", bagianSaudariSeayahSeibu, adaSaudariSeayahSeibu,
                    ConvertToRupiah().convertToRupiahFormat(hartaSaudariSeayahSeibu), ConvertToRupiah().convertToRupiahFormat(hartaSaudariSeayahSeibu/adaSaudariSeayahSeibu), keterangan))
            }
            if (adaIbunyaIbu) {
                data.add(WarisData("Ibunya Ibu", bagianIbunyaIbu, 1,
                    ConvertToRupiah().convertToRupiahFormat(hartaIbunyaIbu), ConvertToRupiah().convertToRupiahFormat(hartaIbunyaIbu), keterangan))
            }
            if (anakLaki >= 1) {
                data.add(WarisData("Anak Laki-Laki",bagianAnakLaki, anakLaki,
                    ConvertToRupiah().convertToRupiahFormat(hartaAnakLaki), ConvertToRupiah().convertToRupiahFormat(hartaAnakLaki/anakLaki), keterangan))
            }
            if (anakPerempuan >= 1) {
                data.add(WarisData("Anak Perempuan",bagianAnakPerempuan, anakPerempuan,
                    ConvertToRupiah().convertToRupiahFormat(hartaAnakPerempuan), ConvertToRupiah().convertToRupiahFormat(hartaAnakPerempuan/anakPerempuan), keterangan))
            }
            if (cucuLaki >= 1) {
                data.add(WarisData("Cucu Laki-Laki",bagianCucuLaki, cucuLaki,
                    ConvertToRupiah().convertToRupiahFormat(hartaCucuLaki), ConvertToRupiah().convertToRupiahFormat(hartaCucuLaki/cucuLaki), keterangan))
            }
            if (cucuPerempuan >= 1) {
                data.add(WarisData("Cucu Perempuan",bagianCucuPerempuan, cucuPerempuan,
                    ConvertToRupiah().convertToRupiahFormat(hartaCucuPerempuan), ConvertToRupiah().convertToRupiahFormat(hartaCucuPerempuan/cucuPerempuan), keterangan))
            }
        } else{
            data.add(WarisData("Baitul Mal","1/1", 0,
                ConvertToRupiah().convertToRupiahFormat(harta), ConvertToRupiah().convertToRupiahFormat(harta), keterangan))
        }
        if (!adaIbu && !adaAyah && (adaSuami || istri >= 1) && anakPerempuan < 1 && anakLaki < 1 && cucuLaki < 1 && cucuPerempuan < 1){
            data.add(WarisData("Baitul Mal", "Ashobah", 0, ConvertToRupiah().convertToRupiahFormat(sisaHarta), ConvertToRupiah().convertToRupiahFormat(sisaHarta), keterangan))
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