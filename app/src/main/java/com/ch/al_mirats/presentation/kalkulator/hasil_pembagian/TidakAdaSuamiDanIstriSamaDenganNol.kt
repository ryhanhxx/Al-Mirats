package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

data class TidakAdaSuamiDanIstriSamaDenganNol(
    var bagianIbu : String,
    var bagianAyah : String,
    var bagianSuami : String,
    var bagianAyahnyaAyah : String,
    var bagianIbunyaAyah : String,
    var bagianSaudaraSeayahSeibu : String,
    var bagianSaudariSeayahSeibu : String,
    var bagianIbunyaIbu : String,
    var bagianIstri : String,
    var bagianAnakPerempuan : String,
    var bagianAnakLaki : String,
    var bagianCucuLaki : String,
    var bagianCucuPerempuan : String,

    var hartaAyah : Double,
    var hartaIbu : Double,
    var hartaSuami : Double,
    var hartaAyahnyaAyah : Double,
    var hartaIbunyaAyah : Double,
    var hartaSaudaraSeayahSeibu : Double,
    var hartaSaudariSeayahSeibu : Double,
    var hartaIbunyaIbu : Double,
    var hartaIstri : Double,
    var hartaAnakLaki : Double,
    var hartaAnakPerempuan : Double,
    var hartaCucuLaki : Double,
    var hartaCucuPerempuan : Double,

    var sisaHarta : Double
)

