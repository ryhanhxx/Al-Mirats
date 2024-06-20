package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

data class TidakAdaAyahDanTidakAdaIbuAnakPerempuan0(
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

fun TidakAdaAyahDanTidakAdaIbuAnakPerempuan0Logic(
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
): TidakAdaAyahDanTidakAdaIbuAnakPerempuan0{
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

    if (anakLaki >= 1) {
        bagianAnakLaki = "Ashobah"
        hartaAnakLaki = harta
        bagianSaudaraSeayahSeibu = "Mahjub"
        bagianSaudariSeayahSeibu = "Mahjub"
        bagianCucuPerempuan = "Mahjub"
        bagianCucuLaki = "Mahjub"
        if(!adaIbunyaAyah && !adaAyahnyaAyah){
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            hartaAnakLaki = harta*(7.0/8.0)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(3.0/4.0)
                            hartaSuami = harta*(1.0/4.0)
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(7.0/24.0)
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(7.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                        }
                    }
                }
            }
        }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(17.0/24.0)
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(7.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(13.0/24.0)
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(5.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }
                }
            }
        }else if(!adaIbunyaAyah && adaAyahnyaAyah){
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(17.0/24.0)
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(7.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(13.0/24.0)
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(5.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                        }
                    }
                }
            }
        }else{
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(13.0/24.0)
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(5.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            hartaAnakLaki = harta*(9.0/24.0)
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaAnakLaki = harta*(3.0/12.0)
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }
                }
            }
        }
        //garis baru 1 31/05/2024
    }else if(anakLaki == 0){
        if(!adaIbunyaAyah && !adaAyahnyaAyah){
            if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            sisaHarta = harta - hartaIstri
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            sisaHarta = harta - hartaSuami
                        }
                    }else{
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 3/4"
                            hartaIbunyaIbu = harta * 3/4
                            hartaIstri = harta * 1/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            bagianIbunyaIbu = "1/6 → 1/2"
                            hartaIbunyaIbu = harta * 1/2
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuPerempuan = "1/2 → 7/8"
                            hartaCucuPerempuan = harta * 7/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuPerempuan = "1/2 → 3/4"
                            hartaCucuPerempuan = harta * 3/4
                        }
                    }else{
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 7/32"
                            hartaIbunyaIbu = harta * 7/32
                            hartaIstri = harta * 4/32
                            bagianCucuPerempuan = "1/2 → 21/32"
                            hartaCucuPerempuan = harta * 21/32
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(4.0/16.0)
                            bagianIbunyaIbu = "1/6 → 3/16"
                            hartaIbunyaIbu = harta * 3/16
                            bagianCucuPerempuan = "1/2 → 9/16"
                            hartaCucuPerempuan = harta * 9/16
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "1/2 → 7/8"
                            hartaCucuLaki = harta * 7/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu == 1 && adaSaudaraSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            bagianSaudariSeayahSeibu = "1/2 → 3/4"
                            hartaSaudariSeayahSeibu = harta * 3/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            bagianSaudariSeayahSeibu = "1/2 → 1/2"
                            hartaSaudariSeayahSeibu = harta * 1/2
                        }
                    }else{
                        bagianSuami = "1/2 → 3/7"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 3/16"
                            hartaIbunyaIbu = harta * 3/16
                            hartaIstri = harta * 4/16
                            bagianSaudariSeayahSeibu = "1/2 → 9/16"
                            hartaSaudariSeayahSeibu = harta * 9/16
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/7.0)
                            bagianIbunyaIbu = "1/6 → 1/7"
                            hartaIbunyaIbu = harta * 1/7
                            bagianSaudariSeayahSeibu = "1/2 → 3/7"
                            hartaSaudariSeayahSeibu = harta * 3/7
                        }
                    }
                }else if(cucuPerempuan == 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuPerempuan = "1/2 → 4/8"
                            hartaCucuPerempuan = harta * 4/8
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuPerempuan = "1/2 → 2/4"
                            hartaCucuPerempuan = harta * 2/4
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "1/2 → 12/24"
                            hartaCucuPerempuan = harta * 12/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuPerempuan = "1/2 → 6/12"
                            hartaCucuPerempuan = harta * 6/12
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/12
                        }
                    }
                }else if(cucuPerempuan > 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuPerempuan = "2/3 → 8/12"
                            hartaCucuPerempuan = harta * 8/12
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianCucuPerempuan = "1/2 → 8/13"
                            hartaCucuPerempuan = harta * 8/13
                            bagianSaudariSeayahSeibu = "Ashobah"
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "1/2 → 7/8"
                            hartaCucuLaki = harta * 7/8
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/4
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else if (adaSaudariSeayahSeibu > 1 && adaSaudaraSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 3/7"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            bagianSaudariSeayahSeibu = "2/3 → 3/4"
                            hartaSaudariSeayahSeibu = harta * 3/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/7.0)
                            bagianSaudariSeayahSeibu = "2/3 → 4/7"
                            hartaSaudariSeayahSeibu = harta * 4/7
                        }
                    }else{
                        bagianSuami = "1/2 → 3/8"
                        bagianIstri = "1/4 → 3/13"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            hartaIstri = harta * 3/13
                            bagianSaudariSeayahSeibu = "2/3 → 8/13"
                            hartaSaudariSeayahSeibu = harta * 8/13
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/8.0)
                            bagianIbunyaIbu = "1/6 → 1/8"
                            hartaIbunyaIbu = harta * 1/8
                            bagianSaudariSeayahSeibu = "2/3 → 4/8"
                            hartaSaudariSeayahSeibu = harta * 4/8
                        }
                    }
                }else if(cucuPerempuan == 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuPerempuan = "1/2 → 4/8"
                            hartaCucuPerempuan = harta * 4/8
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuPerempuan = "1/2 → 2/4"
                            hartaCucuPerempuan = harta * 2/4
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "1/2 → 12/24"
                            hartaCucuPerempuan = harta * 12/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuPerempuan = "1/2 → 6/12"
                            hartaCucuPerempuan = harta * 6/12
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/12
                        }
                    }
                }else if(cucuPerempuan > 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuPerempuan = "2/3 → 8/12"
                            hartaCucuPerempuan = harta * 8/12
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            bagianSaudariSeayahSeibu = "Ashobah"
                            hartaSaudariSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianCucuPerempuan = "1/2 → 8/13"
                            hartaCucuPerempuan = harta * 8/13
                            bagianSaudariSeayahSeibu = "Ashobah"
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "1/2 → 7/8"
                            hartaCucuLaki = harta * 7/8
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/4
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianSaudariSeayahSeibu = "Mahjub"
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            hartaSaudaraSeayahSeibu = harta * 3/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            hartaSaudaraSeayahSeibu = harta * 1/2
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            hartaIstri = harta * 3/12
                            hartaSaudaraSeayahSeibu = harta * 7/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                            hartaSaudaraSeayahSeibu = harta * 2/6
                        }
                    }
                }else if(cucuPerempuan == 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuPerempuan = "1/2 → 4/8"
                            hartaCucuPerempuan = harta * 4/8
                            hartaSaudaraSeayahSeibu = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuPerempuan = "1/2 → 2/4"
                            hartaCucuPerempuan = harta * 2/4
                            hartaSaudaraSeayahSeibu = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "1/2 → 12/24"
                            hartaCucuPerempuan = harta * 12/24
                            hartaSaudaraSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuPerempuan = "1/2 → 6/12"
                            hartaCucuPerempuan = harta * 6/12
                            hartaSaudaraSeayahSeibu = harta * 1/12
                        }
                    }
                }else if(cucuPerempuan > 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            hartaSaudaraSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuPerempuan = "2/3 → 8/12"
                            hartaCucuPerempuan = harta * 8/12
                            hartaSaudaraSeayahSeibu = harta * 1/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            hartaSaudaraSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianCucuPerempuan = "1/2 → 8/13"
                            hartaCucuPerempuan = harta * 8/13
                            bagianSaudaraSeayahSeibu = "Ashobah"
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "1/2 → 7/8"
                            hartaCucuLaki = harta * 7/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/4
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else{
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            sisaHarta = harta - hartaIstri
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            sisaHarta = harta - hartaSuami
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            hartaIstri = harta * 3/12
                            sisaHarta = harta - hartaIstri
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                            sisaHarta = harta - hartaSuami
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }
                }else if(cucuPerempuan == 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuPerempuan = "1/2 → 4/8"
                            hartaCucuPerempuan = harta * 4/8
                            sisaHarta = harta - hartaIstri - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuPerempuan = "1/2 → 2/4"
                            hartaCucuPerempuan = harta * 2/4
                            sisaHarta = harta - hartaSuami - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "1/2 → 12/24"
                            hartaCucuPerempuan = harta * 12/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuPerempuan = "1/2 → 6/12"
                            hartaCucuPerempuan = harta * 6/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }
                }else if(cucuPerempuan > 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            sisaHarta = harta - hartaIstri - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuPerempuan = "2/3 → 8/12"
                            hartaCucuPerempuan = harta * 8/12
                            sisaHarta = harta - hartaSuami - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuPerempuan = "2/3 → 16/24"
                            hartaCucuPerempuan = harta * 16/24
                            sisaHarta = harta - hartaIstri - hartaCucuPerempuan - hartaIbunyaIbu
                            hartaSaudaraSeayahSeibu = harta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (harta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianCucuPerempuan = "1/2 → 8/13"
                            hartaCucuPerempuan = harta * 8/13
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "1/2 → 7/8"
                            hartaCucuLaki = harta * 7/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/4
                        }
                    }else{
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }
            //batas terakhir 12 04/06/2024
        }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
            bagianIbunyaAyah = "1/6 → 1/1"
            hartaIbunyaAyah = harta
            if(adaSaudariSeayahSeibu > 0 && adaSaudaraSeayahSeibu == 0){
                if(adaSaudariSeayahSeibu == 1){
                    if(cucuLaki == 0 && cucuPerempuan == 0){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/2 → 3/7"
                            bagianIstri = "1/4 → 1/4"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 4/16
                                bagianSaudariSeayahSeibu = "1/2 → 9/16"
                                hartaSaudariSeayahSeibu = harta * 9/16
                                bagianIbunyaAyah = "1/6 → 3/16"
                                hartaIbunyaAyah = harta * 3/16
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/7.0)
                                bagianSaudariSeayahSeibu = "1/2 → 3/7"
                                hartaSaudariSeayahSeibu = harta * 3/7
                                bagianIbunyaAyah = "1/6 → 1/7"
                                hartaIbunyaAyah = harta * 1/7
                            }
                        }else{
                            bagianSuami = "1/2 → 3/8"
                            bagianIstri = "1/4 → 3/13"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/13
                                bagianIbunyaIbu = "1/6 → 2/13"
                                hartaIbunyaIbu = harta * 2/13
                                bagianSaudariSeayahSeibu = "1/2 → 6/13"
                                hartaSaudariSeayahSeibu = harta * 6/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/8.0)
                                bagianSaudariSeayahSeibu = "1/2 → 3/8"
                                hartaSaudariSeayahSeibu = harta * 3/8
                                bagianIbunyaAyah = "1/6 → 1/8"
                                hartaIbunyaAyah = harta * 1/8
                                bagianIbunyaIbu = "1/6 → 1/8"
                                hartaIbunyaIbu = harta * 1/8
                            }
                        }
                    }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 17/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 7/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                            }
                        }else{
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 13/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta * 2/12
                            }
                        }
                    }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else{
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta * 2/12
                                sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }

                    }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                        if(cucuPerempuan == 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                    bagianIbunyaAyah = "1/6 → 2/12"
                                    hartaIbunyaAyah = harta * 2/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianCucuPerempuan = "1/6 → 6/13"
                                    hartaCucuPerempuan = harta * 6/13
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }else{
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianCucuPerempuan = "2/3 → 16/27"
                                    hartaCucuPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianCucuPerempuan = "2/3 → 8/15"
                                    hartaCucuPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }
                    }
                }else{
                    if(cucuLaki == 0 && cucuPerempuan == 0){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/2 → 3/8"
                            bagianIstri = "1/4 → 3/13"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/13
                                bagianSaudariSeayahSeibu = "2/3 → 8/13"
                                hartaSaudariSeayahSeibu = harta * 8/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/8.0)
                                bagianSaudariSeayahSeibu = "2/3 → 4/8"
                                hartaSaudariSeayahSeibu = harta * 4/8
                                bagianIbunyaAyah = "1/6 → 1/8"
                                hartaIbunyaAyah = harta * 1/8
                            }
                        }else{
                            bagianSuami = "1/2 → 3/9"
                            bagianIstri = "1/4 → 3/15"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                                bagianSaudariSeayahSeibu = "1/2 → 8/15"
                                hartaSaudariSeayahSeibu = harta * 8/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/9.0)
                                bagianSaudariSeayahSeibu = "2/3 → 4/9"
                                hartaSaudariSeayahSeibu = harta * 4/9
                                bagianIbunyaAyah = "1/6 → 1/9"
                                hartaIbunyaAyah = harta * 1/9
                                bagianIbunyaIbu = "1/6 → 1/9"
                                hartaIbunyaIbu = harta * 1/9
                            }
                        }
                    }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 17/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 7/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                            }
                        }else{
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 13/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuLaki = "Ashobah"
                                hartaCucuLaki = harta * 5/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta * 2/12
                            }
                        }
                    }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }else{
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                bagianIbunyaIbu = "1/6 → 2/12"
                                hartaIbunyaIbu = harta * 2/12
                                sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                                hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                            }
                        }

                    }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                        if(cucuPerempuan == 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                    bagianIbunyaAyah = "1/6 → 2/12"
                                    hartaIbunyaAyah = harta * 2/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianCucuPerempuan = "1/6 → 6/13"
                                    hartaCucuPerempuan = harta * 6/13
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }else{
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianCucuPerempuan = "2/3 → 16/27"
                                    hartaCucuPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianCucuPerempuan = "2/3 → 8/15"
                                    hartaCucuPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu > 0){
                if(cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            hartaSaudaraSeayahSeibu = harta * 7/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            hartaSaudaraSeayahSeibu = harta * 2/6
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            hartaSaudaraSeayahSeibu = harta * 5/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            hartaSaudaraSeayahSeibu = harta * 1/6
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 13/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if(cucuPerempuan == 1){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuPerempuan = "1/2 → 12/24"
                                hartaCucuPerempuan = harta * 12/24
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 5/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuPerempuan = "1/2 → 6/12"
                                hartaCucuPerempuan = harta * 6/12
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                            }
                        }else{
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianCucuPerempuan = "1/2 → 12/24"
                                hartaCucuPerempuan = harta * 12/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/6 → 6/13"
                                hartaCucuPerempuan = harta * 6/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                                bagianIbunyaIbu = "1/6 → 2/13"
                                hartaIbunyaIbu = harta * 2/13
                                bagianSaudaraSeayahSeibu = "Ashobah"
                            }
                        }
                    }else{
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuPerempuan = "2/3 → 16/24"
                                hartaCucuPerempuan = harta * 16/24
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                hartaSaudaraSeayahSeibu = harta * 1/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/2 → 8/13"
                                hartaCucuPerempuan = harta * 8/13
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }
                        }else{
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianIbunyaIbu = "1/6 → 4/27"
                                hartaIbunyaIbu = harta * 4/27
                                bagianCucuPerempuan = "2/3 → 16/27"
                                hartaCucuPerempuan = harta * 16/27
                                bagianIbunyaAyah = "1/6 → 4/27"
                                hartaIbunyaAyah = harta * 4/27
                                bagianSaudaraSeayahSeibu = "Ashobah"
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "2/3 → 8/15"
                                hartaCucuPerempuan = harta * 8/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                                bagianSaudaraSeayahSeibu = "Ashobah"
                            }
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0){
                if(cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            bagianIbunyaAyah = "1/6 → 3/4"
                            hartaIbunyaAyah = harta * 3/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            bagianIbunyaAyah = "1/6 → 1/2"
                            hartaIbunyaAyah = harta * 1/2
                        }
                    }else{
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 2/8
                            bagianIbunyaIbu = "1/6 → 3/8"
                            hartaIbunyaIbu = harta * 3/8
                            bagianIbunyaAyah = "1/6 → 3/8"
                            hartaIbunyaAyah = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(2.0/4.0)
                            bagianIbunyaAyah = "1/6 → 1/4"
                            hartaIbunyaAyah = harta * 1/4
                            bagianIbunyaIbu = "1/6 → 1/4"
                            hartaIbunyaIbu = harta * 1/4
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 13/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if(cucuPerempuan == 1){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 1/4"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 4/32
                                bagianCucuPerempuan = "1/2 → 21/32"
                                hartaCucuPerempuan = harta * 21/32
                                bagianIbunyaAyah = "1/6 → 7/32"
                                hartaIbunyaAyah = harta * 7/32
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(4.0/16.0)
                                bagianCucuPerempuan = "1/2 → 9/16"
                                hartaCucuPerempuan = harta * 9/16
                                bagianIbunyaAyah = "1/6 → 3/16"
                                hartaIbunyaAyah = harta * 3/16
                            }
                        }else{
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 5/40
                                bagianIbunyaIbu = "1/6 → 7/40"
                                hartaIbunyaIbu = harta * 7/40
                                bagianCucuPerempuan = "1/2 → 21/40"
                                hartaCucuPerempuan = harta * 21/40
                                bagianIbunyaAyah = "1/6 → 7/40"
                                hartaIbunyaAyah = harta * 7/40
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/6 → 6/13"
                                hartaCucuPerempuan = harta * 6/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                                bagianIbunyaIbu = "1/6 → 2/13"
                                hartaIbunyaIbu = harta * 2/13
                            }
                        }
                    }else{
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 5/40
                                bagianCucuPerempuan = "2/3 → 28/40"
                                hartaCucuPerempuan = harta * 28/40
                                bagianIbunyaAyah = "1/6 → 7/40"
                                hartaIbunyaAyah = harta * 7/40
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "2/3 → 8/13"
                                hartaCucuPerempuan = harta * 8/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }
                        }else{
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianIbunyaIbu = "1/6 → 4/27"
                                hartaIbunyaIbu = harta * 4/27
                                bagianCucuPerempuan = "2/3 → 16/27"
                                hartaCucuPerempuan = harta * 16/27
                                bagianIbunyaAyah = "1/6 → 4/27"
                                hartaIbunyaAyah = harta * 4/27
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "2/3 → 8/15"
                                hartaCucuPerempuan = harta * 8/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                            }
                        }
                    }
                }
            }else{
                // 22:41 31/05/2024
                if(cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 13/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if(cucuPerempuan == 1){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuPerempuan = "1/2 → 12/24"
                                hartaCucuPerempuan = harta * 12/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/12.0)
                                bagianCucuPerempuan = "1/2 → 6/12"
                                hartaCucuPerempuan = harta * 6/12
                                bagianIbunyaAyah = "1/6 → 2/12"
                                hartaIbunyaAyah = harta * 2/12
                                sisaHarta = harta - hartaIbunyaAyah - hartaSuami - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }
                        }else{
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianIbunyaIbu = "1/6 → 4/24"
                                hartaIbunyaIbu = harta * 4/24
                                bagianCucuPerempuan = "1/2 → 12/24"
                                hartaCucuPerempuan = harta * 12/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaIbunyaIbu - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/6 → 6/13"
                                hartaCucuPerempuan = harta * 6/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                                bagianIbunyaIbu = "1/6 → 2/13"
                                hartaIbunyaIbu = harta * 2/13
                            }
                        }
                    }else{
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/24
                                bagianCucuPerempuan = "2/3 → 16/24"
                                hartaCucuPerempuan = harta * 16/24
                                bagianIbunyaAyah = "1/6 → 4/24"
                                hartaIbunyaAyah = harta * 4/24
                                sisaHarta = harta - hartaIbunyaAyah - hartaIstri - hartaCucuPerempuan
                                hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "2/3 → 8/13"
                                hartaCucuPerempuan = harta * 8/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }
                        }else{
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianIbunyaIbu = "1/6 → 4/27"
                                hartaIbunyaIbu = harta * 4/27
                                bagianCucuPerempuan = "2/3 → 16/27"
                                hartaCucuPerempuan = harta * 16/27
                                bagianIbunyaAyah = "1/6 → 4/27"
                                hartaIbunyaAyah = harta * 4/27
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "2/3 → 8/15"
                                hartaCucuPerempuan = harta * 8/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                            }
                        }
                    }
                }

            }
            //batas terakhiiiirrr 13 17:11 04/06/2024
        }else if(!adaIbunyaAyah && adaAyahnyaAyah){
            bagianAyahnyaAyah = "Ashobah"
            hartaAyahnyaAyah = harta
            if((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                bagianSaudariSeayahSeibu = "Mahjub"
                bagianSaudaraSeayahSeibu = "Mahjub"
                if(cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 1/2"
                        bagianIstri = "1/4 → 1/4"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/4
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 3/4
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/2.0)
                            bagianIbunyaAyah = "Ashobah"
                            hartaIbunyaAyah = harta * 1/2
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 7/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 2/6
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 17/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 7/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 13/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAyahnyaAyah - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAyahnyaAyah - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAyahnyaAyah - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            sisaHarta = harta - hartaAyahnyaAyah - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if(cucuPerempuan == 1){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 1/4"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 4/32
                                bagianCucuPerempuan = "1/2 → 21/32"
                                hartaCucuPerempuan = harta * 21/32
                                bagianAyahnyaAyah = "1/6 → 7/32"
                                hartaAyahnyaAyah = harta * 7/32
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(4.0/16.0)
                                bagianCucuPerempuan = "1/2 → 9/16"
                                hartaCucuPerempuan = harta * 9/16
                                bagianAyahnyaAyah = "1/6 → 3/16"
                                hartaAyahnyaAyah = harta * 3/16
                            }
                        }else{
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 5/40
                                bagianIbunyaIbu = "1/6 → 7/40"
                                hartaIbunyaIbu = harta * 7/40
                                bagianCucuPerempuan = "1/2 → 21/40"
                                hartaCucuPerempuan = harta * 21/40
                                bagianAyahnyaAyah = "1/6 → 7/40"
                                hartaAyahnyaAyah = harta * 7/40
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/6 → 6/13"
                                hartaCucuPerempuan = harta * 6/13
                                bagianAyahnyaAyah = "1/6 → 2/13"
                                hartaAyahnyaAyah = harta * 2/13
                                bagianIbunyaIbu = "1/6 → 2/13"
                                hartaIbunyaIbu = harta * 2/13
                            }
                        }
                    }else{
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 5/40
                                bagianCucuPerempuan = "2/3 → 28/40"
                                hartaCucuPerempuan = harta * 28/40
                                bagianAyahnyaAyah = "1/6 → 7/40"
                                hartaAyahnyaAyah = harta * 7/40
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/2 → 8/13"
                                hartaCucuPerempuan = harta * 8/13
                                bagianAyahnyaAyah = "1/6 → 2/13"
                                hartaAyahnyaAyah = harta * 2/13
                            }
                        }else{
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianIbunyaIbu = "1/6 → 4/27"
                                hartaIbunyaIbu = harta * 4/27
                                bagianCucuPerempuan = "2/3 → 16/27"
                                hartaCucuPerempuan = harta * 16/27
                                bagianAyahnyaAyah = "1/6 → 4/27"
                                hartaAyahnyaAyah = harta * 4/27
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "2/3 → 8/15"
                                hartaCucuPerempuan = harta * 8/15
                                bagianAyahnyaAyah = "1/6 → 2/15"
                                hartaAyahnyaAyah = harta * 2/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                                bagianSaudariSeayahSeibu = "Ashobah"
                            }
                        }
                    }
                }
            }
        }else{
            if((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                bagianSaudariSeayahSeibu = "Mahjub"
                bagianSaudaraSeayahSeibu = "Mahjub"
                if(cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 7/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 2/6
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                        }
                    }else{
                        bagianSuami = "1/2 → 3/6"
                        bagianIstri = "1/4 → 3/12"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 5/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/6.0)
                            bagianAyahnyaAyah = "Ashobah"
                            hartaAyahnyaAyah = harta * 1/6
                            bagianIbunyaIbu = "1/6 → 1/6"
                            hartaIbunyaIbu = harta * 1/6
                            bagianIbunyaAyah = "1/6 → 1/6"
                            hartaIbunyaAyah = harta * 1/6
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 13/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 9/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }
                }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAyahnyaAyah - hartaIstri - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAyahnyaAyah - hartaSuami - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAyahnyaAyah - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAyahnyaAyah - hartaSuami - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }

                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if(cucuPerempuan == 1){
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 1/8"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 5/40
                                bagianCucuPerempuan = "1/2 → 21/40"
                                hartaCucuPerempuan = harta * 21/40
                                bagianAyahnyaAyah = "1/6 → 7/40"
                                hartaAyahnyaAyah = harta * 7/40
                                bagianIbunyaAyah = "1/6 → 7/40"
                                hartaIbunyaAyah = harta * 7/40
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/13.0)
                                bagianCucuPerempuan = "1/2 → 6/13"
                                hartaCucuPerempuan = harta * 6/13
                                bagianAyahnyaAyah = "1/6 → 2/13"
                                hartaAyahnyaAyah = harta * 2/13
                                bagianIbunyaAyah = "1/6 → 2/13"
                                hartaIbunyaAyah = harta * 2/13
                            }
                        }else{
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianIbunyaIbu = "1/6 → 4/27"
                                hartaIbunyaIbu = harta * 4/27
                                bagianCucuPerempuan = "1/2 → 12/27"
                                hartaCucuPerempuan = harta * 12/27
                                bagianAyahnyaAyah = "1/6 → 4/27"
                                hartaAyahnyaAyah = harta * 4/27
                                bagianIbunyaAyah = "1/6 → 4/27"
                                hartaIbunyaAyah = harta * 4/27
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "1/6 → 6/15"
                                hartaCucuPerempuan = harta * 6/15
                                bagianAyahnyaAyah = "1/6 → 2/15"
                                hartaAyahnyaAyah = harta * 2/15
                                bagianIbunyaIbu = "1/6 → 2/15"
                                hartaIbunyaIbu = harta * 2/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                            }
                        }
                    }else{
                        if (!adaIbunyaIbu){
                            bagianSuami = "1/4 → 3/15"
                            bagianIstri = "1/8 → 3/27"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/27
                                bagianCucuPerempuan = "1/2 → 16/27"
                                hartaCucuPerempuan = harta * 16/27
                                bagianAyahnyaAyah = "1/6 → 4/27"
                                hartaAyahnyaAyah = harta * 4/27
                                bagianIbunyaAyah = "1/6 → 4/27"
                                hartaIbunyaAyah = harta * 4/27
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/15.0)
                                bagianCucuPerempuan = "1/2 → 8/15"
                                hartaCucuPerempuan = harta * 8/15
                                bagianAyahnyaAyah = "1/6 → 2/15"
                                hartaAyahnyaAyah = harta * 2/15
                                bagianIbunyaAyah = "1/6 → 2/15"
                                hartaIbunyaAyah = harta * 2/15
                            }
                        }else{
                            bagianSuami = "1/4 → 3/17"
                            bagianIstri = "1/8 → 3/31"
                            if (jenisKelaminPewaris.equals("Laki-Laki")){
                                hartaIstri = harta * 3/31
                                bagianIbunyaIbu = "1/6 → 4/31"
                                hartaIbunyaIbu = harta * 4/31
                                bagianCucuPerempuan = "1/2 → 16/31"
                                hartaCucuPerempuan = harta * 16/31
                                bagianAyahnyaAyah = "1/6 → 4/31"
                                hartaAyahnyaAyah = harta * 4/31
                                bagianIbunyaAyah = "1/6 → 4/31"
                                hartaIbunyaAyah = harta * 4/31
                            }else if(jenisKelaminPewaris.equals("Perempuan")){
                                hartaSuami = harta*(3.0/17.0)
                                bagianCucuPerempuan = "1/6 → 8/17"
                                hartaCucuPerempuan = harta * 8/17
                                bagianAyahnyaAyah = "1/6 → 2/17"
                                hartaAyahnyaAyah = harta * 2/17
                                bagianIbunyaIbu = "1/6 → 2/17"
                                hartaIbunyaIbu = harta * 2/17
                                bagianIbunyaAyah = "1/6 → 2/17"
                                hartaIbunyaAyah = harta * 2/17
                            }
                        }
                    }
                }
            }
        }
    }
//garis baru 3 15:32 01/06/2024

    return TidakAdaAyahDanTidakAdaIbuAnakPerempuan0(
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