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
import com.ch.al_mirats.presentation.kalkulator.data_waris.WarisData
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
        val harta = (totalHarta - (hutang + biayaPerawatanJenazah + wasiat))


        val jenisKelaminPewaris = intent.getStringExtra("jenisKelaminPewaris")
        val adaAyah = intent.getBooleanExtra("ayah", false)
        val adaIbu = intent.getBooleanExtra("ibu", false)
        val adaSuami = intent.getBooleanExtra("suami", false)
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
        var bagianIstri = ""
        var bagianAnakPerempuan = ""
        var bagianAnakLaki = ""
        var bagianCucuLaki = ""
        var bagianCucuPerempuan = ""

        var hartaAyah = 0.0
        var hartaIbu = 0.0
        var hartaSuami = 0.0
        var hartaIstri = 0.0
        var hartaAnakLaki = 0.0
        var hartaAnakPerempuan = 0.0
        var hartaCucuLaki = 0.0
        var hartaCucuPerempuan = 0.0

        var sisaHarta = 0.0

        if(!adaSuami && istri == 0){
            if (!adaAyah && !adaIbu) {
                if (anakPerempuan == 0) {
                    if (anakLaki >= 1) {
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta
                        bagianCucuLaki = "Mahjub"
                        bagianCucuPerempuan = "Mahjub"
                    }else if(anakLaki == 0){
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                        hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                    }
                } else if (anakPerempuan == 1) {
                    if (anakLaki == 0) {
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            bagianAnakPerempuan = "1/2 → 1/1"
                            hartaAnakPerempuan = harta
                            keterangan = "Radd"
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianAnakPerempuan = "1/2 → 1/2"
                            hartaAnakPerempuan = harta * 0.5
//                            sisaHarta = harta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1.0/2.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAnakPerempuan = "1/2 → 1/2"
                            hartaAnakPerempuan = harta * 0.5
                            sisaHarta = harta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAnakPerempuan = "1/2 → 1/4"
                            hartaAnakPerempuan = harta * 3.0/4.0
//                            sisaHarta = harta - hartaAnakPerempuan
                            bagianCucuPerempuan = "1/6 → 1/4"
                            hartaCucuPerempuan = harta * 1.0/4.0
                        }

                    } else if (anakLaki >= 1) {
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        bagianCucuLaki = "Mahjub"
                        bagianCucuPerempuan = "Mahjub"
                        hartaAnakLaki = harta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (harta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }

                } else if(anakPerempuan > 1){
                    if (anakLaki == 0) {
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            bagianAnakPerempuan = "1/2 → 1/1"
                            hartaAnakPerempuan = harta
                            keterangan = "Radd"
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianAnakPerempuan = "2/3 → 1/1"
                            hartaAnakPerempuan = harta * 1.0/1.0
                            sisaHarta = harta - hartaAnakPerempuan
                            bagianCucuPerempuan = "Mahjub"
                        } else if(cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianAnakPerempuan = "2/3 → 2/3"
                            hartaAnakPerempuan = harta * 2.0/3.0
                            sisaHarta = harta - hartaAnakPerempuan
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }

                    } else if (anakLaki >= 1) {
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"
                        bagianCucuPerempuan = "Mahjub"
                        bagianCucuLaki = "Mahjub"
                        hartaAnakLaki = harta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (harta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
            }else if (!adaAyah && adaIbu){
                if (anakLaki == 0) {
                    if (anakPerempuan == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIbu = "1/3 → 1/1"
                            hartaIbu = harta
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (cucuPerempuan == 1){
                                bagianIbu = "1/6 → 1/4"
                                hartaIbu = harta * 1.0/4.0
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaCucuPerempuan = harta * 3.0/4.0
                            }else if(cucuPerempuan > 1){
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1.0/5.0
                                bagianCucuPerempuan = "2/3 → 4/5"
                                hartaCucuPerempuan = harta * 4.0/5.0
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1.0/6.0
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5.0/6.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1.0/6.0
                            sisaHarta = harta - hartaIbu
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }

                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/4"
                            bagianAnakPerempuan = "1/2 → 3/4"
                            hartaIbu = harta * (1.0/4.0)
                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = sisaHarta
                            keterangan = "Radd"
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/5"
                            bagianAnakPerempuan = "1/2 → 3/5"
                            bagianCucuPerempuan = "1/6 → 1/5"
                            hartaIbu = harta * (1.0/5.0)
//                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = harta * 3.0/5.0
                            hartaCucuPerempuan = harta * 1.0/5.0
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianIbu = "1/6 → 1/6"
                            bagianAnakPerempuan = "1/2 → 3/6"
                            bagianCucuLaki = "Ashobah"
                            hartaIbu = harta * (1.0/6.0)
//                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = harta * 3.0/6.0
                            hartaCucuLaki = harta * 2.0/6.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianIbu = "1/6 → 1/6"
                            bagianAnakPerempuan = "1/2 → 3/6"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaIbu = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 3.0/6.0
                            sisaHarta = harta - hartaIbu - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/5"
                            bagianAnakPerempuan = "2/3 → 4/5"
                            hartaIbu = harta * (1.0 / 5.0)
                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = sisaHarta
                            keterangan = "Radd"
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/5"
                            bagianAnakPerempuan = "2/3 → 4/5"
                            bagianCucuPerempuan = "Mahjub"
                            hartaIbu = harta * (1.0 / 5.0)
                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = sisaHarta

                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianIbu = "1/6 → 1/6"
                            bagianAnakPerempuan = "1/2 → 4/6"
                            bagianCucuLaki = "Ashobah"
                            hartaIbu = harta * (1.0/6.0)
//                            sisaHarta = harta - hartaIbu
                            hartaAnakPerempuan = harta * 4.0/6.0
                            hartaCucuLaki = harta * 1.0/6.0
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianIbu = "1/6 → 1/6"
                            bagianAnakPerempuan = "1/2 → 4/6"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            hartaIbu = harta * 1.0/6.0
                            hartaAnakPerempuan = harta * 4.0/6.0
                            sisaHarta = harta - hartaIbu - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if (anakLaki >= 1) {
                    bagianIbu = "1/6 → 1/6"
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    hartaIbu = harta * (1.0/6.0)
                    sisaHarta = harta - hartaIbu
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
                            bagianAyah = "Ashobah"
                            hartaAyah = harta
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
                            sisaHarta = harta - hartaAyah
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
                            hartaAyah = harta - hartaAnakPerempuan
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
                            sisaHarta = harta - hartaAyah - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if (anakPerempuan > 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            hartaAnakPerempuan = harta*(4.0/5.0)
                            hartaAyah = harta - hartaAnakPerempuan
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
                            sisaHarta = harta - hartaAyah - hartaAnakPerempuan
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }else if (anakLaki >= 1){
                    bagianAyah = "1/6 → 1/6"
                    bagianCucuPerempuan = "Mahjub"
                    bagianCucuLaki = "Mahjub"
                    hartaAyah = harta * (1.0/6.0)
                    sisaHarta = harta - hartaAyah
                    if (anakPerempuan == 0) {
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = sisaHarta
                    }else if (anakPerempuan >= 1) {
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
                            sisaHarta = harta - hartaIbu
                            hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                            hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianAyah = "1/6+sisa → 1/6"
                            bagianIbu = "1/6 → 1/6"
                            hartaAyah = harta * 1.0/6.0
                            hartaIbu = harta * 1.0/6.0
                            sisaHarta = harta - hartaAyah - hartaIbu
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
                                sisaHarta = harta - (hartaIbu + hartaAnakPerempuan + hartaAyah)
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
                                sisaHarta = harta - hartaAyah - hartaIbu - hartaAnakPerempuan
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
                        sisaHarta = harta - (harta * (1.0/6.0) * 2)
                        hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                        hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                    }
                }
            }
            //Batas Suci
            //Batas Suci
            //Batas Suci
        }else if(adaSuami || istri > 0){
            if (!adaAyah && !adaIbu) {
                if (anakPerempuan == 0) {
                    if (anakLaki == 0) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            bagianIstri = "1/4 → 1/4"
                            bagianSuami = "1/2 → 1/2"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/4.0)
                                sisaHarta = harta - hartaIstri

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/2.0)
                                sisaHarta = harta - hartaSuami
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "1/2 → 7/8"
                                hartaCucuPerempuan = harta * 7.0/8.0
                                sisaHarta = harta - hartaIstri - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaCucuPerempuan = harta * 3.0/4.0
                                sisaHarta = harta - hartaSuami - hartaCucuPerempuan
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                sisaHarta = harta - hartaIstri
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                sisaHarta = harta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                sisaHarta = harta - hartaSuami
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                sisaHarta = harta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                            }
                        }

                    } else if (anakLaki >= 1) {
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianAnakLaki = "Ashobah"
                        bagianCucuPerempuan = "Mahjub"
                        bagianCucuLaki = "Mahjub"
                        hartaSuami = harta*(1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaAnakLaki = harta*(7.0/8.0)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(3.0/4.0)
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
                                hartaAnakPerempuan = harta*(7.0/8.0)
                                bagianAnakPerempuan = if (anakPerempuan > 1) "2/3 → 7/8" else "1/2 → 7/8"
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaAnakPerempuan = harta*(3.0/4.0)
                                bagianAnakPerempuan = if (anakPerempuan > 1) "2/3 → 3/4" else "1/2 → 3/4"
                                keterangan = "Radd"
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
                            hartaSuami = harta*(1.0/4.0)
                            hartaIstri = harta*(1.0/8.0)
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                if(anakPerempuan == 1){
                                    bagianAnakPerempuan = "1/2 → 4/8"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAnakPerempuan = harta * 4.0/8.0
                                    sisaHarta = harta - hartaIstri - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }else if(anakPerempuan > 1){
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAnakPerempuan = harta * 16.0/24.0
                                    sisaHarta = harta - hartaIstri - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                if(anakPerempuan == 1){
                                    bagianAnakPerempuan = "1/2 → 2/4"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAnakPerempuan = harta * 2.0/4.0
                                    sisaHarta = harta - hartaSuami - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                }else if(anakPerempuan > 1){
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianCucuLaki = "Ashobah"
                                    hartaAnakPerempuan = harta * 8.0/12.0
                                    sisaHarta = harta - hartaSuami - hartaAnakPerempuan
                                    hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                    hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
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
                            sisaHarta = harta - hartaIstri
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            hartaAnakLaki = (sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            sisaHarta = harta - hartaSuami
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            hartaAnakLaki = (sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()))
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
                                bagianIbu = "1/3 → 3/4"
                                bagianIstri = "1/4 → 1/4"
                                hartaIbu = harta*(3.0/4.0)
                                hartaIstri = harta*(1.0/4.0)
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianSuami = "1/2 → 1/2"
                                bagianIbu = "1/3 → 1/2"
                                hartaSuami = harta*(1.0/2.0)
                                hartaIbu = harta*(1.0/2.0)
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
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianSuami = "1/4 → 1/4"
                                    bagianIbu = "1/6 → 3/16"
                                    bagianCucuPerempuan = "1/2 → 9/16"
                                    hartaSuami = harta*(1.0/4.0)
                                    hartaIbu = harta*(3.0/16.0)
                                    hartaCucuPerempuan = harta * 9.0/16.0
                                }
                            }else if(cucuPerempuan > 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianIbu = "1/6 → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "2/3 → 7/10"
                                    hartaIbu = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 7.0/10.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianSuami = "1/4 → 3/13"
                                    bagianIbu = "1/6 → 2/13"
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaIbu = harta*(2.0/13.0)
                                    hartaCucuPerempuan = harta * 8.0/13.0
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
                                sisaHarta = harta - hartaIstri - hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 2/12"
                                hartaIbu = harta * 1.0/6.0
                                sisaHarta = harta - hartaSuami - hartaIbu
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                            }
                        }
                        //Batas Suci
                        //Batas Suci
                        //Batas Suci
                    }else if (anakPerempuan == 1) {
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIbu = "1/6 → 7/32"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "1/2 → 21/32"
                                hartaIstri = harta*(1.0/8.0)
                                sisaHarta = harta - hartaIstri
                                hartaIbu = sisaHarta * (1.0/4.0)
                                hartaAnakPerempuan = sisaHarta*(3.0/4.0)
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianIbu = "1/6 → 3/16"
                                bagianSuami = "1/4 → 1/4"
                                bagianAnakPerempuan = "1/2 → 9/16"
                                hartaSuami = harta * (1.0/4.0)
                                sisaHarta = harta - hartaSuami
                                hartaIbu = sisaHarta * (1.0/4.0)
                                hartaAnakPerempuan = sisaHarta*(3.0/4.0)
                                keterangan = "Radd"
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIbu = "1/6 → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "1/2 → 21/40"
                                bagianCucuPerempuan = "1/2 → 7/40"
                                hartaIbu = harta*(7.0/40.0)
                                hartaIstri = harta*(1.0/8.0)
                                hartaAnakPerempuan = harta * 21.0/40.0
                                hartaCucuPerempuan = harta * 7.0/40.0
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
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
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 4/24"
                                bagianAnakPerempuan = "1/2 → 12/24"
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta * 12.0/24.0
                                sisaHarta = harta - hartaIstri - hartaIbu - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 2/12"
                                bagianAnakPerempuan = "1/2 → 6/12"
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta * 6.0/12.0
                                sisaHarta = harta - hartaSuami - hartaIbu - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
                            }
                        }
                        // batas suciii
                        // batas suciii
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIbu = "1/6 → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "2/3 → 7/10"
                                hartaIstri = harta*(1.0/8.0)
                                sisaHarta = harta - hartaIstri
                                hartaIbu = sisaHarta * (1.0/5.0)
                                hartaAnakPerempuan = sisaHarta*(4.0/5.0)
                                keterangan = "Radd"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianIbu = "1/6 → 2/13"
                                bagianSuami = "1/4 → 3/13"
                                bagianAnakPerempuan = "2/3 → 8/13"
                                hartaSuami = harta *(3.0/13.0)
                                hartaIbu = harta * (2.0/13.0)
                                hartaAnakPerempuan = harta*(8.0/13.0)
                                keterangan = "Aul"
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianIbu = "1/6 → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "1/2 → 7/10"
                                bagianCucuPerempuan = "Mahjub"
                                hartaIbu = harta*(7.0/40.0)
                                hartaIstri = harta*(1.0/8.0)
                                hartaAnakPerempuan = harta * 7.0/10.0
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianIbu = "1/6 → 2/13"
                                bagianSuami = "1/4 → 3/13"
                                bagianAnakPerempuan = "1/2 → 8/13"
                                bagianCucuPerempuan = "Mahjub"
                                hartaSuami = harta * (3.0/13.0)
                                hartaIbu = harta * 2.0/13.0
                                hartaAnakPerempuan = harta * 8.0/13.0
                                keterangan = "Radd"
                            }
                        }else if(cucuLaki > 0 || cucuPerempuan >= 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 3/13"

                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 4/24"
                                bagianAnakPerempuan = "2/3 → 16/24"
                                hartaIbu = harta * 1.0/6.0
                                hartaAnakPerempuan = harta * 16.0/24.0
                                sisaHarta = harta - hartaIstri - hartaIbu - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaIstri - hartaCucuLaki - hartaCucuPerempuan

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (3.0/13.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 2/13"
                                bagianAnakPerempuan = "2/3 → 8/13"
                                hartaIbu = harta * 2.0/13.0
                                hartaAnakPerempuan = harta * 8.0/13.0
//                                sisaHarta = harta - hartaSuami - hartaIbu - hartaAnakPerempuan
//                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
//                                sisaHarta = harta - hartaSuami - hartaCucuLaki - hartaCucuPerempuan
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
                            sisaHarta = harta - (hartaIstri + hartaIbu)
                            hartaAnakLaki = sisaHarta
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianIbu = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            bagianAnakLaki = "Ashobah"
                            sisaHarta = harta - (hartaSuami + hartaIbu)
                            hartaAnakLaki = sisaHarta
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
                            sisaHarta = harta - (hartaIstri + hartaIbu)
                            hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianIbu = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = harta - (hartaSuami + hartaIbu)
                            hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            hartaAnakPerempuan = sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble())
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
                                hartaAyah = harta*(3.0/4.0)
                            } else if (jenisKelaminPewaris.equals("Perempuan")) {
                                hartaAyah = harta*(1.0/2.0)
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 7/32"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "1/2 → 21/32"
                                    hartaAyah = harta*(7.0/32.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 21.0/32.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianSuami = "1/4 → 1/4"
                                    bagianAyah = "1/6+sisa → 3/16"
                                    bagianCucuPerempuan = "1/2 → 9/16"
                                    hartaSuami = harta*(1.0/4.0)
                                    hartaAyah = harta*(3.0/16.0)
                                    hartaCucuPerempuan = harta * 9.0/16.0
                                }
                            }else if(cucuPerempuan > 1){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    bagianAyah = "1/6+sisa → 7/40"
                                    bagianIstri = "1/8 → 1/8"
                                    bagianCucuPerempuan = "2/3 → 7/10"
                                    hartaAyah = harta*(7.0/40.0)
                                    hartaIstri = harta*(1.0/8.0)
                                    hartaCucuPerempuan = harta * 7.0/10.0
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    bagianSuami = "1/4 → 3/13"
                                    bagianAyah = "1/6+sisa → 2/13"
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaSuami = harta*(3.0/13.0)
                                    hartaAyah = harta*(2.0/13.0)
                                    hartaCucuPerempuan = harta * 8.0/13.0
                                }
                            }
                        }else if(cucuLaki > 0 && cucuPerempuan == 0) {
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                sisaHarta = harta - hartaIstri
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                sisaHarta = harta - hartaSuami
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
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = harta - hartaIstri - hartaAyah
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6+sisa → 2/12"
                                hartaAyah = harta * (1.0/6.0)
                                sisaHarta = harta - hartaSuami - hartaAyah
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
                                bagianAyah = "1/6+Ashobah → 7/32"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "1/2 → 21/32"
                                hartaAyah = harta*(7.0/32.0)
                                hartaIstri = harta*(1.0/8.0)
                                hartaAnakPerempuan = harta*(21.0/32.0)

                            } else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianAyah = "1/6+Ashobah → 3/16"
                                bagianSuami = "1/4 → 1/4"
                                bagianAnakPerempuan = "1/2 → 9/16"
                                hartaAyah = harta*(3.0/16.0)
                                hartaSuami = harta * (1.0/4.0)
                                hartaAnakPerempuan = harta*(9.0/16.0)

                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianAyah = "1/6+sisa → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianCucuPerempuan = "1/2 → 7/40"
                                bagianAnakPerempuan = "1/2 → 21/40"
                                hartaAyah = harta*(7.0/40.0)
                                hartaIstri = harta*(1.0/8.0)
                                hartaAnakPerempuan = harta * 21.0/40.0
                                hartaCucuPerempuan = harta * 7.0/40.0
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianAyah = "1/6+sisa → 2/13"
                                bagianSuami = "1/4 → 3/13"
                                bagianCucuPerempuan = "1/6 → 2/13"
                                bagianAnakPerempuan = "1/2 → 6/13"
                                hartaAyah = harta*(2.0/13.0)
                                hartaSuami = harta*(3.0/13.0)
                                hartaAnakPerempuan = harta * 6.0/13.0
                                hartaCucuPerempuan = harta * 2.0/13.0
                            }

                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            bagianIstri = "1/8 → 1/8"
                            bagianSuami = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyah = "1/6+sisa → 4/24"
                                bagianAnakPerempuan = "1/2 → 12/24"
                                hartaAyah = harta * (1.0/6.0)
                                hartaAnakPerempuan = harta * 12.0/24.0
                                sisaHarta = harta - hartaIstri - hartaAyah - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6+sisa → 2/12"
                                bagianAnakPerempuan = "1/2 → 6/12"
                                hartaAyah = harta * (1.0/6.0)
                                hartaAnakPerempuan = harta * 6.0/12.0
                                sisaHarta = harta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                            }
                        }
                    }else if (anakPerempuan > 1){
                        if(cucuPerempuan == 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianAyah = "1/6+Ashobah → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianAnakPerempuan = "2/3 → 7/10"
                                hartaIstri = harta*(1.0/8.0)
                                hartaAyah = harta*(7.0/40.0)
                                hartaAnakPerempuan = harta*(7.0/10.0)
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianAyah = "1/6+Ashobah → 2/13"
                                bagianSuami = "1/4 → 3/13"
                                bagianAnakPerempuan = "2/3 → 8/13"
                                hartaAyah = harta*(2.0/13.0)
                                hartaSuami = harta *(3.0/13.0)
                                hartaAnakPerempuan = harta*(8.0/13.0)
                                keterangan = "Aul"
                            }
                        }else if(cucuPerempuan > 0 && cucuLaki == 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                bagianAyah = "1/6+sisa → 7/40"
                                bagianIstri = "1/8 → 1/8"
                                bagianCucuPerempuan = "Mahjub"
                                bagianAnakPerempuan = "2/3 → 7/10"
                                hartaAyah = harta*(7.0/40.0)
                                hartaIstri = harta*(1.0/8.0)
                                hartaAnakPerempuan = harta * 7.0/10.0
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                bagianAyah = "1/6+sisa → 2/13"
                                bagianSuami = "1/4 → 3/13"
                                bagianCucuPerempuan = "Mahjub"
                                bagianAnakPerempuan = "2/3 → 8/13"
                                hartaAyah = harta*(2.0/13.0)
                                hartaSuami = harta*(3.0/13.0)
                                hartaAnakPerempuan = harta * 8.0/13.0
                            }