fun TidakAdaSuamiDanIstriSamaDenganNolLogic(
    hutang : Double,
    wasiat : Double,
    biayaPerawatanJenazah : Double,
    totalHarta : Double,
    harta : Double,

    jenisKelaminPewaris : String?,
    adaAyah : Boolean,
    adaIbu : Boolean,
    adaSuami : Boolean,
    adaAyahnyaAyah : Boolean,
    adaIbunyaAyah : Boolean,
    adaSaudaraSeayahSeibu : Int,
    adaSaudariSeayahSeibu : Int,
    adaIbunyaIbu : Boolean,
    istri : Int,
    anakLaki : Int,
    anakPerempuan : Int,
    cucuLaki : Int,
    cucuPerempuan : Int
): TidakAdaSuamiDanIstriSamaDenganNol{
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

    if (!adaAyah && !adaIbu) {
        if (anakPerempuan == 0) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                hartaAnakLaki = harta
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                hartaAnakLaki = harta
                            }else{
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                hartaAnakLaki = harta * 5/6
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 4/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                    }else{
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 5/6
                    }
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 4/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 5/6
                    }
                }else{
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 3/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 4/6
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbunyaIbu = "1/6 → 1/1"
                            hartaIbunyaIbu = harta
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuPerempuan = "1/2 → 1/1"
                                hartaCucuPerempuan = harta
                            }else{
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaCucuPerempuan = harta
                                bagianIbunyaIbu = "1/6 → 1/4"
                                hartaIbunyaIbu = harta * 1/4
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuPerempuan = "2/3 → 1/1"
                                hartaCucuPerempuan = harta
                            }else{
                                bagianCucuPerempuan = "2/3 → 4/5"
                                hartaCucuPerempuan = harta
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta
                            }else{
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "1/2 → 1/1"
                                hartaSaudariSeayahSeibu = harta
                            }else{
                                bagianSaudariSeayahSeibu = "1/2 → 3/4"
                                hartaSaudariSeayahSeibu = harta * 3/4
                                bagianIbunyaIbu = "1/6 → 1/4"
                                hartaIbunyaIbu = harta * 1/4
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/2
                                bagianCucuPerempuan = "1/2 → 1/2"
                                hartaCucuPerempuan = harta * 1/2
                            }else{
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                                bagianCucuPerempuan = "1/2 → 3/6"
                                hartaCucuPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/3
                                bagianCucuPerempuan = "2/3 → 2/3"
                                hartaCucuPerempuan = harta * 2/3
                            }else{
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta
                            }else{
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu > 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "2/3 → 1/1"
                                hartaSaudariSeayahSeibu = harta
                            }else{
                                bagianSaudariSeayahSeibu = "2/3 → 4/5"
                                hartaSaudariSeayahSeibu = harta * 4/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/2
                                bagianCucuPerempuan = "1/2 → 1/2"
                                hartaCucuPerempuan = harta * 1/2
                            }else{
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                                bagianCucuPerempuan = "1/2 → 3/6"
                                hartaCucuPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/3
                                bagianCucuPerempuan = "2/3 → 2/3"
                                hartaCucuPerempuan = harta * 2/3
                            }else{
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta
                            }else{
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta
                            }else{
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/2
                                bagianCucuPerempuan = "1/2 → 1/2"
                                hartaCucuPerempuan = harta * 1/2
                            }else{
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                                bagianCucuPerempuan = "1/2 → 3/6"
                                hartaCucuPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/3
                                bagianCucuPerempuan = "2/3 → 2/3"
                                hartaCucuPerempuan = harta * 2/3
                            }else{
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuPerempuan = "1/2 → 1/2"
                                hartaCucuPerempuan = harta * 1/2
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianCucuPerempuan = "1/2 → 3/6"
                                hartaCucuPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaCucuPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuPerempuan = "2/3 → 2/3"
                                hartaCucuPerempuan = harta * 2/3
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaCucuPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                hartaCucuLaki = harta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (harta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianIbunyaAyah = "1/6 → 1/1"
                    hartaIbunyaAyah = harta
                    if(adaSaudariSeayahSeibu > 0 && adaSaudaraSeayahSeibu == 0){
                        if(adaSaudariSeayahSeibu == 1){
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "1/2 → 3/4"
                                    hartaSaudariSeayahSeibu = harta * 3/4
                                    bagianIbunyaAyah = "1/6 → 1/4"
                                    hartaIbunyaAyah = harta * 1/4
                                }else{
                                    bagianSaudariSeayahSeibu = "1/2 → 3/5"
                                    hartaSaudariSeayahSeibu = harta * 3/5
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaIbu = harta * 1/5
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                }else{
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 4/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }else{
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 2/6
                                    }else{
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        bagianCucuPerempuan = "Ashobah"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }
                                }else{
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }else{
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                    }
                                }
                            }
                        }else{
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "2/3 → 4/5"
                                    hartaSaudariSeayahSeibu = harta * 4/5
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                }else{
                                    bagianSaudariSeayahSeibu = "2/3 → 4/6"
                                    hartaSaudariSeayahSeibu = harta * 4/6
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                }else{
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 4/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }else{
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 2/6
                                    }else{
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }
                                }else{
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }else{
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                    }
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 5/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 4/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                            // 22:29 31/05/2024
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    hartaSaudaraSeayahSeibu = harta * 2/6
                                }else{
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    hartaSaudaraSeayahSeibu = harta * 1/6
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    hartaSaudaraSeayahSeibu = harta * 1/6
                                }else{
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianIbunyaAyah = "1/6 → 1/1"
                                hartaIbunyaAyah = harta
                            }else{
                                bagianIbunyaAyah = "1/6 → 1/2"
                                hartaIbunyaAyah = harta * 1/2
                                bagianIbunyaIbu = "1/6 → 1/2"
                                hartaIbunyaIbu = harta * 1/2
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianIbunyaAyah = "1/6 → 1/4"
                                    hartaIbunyaAyah = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    hartaIbunyaIbu = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/5"
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 4/5
                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }
                    }else{
                        // 22:41 31/05/2024
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                            // 22:29 31/05/2024
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    sisaHarta = harta - hartaIbunyaAyah - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else{
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    sisaHarta = harta - hartaIbunyaAyah - hartaCucuPerempuan - hartaIbunyaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    sisaHarta = harta - hartaIbunyaAyah - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else{
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }

                    }
                    //batas terakhiiiirrr
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    bagianAyahnyaAyah = "Ashobah"
                    hartaAyahnyaAyah = harta
                    if(adaSaudariSeayahSeibu > 0 && adaSaudaraSeayahSeibu == 0){
                        if(adaSaudariSeayahSeibu == 1){
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    hartaAyahnyaAyah = harta
                                }else{
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    hartaAyahnyaAyah = harta * 5/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                }else{
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 4/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }else{
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/4"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/4"
                                        hartaAyahnyaAyah = harta * 1/4
                                        hartaCucuPerempuan = harta * 3/4

                                    }else{
                                        bagianCucuPerempuan = "1/2 → 3/5"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                        bagianIbunyaIbu = "1/6 → 1/5"
                                        hartaAyahnyaAyah = harta * 1/5
                                        hartaIbunyaIbu = harta * 1/5
                                        hartaCucuPerempuan = harta * 3/5
                                    }
                                }else{
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/5"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                        hartaAyahnyaAyah = harta * 1/5
                                        hartaCucuPerempuan = harta * 4/5

                                    }else{
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaAyahnyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                    }
                                }
                            }
                        }else{
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    hartaAyahnyaAyah = harta
                                }else{
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    hartaAyahnyaAyah = harta * 5/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                }else{
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 4/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }else{
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/4"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/4"
                                        hartaAyahnyaAyah = harta * 1/4
                                        hartaCucuPerempuan = harta * 3/4

                                    }else{
                                        bagianCucuPerempuan = "1/2 → 3/5"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                        bagianIbunyaIbu = "1/6 → 1/5"
                                        hartaAyahnyaAyah = harta * 1/5
                                        hartaIbunyaIbu = harta * 1/5
                                        hartaCucuPerempuan = harta * 3/5
                                    }
                                }else{
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/5"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                        hartaAyahnyaAyah = harta * 1/5
                                        hartaCucuPerempuan = harta * 4/5

                                    }else{
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaAyahnyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                    }
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAyahnyaAyah = "1/6 → 1/1"
                                hartaAyahnyaAyah = harta
                            }else{
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianAyahnyaAyah = "1/6 → 1/4"
                                    hartaAyahnyaAyah = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaIbunyaIbu = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/5"
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 4/5
                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                            // 22:29 31/05/2024
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/4"
                                    hartaAyahnyaAyah = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaIbunyaIbu = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 4/5
                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }
                    }else{
                        // 22:41 31/05/2024
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 5/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                            // 22:29 31/05/2024
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/4"
                                    bagianSaudaraSeayahSeibu = "Mahjub"
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    hartaAyahnyaAyah = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }else{
                                    bagianSaudaraSeayahSeibu = "Mahjub"
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    bagianIbunyaIbu = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaIbunyaIbu = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/4"
                                    bagianSaudaraSeayahSeibu = "Mahjub"
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    hartaAyahnyaAyah = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }else{
                                    bagianSaudaraSeayahSeibu = "Mahjub"
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }
                        }

                    }
                }else{
                    bagianAyahnyaAyah = "Ashobah"
                    bagianIbunyaAyah = "1/6 → 1/6"
                    hartaAyahnyaAyah = harta * 5/6
                    hartaIbunyaAyah = harta * 1/6
                    if(adaSaudariSeayahSeibu > 0 && adaSaudaraSeayahSeibu == 0){
                        if(adaSaudariSeayahSeibu >= 1){
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 5/6
                                    hartaIbunyaAyah = harta * 1/6
                                }else{
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianAyahnyaAyah = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 4/6
                                    hartaIbunyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 4/6
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaAyah = harta * 1/6
                                }else{
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 3/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }else{
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/5"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                        bagianIbunyaAyah = "1/6 → 1/5"
                                        hartaIbunyaAyah = harta * 1/5
                                        hartaAyahnyaAyah = harta * 1/5
                                        hartaCucuPerempuan = harta * 3/5

                                    }else{
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        bagianIbunyaIbu = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaAyahnyaAyah = harta * 1/6
                                        hartaIbunyaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                    }
                                }else{
                                    if(!adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                        bagianIbunyaAyah = "1/6 → 1/6"
                                        hartaIbunyaAyah = harta * 1/6
                                        hartaAyahnyaAyah = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6

                                    }else{
                                        bagianCucuPerempuan = "2/3 → 4/7"
                                        bagianAyahnyaAyah = "1/6+sisa → 1/7"
                                        bagianIbunyaAyah = "1/6 → 1/7"
                                        bagianIbunyaIbu = "1/6 → 1/7"
                                        hartaAyahnyaAyah = harta * 1/7
                                        hartaIbunyaIbu = harta * 1/7
                                        hartaIbunyaAyah = harta * 1/7
                                        hartaCucuPerempuan = harta * 4/7
                                    }
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 5/6
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 4/6
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 3/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5

                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6

                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/7"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/7"
                                    bagianIbunyaAyah = "1/6 → 1/7"
                                    bagianIbunyaIbu = "1/6 → 1/7"
                                    hartaAyahnyaAyah = harta * 1/7
                                    hartaIbunyaIbu = harta * 1/7
                                    hartaIbunyaAyah = harta * 1/7
                                    hartaCucuPerempuan = harta * 4/7
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 5/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 3/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaIbu = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/7"
                                    bagianAyahnyaAyah = "1/6 → 1/7"
                                    bagianIbunyaIbu = "1/6 → 1/7"
                                    bagianIbunyaAyah = "1/6 → 1/7"
                                    hartaIbunyaAyah = harta * 1/7
                                    hartaAyahnyaAyah = harta * 1/7
                                    hartaIbunyaIbu = harta * 1/7
                                    hartaCucuPerempuan = harta * 4/7
                                }
                            }
                        }
                    }else{
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 5/6
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 4/6
                                hartaIbunyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 3/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }else{
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                hartaIbunyaAyah = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    bagianIbunyaAyah = "1/6 → 1/5"
                                    hartaIbunyaAyah = harta * 1/5
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5

                                }else{
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    bagianIbunyaIbu = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaIbunyaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    bagianIbunyaAyah = "1/6 → 1/6"
                                    hartaIbunyaAyah = harta * 1/6
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6

                                }else{
                                    bagianCucuPerempuan = "2/3 → 4/7"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/7"
                                    bagianIbunyaAyah = "1/6 → 1/7"
                                    bagianIbunyaIbu = "1/6 → 1/7"
                                    hartaAyahnyaAyah = harta * 1/7
                                    hartaIbunyaIbu = harta * 1/7
                                    hartaIbunyaAyah = harta * 1/7
                                    hartaCucuPerempuan = harta * 4/7
                                }
                            }
                        }

                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        } else if (anakPerempuan == 1) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                bagianAnakPerempuan = "Ashobah"
                hartaAnakLaki = harta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                hartaAnakPerempuan = (harta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else{
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaAyahnyaAyah - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/1"
                                hartaAnakPerempuan = harta
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianIbunyaIbu = "1/6 → 1/4"
                                hartaIbunyaIbu = harta * 1/4
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianCucuPerempuan = "1/6 → 1/4"
                                hartaCucuPerempuan = harta * 1/4
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/2
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/2
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/2
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/2
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/2
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/2
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 1/2"
                                hartaAnakPerempuan = harta * 1/2
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianIbunyaAyah = "1/6 → 1/4"
                                hartaIbunyaAyah = harta * 1/4
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbunyaAyah
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                    //batas terakhiiiirrr
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianAyahnyaAyah = "1/6 → 1/4"
                                hartaAyahnyaAyah = harta * 1/4
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianAyahnyaAyah = "1/6 → 1/4"
                                hartaAyahnyaAyah = harta * 1/4
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianAyahnyaAyah = "1/6 → 1/4"
                                hartaAyahnyaAyah = harta * 1/4
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianAyahnyaAyah = "1/6 → 1/4"
                                hartaAyahnyaAyah = harta * 1/4
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else{
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/7"
                                hartaAnakPerempuan = harta * 3/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuPerempuan = "1/6 → 1/7"
                                hartaCucuPerempuan = harta * 1/7
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 || adaSaudaraSeayahSeibu >=1 ){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/7"
                                hartaAnakPerempuan = harta * 3/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuPerempuan = "1/6 → 1/7"
                                hartaCucuPerempuan = harta * 1/7
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        } else if(anakPerempuan > 1){
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                bagianAnakPerempuan = "Ashobah"
                hartaAnakLaki = harta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                hartaAnakPerempuan = (harta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu){
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else{
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu){
                        bagianIbunyaIbu = "1/6 → 1/6"
                        hartaIbunyaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbunyaIbu - hartaAyahnyaAyah - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }else{
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbunyaAyah = "1/6 → 1/6"
                        hartaIbunyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaAyahnyaAyah - hartaIbunyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 1/1"
                                hartaAnakPerempuan = harta
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 1/1"
                                hartaAnakPerempuan = harta
                                bagianCucuPerempuan = "Mahjub"

                            }else{
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianCucuPerempuan = "Mahjub"

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/3
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/3
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/3
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/3
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/3
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/3
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/3
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbunyaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 3/3
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/3
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 2/3"
                                hartaAnakPerempuan = harta * 2/3
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/5"
                                hartaIbunyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbunyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }
                    }
                    //batas terakhiiiirrr
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }
                    }
                }else{
                    //ada ibunya ayah dan ayahnya ayah
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 || adaSaudaraSeayahSeibu >=1 ){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else if(cucuPerempuan >= 1 || cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbunyaAyah = "1/6 → 1/6"
                                hartaIbunyaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/7"
                                hartaAnakPerempuan = harta * 4/7
                                bagianIbunyaIbu = "1/6 → 1/7"
                                hartaIbunyaIbu = harta * 1/7
                                bagianCucuPerempuan = "Ashobah"
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/7"
                                hartaAyahnyaAyah = harta * 1/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }
                    }
                }
            }
        }
        //batas terakhir 2:12 02/06/2024
    }else if (!adaAyah && adaIbu){
        if (anakPerempuan == 0) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                hartaAnakLaki = harta
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah)){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbunyaIbu = "Mahjub"
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianIbunyaAyah = "Mahjub"
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbunyaIbu = "Mahjub"
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianIbunyaAyah = "Mahjub"
                            }
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbunyaIbu = "Mahjub"
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianIbunyaAyah = "Mahjub"
                            }
                        }else{
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbunyaIbu = "Mahjub"
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianIbunyaAyah = "Mahjub"
                            }
                        }
                    }
                }else if(!adaIbunyaAyah && adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianIbunyaIbu = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 4/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                    }
                }else{
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianIbunyaIbu = "Mahjub"
                    bagianIbunyaAyah = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianAnakLaki = "Ashobah"
                        hartaAnakLaki = harta * 4/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    bagianIbunyaIbu = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbu = "1/3 → 1/1"
                            hartaIbu = harta
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/4"
                            hartaIbu = harta * 1/4
                            bagianCucuPerempuan = "1/2 → 3/4"
                            hartaCucuPerempuan = harta * 3/4
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/5"
                            hartaIbu = harta * 1/5
                            bagianCucuPerempuan = "2/3 → 4/5"
                            hartaCucuPerempuan = harta * 4/5
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/6
                        }else{
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if(adaSaudariSeayahSeibu == 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbu = "1/3 → 2/5"
                            hartaIbu = harta * 2/5
                            bagianSaudariSeayahSeibu = "1/2 → 3/5"
                            hartaSaudariSeayahSeibu = harta * 3/5
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "1/2 → 3/6"
                            hartaCucuPerempuan = harta * 3/6
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 2/6
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "2/3 → 4/6"
                            hartaCucuPerempuan = harta * 4/6
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/6
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/6
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else{
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if (adaSaudariSeayahSeibu > 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbu = "1/6 → 1/5"
                            hartaIbu = harta * 1/5
                            bagianSaudariSeayahSeibu = "2/3 → 4/5"
                            hartaSaudariSeayahSeibu = harta * 4/5
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "1/2 → 3/6"
                            hartaCucuPerempuan = harta * 3/6
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 2/6
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "2/3 → 4/6"
                            hartaCucuPerempuan = harta * 4/6
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/6
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/6
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else{
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbu = "1/3 → 1/3"
                            hartaIbu = harta * 1/3
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            hartaSaudaraSeayahSeibu = harta * 2/3
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "1/2 → 3/6"
                            hartaCucuPerempuan = harta * 3/6
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            hartaSaudaraSeayahSeibu = harta * 2/6
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "2/3 → 4/6"
                            hartaCucuPerempuan = harta * 4/6
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            hartaSaudaraSeayahSeibu = harta * 1/6
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/6
                            bagianSaudaraSeayahSeibu = "Mahjub"
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "1/2 → 3/6"
                            hartaCucuPerempuan = harta * 3/6
                            sisaHarta = harta - hartaIbu - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuPerempuan = "2/3 → 4/6"
                            hartaCucuPerempuan = harta * 4/6
                            sisaHarta = harta - hartaIbu - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/6
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianIbu = "1/6 → 1/6"
                            hartaIbu = harta * 1/6
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianIbunyaAyah = "Mahjub"
                    bagianIbunyaIbu = "Mahjub"
                    if(adaSaudariSeayahSeibu > 0 && adaSaudaraSeayahSeibu == 0){
                        if(adaSaudariSeayahSeibu == 1){
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "1/2 → 3/5"
                                    hartaSaudariSeayahSeibu = harta * 3/5
                                    bagianIbu = "1/3 → 2/5"
                                    hartaIbu = harta * 2/5
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "mahjub"
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    sisaHarta = harta - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu || adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianIbu = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 2/6
                                    }
                                }else{
                                    if(!adaIbunyaIbu || adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbu = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }
                                }
                            }
                        }else{
                            if(cucuLaki == 0 && cucuPerempuan == 0){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianSaudariSeayahSeibu = "2/3 → 4/5"
                                    hartaSaudariSeayahSeibu = harta * 4/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                if(!adaIbunyaIbu){
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    sisaHarta = harta - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                                }

                            }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                                if(cucuPerempuan == 1){
                                    if(!adaIbunyaIbu || adaIbunyaIbu){
                                        bagianCucuPerempuan = "1/2 → 3/6"
                                        bagianIbu = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 3/6
                                        hartaSaudariSeayahSeibu = harta * 2/6
                                    }
                                }else{
                                    if(!adaIbunyaIbu || adaIbunyaIbu){
                                        bagianCucuPerempuan = "2/3 → 4/6"
                                        bagianIbu = "1/6 → 1/6"
                                        bagianSaudariSeayahSeibu = "Ashobah"
                                        hartaIbu = harta * 1/6
                                        hartaCucuPerempuan = harta * 4/6
                                        hartaSaudariSeayahSeibu = harta * 1/6
                                    }
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                            // 22:29 31/05/2024
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))

                            }

                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbu = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    hartaSaudaraSeayahSeibu = harta * 2/6
                                }
                            }else{
                                if(!adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbu = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    hartaSaudaraSeayahSeibu = harta * 1/6
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianIbu = "1/3 → 1/1"
                                hartaIbu = harta
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/4"
                                    bagianIbu = "1/6 → 1/4"
                                    hartaIbu = harta * 1/4
                                    hartaCucuPerempuan = harta * 3/4
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/5"
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                    hartaCucuPerempuan = harta * 4/5
                                }
                            }
                        }
                    }else{
                        // 22:41 31/05/2024
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/6"
                                    bagianIbu = "1/6 → 1/6"
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 3/6
                                    sisaHarta = harta - hartaIbu - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    sisaHarta = harta - hartaIbu - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }
                        }
                    }
                    //batas terakhiiiirrr
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaIbu = "Mahjub"
                    bagianIbunyaAyah = "Mahjub"
                    if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6 → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6 → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyahnyaAyah = "Ashobah"
                                hartaAyahnyaAyah = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                hartaAyahnyaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(cucuPerempuan == 1){
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/5"
                                    hartaAyahnyaAyah = harta * 1/5
                                    hartaCucuPerempuan = harta * 3/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                }
                            }else{
                                if(!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    bagianAyahnyaAyah = "1/6+sisa → 1/6"
                                    hartaAyahnyaAyah = harta * 1/6
                                    hartaCucuPerempuan = harta * 4/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        } else if (anakPerempuan == 1) {
            bagianIbunyaIbu = "Mahjub"
            if (anakLaki >= 1) {
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                        bagianIbunyaAyah = "Mahjub"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbu
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianIbunyaAyah = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbu - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianIbu = "1/6 → 1/4"
                                hartaIbu = harta * 1/4
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianIbu = "1/6 → 1/4"
                                hartaIbu = harta * 1/4
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 2/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                    //batas terakhiiiirrr
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyahnyaAyah = "1/6 → 1/5"
                                hartaAyahnyaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyahnyaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        } else if(anakPerempuan > 1) {
            bagianIbunyaIbu = "Mahjub"
            if (anakLaki >= 1) {
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                        bagianIbunyaAyah = "Mahjub"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbu
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianCucuLaki = "Mahjub"
                    bagianCucuPerempuan = "Mahjub"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianIbunyaAyah = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianIbu = "1/6 → 1/6"
                        hartaIbu = harta * 1/6
                        bagianAyahnyaAyah = "1/6 → 1/6"
                        hartaAyahnyaAyah = harta * 1/6
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        sisaHarta = harta - hartaIbu - hartaAyahnyaAyah
                        hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                        hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if(!adaIbunyaAyah && !adaAyahnyaAyah){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                hartaSaudariSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaCucuPerempuan - hartaIbu
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                sisaHarta = harta - hartaAnakPerempuan - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                    //batas terakhiiiirrr
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }
                    }else if((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1 || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1))){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianAyahnyaAyah = "1/6 → 1/6"
                                hartaAyahnyaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }
                    }
                }
            }
        }
        // Batas Suci terakhirrrr
    }else if (adaAyah && !adaIbu) {
        bagianIbunyaAyah =  "Mahjub"
        bagianAyahnyaAyah = "Mahjub"
        bagianSaudaraSeayahSeibu = "Mahjub"
        bagianSaudariSeayahSeibu = "Mahjub"
        if (anakPerempuan == 0) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                hartaAnakLaki = harta
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 5/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                            }
                        }
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/1"
                                hartaAyah = harta
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/2"
                                hartaIbunyaIbu = harta * 1/2
                                bagianAyah = "1/6 → 1/2"
                                hartaAyah = harta * 1/2
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/4"
                                hartaAyah = harta * 1/4
                                bagianCucuPerempuan = "1/2 → 3/4"
                                hartaCucuPerempuan = harta * 3/4
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianCucuPerempuan = "1/2 → 3/5"
                                hartaCucuPerempuan = harta * 3/5
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianCucuPerempuan = "1/2 → 4/5"
                                hartaCucuPerempuan = harta * 4/5
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuPerempuan = "1/2 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/6
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 4/6
                            }
                        }else{
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else {
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        } else if (anakPerempuan == 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }else{
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                hartaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyah - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/4"
                                hartaAnakPerempuan = harta * 3/4
                                bagianAyah = "1/6 → 1/4"
                                hartaAyah = harta * 1/4
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianIbunyaIbu = "1/6 → 1/5"
                                hartaIbunyaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianCucuPerempuan = "1/6 → 1/5"
                                hartaCucuPerempuan = harta * 1/5
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 2/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyah - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        } else if(anakPerempuan > 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            if (!adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }else{
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                hartaAyah = harta * 1/6
                                sisaHarta = harta - hartaAyah - hartaIbunyaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/5"
                                hartaAnakPerempuan = harta * 4/5
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyah
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else{
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbunyaIbu = "1/6 → 1/6"
                                hartaIbunyaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                            }
                        }
                    }
                }
            }
        }
    }else if (adaAyah && adaIbu){
        bagianIbunyaAyah =  "Mahjub"
        bagianAyahnyaAyah = "Mahjub"
        bagianSaudaraSeayahSeibu = "Mahjub"
        bagianSaudariSeayahSeibu = "Mahjub"
        bagianIbunyaIbu = "Mahjub"
        if (anakPerempuan == 0) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                hartaAnakLaki = harta
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                hartaAnakLaki = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0)){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "Ashobah"
                                hartaAyah = harta * 2/3
                                bagianIbu = "1/3 → 1/3"
                                hartaIbu = harta * 1/3
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                                bagianCucuPerempuan = "1/2 → 3/5"
                                hartaCucuPerempuan = harta * 3/5
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "Ashobah"
                                hartaAyah = harta * 5/12
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 2/12
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/12
                            }
                        }else{
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }else if(adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0){
                        if(adaSaudaraSeayahSeibu == 1 && adaSaudariSeayahSeibu == 0){
                            if (cucuLaki == 0 && cucuPerempuan == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 2/3
                                    bagianIbu = "1/3 → 1/3"
                                    hartaIbu = harta * 1/3
                                }
                            }else if(cucuPerempuan == 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/5"
                                    hartaAyah = harta * 1/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else if (cucuPerempuan > 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 5/12
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }else{
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    sisaHarta = harta - hartaAyah - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }else{
                            if (cucuLaki == 0 && cucuPerempuan == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 5/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                }
                            }else if(cucuPerempuan == 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/5"
                                    hartaAyah = harta * 1/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else if (cucuPerempuan > 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 5/12
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }else{
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    sisaHarta = harta - hartaAyah - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if(adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1){
                        if(adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 1){
                            if (cucuLaki == 0 && cucuPerempuan == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/3"
                                    hartaAyah = harta * 1/3
                                    bagianIbu = "1/3 → 2/3"
                                    hartaIbu = harta * 2/3
                                }
                            }else if(cucuPerempuan == 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/5"
                                    hartaAyah = harta * 1/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else if (cucuPerempuan > 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 5/12
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }else{
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    sisaHarta = harta - hartaAyah - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }else{
                            if (cucuLaki == 0 && cucuPerempuan == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/2"
                                    hartaAyah = harta * 1/2
                                    bagianIbu = "1/6 → 1/2"
                                    hartaIbu = harta * 1/2
                                }
                            }else if(cucuPerempuan == 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/5"
                                    hartaAyah = harta * 1/5
                                    bagianIbu = "1/6 → 1/5"
                                    hartaIbu = harta * 1/5
                                    bagianCucuPerempuan = "1/2 → 3/5"
                                    hartaCucuPerempuan = harta * 3/5
                                }
                            }else if (cucuPerempuan > 1 && cucuLaki == 0){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuPerempuan = "2/3 → 4/6"
                                    hartaCucuPerempuan = harta * 4/6
                                }
                            }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "Ashobah"
                                    hartaAyah = harta * 5/12
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }else{
                                if (!adaIbunyaIbu || adaIbunyaIbu){
                                    bagianAyah = "1/6 → 1/6"
                                    hartaAyah = harta * 1/6
                                    bagianIbu = "1/6 → 1/6"
                                    hartaIbu = harta * 1/6
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                    sisaHarta = harta - hartaAyah - hartaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/2"
                                hartaAyah = harta * 1/2
                                bagianIbu = "1/6 → 1/2"
                                hartaIbu = harta * 1/2
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                                bagianCucuPerempuan = "1/2 → 3/5"
                                hartaCucuPerempuan = harta * 3/5
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuPerempuan = "2/3 → 4/6"
                                hartaCucuPerempuan = harta * 4/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "Ashobah"
                                hartaAyah = harta * 5/12
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 2/12
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/12
                            }
                        }else{
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        } else if (anakPerempuan == 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah - hartaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/5"
                                hartaAnakPerempuan = harta * 3/5
                                bagianAyah = "1/6 → 1/5"
                                hartaAyah = harta * 1/5
                                bagianIbu = "1/6 → 1/5"
                                hartaIbu = harta * 1/5
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuPerempuan = "1/6 → 1/6"
                                hartaCucuPerempuan = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "1/2 → 3/6"
                                hartaAnakPerempuan = harta * 3/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAnakPerempuan - hartaAyah - hartaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        } else if(anakPerempuan > 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                sisaHarta = harta - hartaAyah - hartaIbu
                                hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuPerempuan = "Mahjub"
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianCucuLaki = "Ashobah"
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakPerempuan = "2/3 → 4/6"
                                hartaAnakPerempuan = harta * 4/6
                                bagianAyah = "1/6 → 1/6"
                                hartaAyah = harta * 1/6
                                bagianIbu = "1/6 → 1/6"
                                hartaIbu = harta * 1/6
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                            }
                        }
                    }
                }
            }
        }
    }

    return TidakAdaSuamiDanIstriSamaDenganNol(
        bagianIbu,
        bagianAyah,
        bagianSuami,
        bagianAyahnyaAyah,
        bagianIbunyaAyah,
        bagianSaudaraSeayahSeibu,
        bagianSaudariSeayahSeibu,
        bagianIbunyaIbu,
        bagianIstri,
        bagianAnakPerempuan,
        bagianAnakLaki,
        bagianCucuLaki,
        bagianCucuPerempuan,

        hartaAyah,
        hartaIbu,
        hartaSuami,
        hartaAyahnyaAyah,
        hartaIbunyaAyah,
        hartaSaudaraSeayahSeibu,
        hartaSaudariSeayahSeibu,
        hartaIbunyaIbu,
        hartaIstri,
        hartaAnakLaki,
        hartaAnakPerempuan,
        hartaCucuLaki,
        hartaCucuPerempuan,

        sisaHarta
    )
}