// Batas suci part 3
                        }else if(cucuLaki > 0 || cucuPerempuan > 0){
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * (1.0/8.0)
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyah = "1/6+sisa → 4/24"
                                bagianAnakPerempuan = "2/3 → 16/24"
                                bagianIstri = "1/8 → 1/8"
                                hartaAyah = harta * (1.0/6.0)
                                hartaAnakPerempuan = harta * 16.0/24.0
                                sisaHarta = harta - hartaIstri - hartaAyah - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (3.0/13.0)
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6+sisa → 2/13"
                                bagianAnakPerempuan = "2/3 → 8/13"
                                bagianSuami = "1/4 → 3/13"
                                hartaAyah = harta * (2.0/13.0)
                                hartaAnakPerempuan = harta * 8.0/13.0
                                sisaHarta = harta - hartaSuami - hartaAyah - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * ((cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
                                hartaCucuPerempuan = sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble())
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
                            bagianAyah = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            sisaHarta = harta - (hartaIstri + hartaAyah)
                            hartaAnakLaki = sisaHarta
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianAyah = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = harta - (hartaSuami + hartaAyah)
                            hartaAnakLaki = sisaHarta
                        }
                    }else if (anakPerempuan >= 1) {
                        hartaAyah = harta * (1.0/6.0)
                        hartaSuami = harta * (1.0/4.0)
                        hartaIstri = harta*(1.0/8.0)




                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah-Bil-Ghoir"


                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianAyah = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            sisaHarta = harta - (hartaIstri + hartaAyah)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            bagianAyah = "1/6 → 2/12"
                            bagianSuami = "1/4 → 3/12"
                            sisaHarta = harta - (hartaSuami + hartaAyah)
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
                                sisaHarta = harta - (hartaAyah + hartaIbu + hartaIstri)
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
                                sisaHarta = harta - hartaIstri -hartaIbu
                                hartaAyah = sisaHarta * (1) / (1 + cucuLaki).toDouble()
                                hartaCucuLaki = sisaHarta * (cucuLaki) / (cucuLaki + 1).toDouble()

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta * (1.0/4.0)
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "Ashobah"
                                bagianSuami= "1/4 → 3/12"
                                bagianIbu = "1/6 → 2/12"
                                sisaHarta = harta - hartaSuami - hartaIbu
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
                                sisaHarta = harta - hartaIstri - hartaAyah - hartaIbu
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
                                sisaHarta = harta - hartaSuami - hartaAyah - hartaIbu
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
//                                    sisaHarta = harta - (hartaAyah + hartaIbu + hartaIstri + hartaAnakPerempuan)
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
                                    sisaHarta = harta - hartaIstri - hartaAyah - hartaIbu - hartaAnakPerempuan
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

                                    sisaHarta = harta - (hartaAyah + hartaIbu + hartaIstri + hartaAnakPerempuan)
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
                            sisaHarta = harta - (hartaIbu + hartaAyah + hartaIstri)
                            hartaAnakLaki = sisaHarta
                            bagianAyah = "1/6 → 4/24"
                            bagianIbu = "1/6 → 4/24"
                            bagianIstri = "1/8 → 3/24"
                            bagianAnakLaki = "Ashobah"

                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaIbu = harta*(1.0/6.0)
                            hartaAyah = harta * (1.0 / 6.0)
                            hartaSuami = harta *(1.0/4.0)
                            sisaHarta = harta - (hartaIbu + hartaAyah + hartaSuami)
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
                                sisaHarta = harta - (hartaIbu + hartaAyah + hartaIstri)
                                bagianIstri ="1/8 → 3/24"

                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta *(1.0/4.0)
                                sisaHarta = harta - (hartaIbu + hartaAyah + hartaSuami)
                                bagianSuami = "1/4 → 3/12"

                            }
                            hartaAnakLaki = sisaHarta * ((anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble())
                            hartaAnakPerempuan = sisaHarta * anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        }
                    }
                }
            }
        }
        val data: ArrayList<WarisData> = ArrayList()

        if (adaIbu || adaAyah || adaSuami || istri >= 1 || anakPerempuan >= 1 || anakLaki >= 1 || cucuLaki >= 1 || cucuPerempuan >= 1){
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