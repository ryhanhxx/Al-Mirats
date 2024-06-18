package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

data class TidakAdaAyahDanTidakAdaIbuAnakPerempuan1(
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

fun TidakAdaAyahDanTidakAdaIbuAnakPerempuan1Logic(
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
): TidakAdaAyahDanTidakAdaIbuAnakPerempuan1{
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
        bagianCucuLaki = "Mahjub"
        bagianCucuPerempuan = "Mahjub"
        bagianSaudaraSeayahSeibu = "Mahjub"
        bagianSaudariSeayahSeibu = "Mahjub"
        if(!adaIbunyaAyah && !adaAyahnyaAyah){
            if ((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            sisaHarta = harta - hartaIstri
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            sisaHarta = harta - hartaSuami
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }
                }
            }
        }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
            if ((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }
                }
            }
        }else if(!adaIbunyaAyah && adaAyahnyaAyah){
            if ((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaAyahnyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaAyahnyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu - hartaAyahnyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu - hartaAyahnyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }
                }
            }
        }else{
            if ((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaAyahnyaAyah - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaAyahnyaAyah - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianAnakLaki = "Ashobah"
                        bagianAnakPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaIstri - hartaIbunyaIbu - hartaAyahnyaAyah - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaSuami - hartaIbunyaIbu - hartaAyahnyaAyah - hartaIbunyaAyah
                            hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                            hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                        }
                    }
                }
            }
        }
        //garis baru 4 01/05/2024 paling baruuuu
    }else if(anakLaki == 0){
        if(!adaIbunyaAyah && !adaAyahnyaAyah){
            if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 7/8"
                            hartaAnakPerempuan = harta * 7/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 3/4"
                            hartaAnakPerempuan = harta * 3/4
                        }
                    }else{
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 4/32
                            bagianIbunyaIbu = "1/6 → 7/32"
                            hartaIbunyaIbu = harta * 7/32
                            bagianAnakPerempuan = "1/2 → 21/32"
                            hartaAnakPerempuan = harta * 21/32
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(4.0/16.0)
                            bagianIbunyaIbu = "1/6 → 3/16"
                            hartaIbunyaIbu = harta * 3/16
                            bagianAnakPerempuan = "1/2 → 9/16"
                            hartaAnakPerempuan = harta * 9/16
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 4/32
                            bagianAnakPerempuan = "1/2 → 21/32"
                            hartaAnakPerempuan = harta * 21/32
                            bagianCucuPerempuan = "1/2 → 7/32"
                            hartaCucuPerempuan = harta * 7/32
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(4.0/16.0)
                            bagianAnakPerempuan = "1/2 → 9/16"
                            hartaAnakPerempuan = harta * 9/16
                            bagianCucuPerempuan = "1/2 → 3/16"
                            hartaCucuPerempuan = harta * 3/16
                        }
                    }else{
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 5/40
                            bagianIbunyaIbu = "1/6 → 7/40"
                            hartaIbunyaIbu = harta * 7/40
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianCucuPerempuan = "1/2 → 7/40"
                            hartaCucuPerempuan = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            hartaSaudariSeayahSeibu = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            hartaSaudariSeayahSeibu = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudariSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            hartaSaudariSeayahSeibu = harta * 1/12
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudariSeayahSeibu = harta * 5/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            hartaSaudariSeayahSeibu = harta * 1/12
                            bagianCucuPerempuan = "1/2 → 2/12"
                            hartaCucuPerempuan = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            hartaSaudariSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            hartaCucuLaki = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
                        }
                    }
                }else{
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            hartaSaudaraSeayahSeibu = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            hartaSaudaraSeayahSeibu = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudaraSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            hartaSaudaraSeayahSeibu = harta * 1/12
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudaraSeayahSeibu = harta * 5/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            hartaSaudaraSeayahSeibu = harta * 1/12
                            bagianCucuPerempuan = "1/2 → 2/12"
                            hartaCucuPerempuan = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            hartaSaudaraSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            hartaCucuLaki = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
                        }
                    }
                }else{
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else{
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaCucuPerempuan
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuPerempuan = "1/2 → 2/12"
                            hartaCucuPerempuan = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaCucuPerempuan
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            hartaSaudaraSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            hartaCucuLaki = harta * 3/8
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/4
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
                        }
                    }
                }else{
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 1/8
                            bagianAnakPerempuan = "1/2 → 4/8"
                            hartaAnakPerempuan = harta * 4/8
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(1.0/4.0)
                            bagianAnakPerempuan = "1/2 → 2/4"
                            hartaAnakPerempuan = harta * 2/4
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbunyaIbu = "1/6 → 2/12"
                            hartaIbunyaIbu = harta * 2/12
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }
        }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
            if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 4/32
                            bagianAnakPerempuan = "1/2 → 21/32"
                            hartaAnakPerempuan = harta * 21/32
                            bagianIbunyaAyah = "1/6 → 7/32"
                            hartaIbunyaAyah = harta * 7/32
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(4.0/16.0)
                            bagianAnakPerempuan = "1/2 → 9/16"
                            hartaAnakPerempuan = harta * 9/16
                            bagianIbunyaAyah = "1/6 → 3/16"
                            hartaIbunyaAyah = harta * 3/16
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 1/8"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 5/40
                            bagianIbunyaIbu = "1/6 → 7/40"
                            hartaIbunyaIbu = harta * 7/40
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianIbunyaAyah = "1/6 → 7/40"
                            hartaIbunyaAyah = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 5/40
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianCucuPerempuan = "1/2 → 7/40"
                            hartaCucuPerempuan = harta * 7/40
                            bagianIbunyaAyah = "1/6 → 7/40"
                            hartaIbunyaAyah = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }else{
                        bagianSuami = "1/4 → 3/15"
                        bagianIstri = "1/8 → 3/27"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/27
                            bagianIbunyaIbu = "1/6 → 4/27"
                            hartaIbunyaIbu = harta * 4/27
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }
            }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudariSeayahSeibu = harta * 5/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudariSeayahSeibu = harta * 1/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudariSeayahSeibu = harta * 1/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
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
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaCucuLaki = harta * 5/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else{
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }
            }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            hartaSaudaraSeayahSeibu = harta * 5/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            hartaSaudaraSeayahSeibu = harta * 1/12
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            hartaSaudaraSeayahSeibu = harta * 1/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaSaudaraSeayahSeibu = harta * 1/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/12"
                            hartaCucuPerempuan = harta * 2/12
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
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaCucuLaki = harta * 5/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else{
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }
                }
            }else{
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaAyah
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    bagianSaudaraSeayahSeibu = "Ashobah"
                    bagianSaudariSeayahSeibu = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuPerempuan = "1/2 → 4/24"
                            hartaCucuPerempuan = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaCucuPerempuan - hartaIbunyaAyah
                            hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                            hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
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
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    bagianCucuLaki = "Ashobah"
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            hartaCucuLaki = harta * 5/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }else{
                    bagianSaudaraSeayahSeibu = "Mahjub"
                    bagianSaudariSeayahSeibu = "Mahjub"
                    bagianCucuLaki = "Ashobah"
                    bagianCucuPerempuan = "Ashobah"
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianIbunyaAyah = "1/6 → 2/12"
                            hartaIbunyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }
                }
            }
            //batas terakhiiiirrr
        }else if(!adaIbunyaAyah && adaAyahnyaAyah){
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                bagianSaudaraSeayahSeibu = "Mahjub"
                bagianSaudariSeayahSeibu = "Mahjub"
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 1/4"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 4/32
                            bagianAnakPerempuan = "1/2 → 21/32"
                            hartaAnakPerempuan = harta * 21/32
                            bagianAyahnyaAyah = "1/6 → 7/32"
                            hartaAyahnyaAyah = harta * 7/32
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(4.0/16.0)
                            bagianAnakPerempuan = "1/2 → 9/16"
                            hartaAnakPerempuan = harta * 9/16
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
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianAyahnyaAyah = "1/6 → 7/40"
                            hartaAyahnyaAyah = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianAyahnyaAyah = "1/6 → 2/13"
                            hartaAyahnyaAyah = harta * 2/13
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 5/40
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianCucuPerempuan = "1/2 → 7/40"
                            hartaCucuPerempuan = harta * 7/40
                            bagianAyahnyaAyah = "1/6 → 7/40"
                            hartaAyahnyaAyah = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuPerempuan = "1/2 → 2/13"
                            hartaCucuPerempuan = harta * 2/13
                            bagianAyahnyaAyah = "1/6 → 2/13"
                            hartaAyahnyaAyah = harta * 2/13
                        }
                    }else{
                        bagianSuami = "1/4 → 3/15"
                        bagianIstri = "1/8 → 3/27"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/27
                            bagianIbunyaIbu = "1/6 → 4/27"
                            hartaIbunyaIbu = harta * 4/27
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianAyahnyaAyah = "1/6 → 4/27"
                            hartaAyahnyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianAyahnyaAyah = "1/6 → 2/15"
                            hartaAyahnyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 5/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/12
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
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
                            bagianAyahnyaAyah = "1/6 → 2/13"
                            hartaAyahnyaAyah = harta * 2/13
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri -  hartaAyahnyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianAnakPerempuan = "1/2 → 6/12"
                            hartaAnakPerempuan = harta * 6/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                            sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaAyahnyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }
                    }else{
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbunyaIbu = "1/6 → 4/24"
                            hartaIbunyaIbu = harta * 4/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu - hartaAyahnyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianIbunyaIbu = "1/6 → 2/13"
                            hartaIbunyaIbu = harta * 2/13
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianAyahnyaAyah = "1/6 → 2/13"
                            hartaAyahnyaAyah = harta * 2/13
                        }
                    }
                }
            }
        }else{
            if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                bagianSaudaraSeayahSeibu = "Mahjub"
                bagianSaudariSeayahSeibu = "Mahjub"
                if (cucuLaki == 0 && cucuPerempuan == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 1/8"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 5/40
                            bagianAnakPerempuan = "1/2 → 21/40"
                            hartaAnakPerempuan = harta * 21/40
                            bagianAyahnyaAyah = "1/6 → 7/40"
                            hartaAyahnyaAyah = harta * 7/40
                            bagianIbunyaAyah = "1/6 → 7/40"
                            hartaIbunyaAyah = harta * 7/40
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
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
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianAyahnyaAyah = "1/6 → 4/27"
                            hartaAyahnyaAyah = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianAyahnyaAyah = "1/6 → 2/15"
                            hartaAyahnyaAyah = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/15"
                        bagianIstri = "1/8 → 3/27"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/27
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuPerempuan = "1/2 → 4/27"
                            hartaCucuPerempuan = harta * 4/27
                            bagianAyahnyaAyah = "1/6 → 4/27"
                            hartaAyahnyaAyah = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuPerempuan = "1/2 → 2/15"
                            hartaCucuPerempuan = harta * 2/15
                            bagianAyahnyaAyah = "1/6 → 2/15"
                            hartaAyahnyaAyah = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }else{
                        bagianSuami = "1/4 → 3/17"
                        bagianIstri = "1/8 → 3/31"
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/31
                            bagianIbunyaIbu = "1/6 → 4/31"
                            hartaIbunyaIbu = harta * 4/31
                            bagianAnakPerempuan = "1/2 → 12/31"
                            hartaAnakPerempuan = harta * 12/31
                            bagianCucuPerempuan = "1/2 → 4/31"
                            hartaCucuPerempuan = harta * 4/31
                            bagianAyahnyaAyah = "1/6 → 4/31"
                            hartaAyahnyaAyah = harta * 4/31
                            bagianIbunyaAyah = "1/6 → 4/31"
                            hartaIbunyaAyah = harta * 4/31
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/17.0)
                            bagianIbunyaIbu = "1/6 → 2/17"
                            hartaIbunyaIbu = harta * 2/17
                            bagianAnakPerempuan = "1/2 → 6/17"
                            hartaAnakPerempuan = harta * 6/17
                            bagianCucuPerempuan = "1/2 → 2/17"
                            hartaCucuPerempuan = harta * 2/17
                            bagianAyahnyaAyah = "1/6 → 2/17"
                            hartaAyahnyaAyah = harta * 2/17
                            bagianIbunyaAyah = "1/6 → 2/17"
                            hartaIbunyaAyah = harta * 2/17
                        }
                    }
                }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianCucuLaki = "Ashobah"
                            hartaCucuLaki = harta * 1/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianCucuLaki = "Ashobah"
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
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianCucuLaki = "Ashobah"
                            bagianAyahnyaAyah = "1/6 → 4/27"
                            hartaAyahnyaAyah = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianCucuLaki = "Ashobah"
                            bagianAyahnyaAyah = "1/6 → 2/15"
                            hartaAyahnyaAyah = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/15"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }else{
                    if (!adaIbunyaIbu){
                        bagianSuami = "1/4 → 3/13"
                        bagianIstri = "1/8 → 3/24"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianAnakPerempuan = "1/2 → 12/24"
                            hartaAnakPerempuan = harta * 12/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                            bagianIbunyaAyah = "1/6 → 4/24"
                            hartaIbunyaAyah = harta * 4/24
                            sisaHarta = harta - hartaAnakPerempuan - hartaIstri -  hartaAyahnyaAyah - hartaIbunyaAyah
                            hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                            hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/13.0)
                            bagianAnakPerempuan = "1/2 → 6/13"
                            hartaAnakPerempuan = harta * 6/13
                            bagianAyahnyaAyah = "1/6 → 2/13"
                            hartaAyahnyaAyah = harta * 2/13
                            bagianIbunyaAyah = "1/6 → 2/13"
                            hartaIbunyaAyah = harta * 2/13
                        }
                    }else{
                        bagianSuami = "1/4 → 3/15"
                        bagianIstri = "1/8 → 3/27"
                        bagianCucuLaki = "Ashobah"
                        bagianCucuPerempuan = "Ashobah"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/27
                            bagianIbunyaIbu = "1/6 → 4/27"
                            hartaIbunyaIbu = harta * 4/27
                            bagianAnakPerempuan = "1/2 → 12/27"
                            hartaAnakPerempuan = harta * 12/27
                            bagianAyahnyaAyah = "1/6 → 4/27"
                            hartaAyahnyaAyah = harta * 4/27
                            bagianIbunyaAyah = "1/6 → 4/27"
                            hartaIbunyaAyah = harta * 4/27
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/15.0)
                            bagianIbunyaIbu = "1/6 → 2/15"
                            hartaIbunyaIbu = harta * 2/15
                            bagianAnakPerempuan = "1/2 → 6/15"
                            hartaAnakPerempuan = harta * 6/15
                            bagianAyahnyaAyah = "1/6 → 2/15"
                            hartaAyahnyaAyah = harta * 2/15
                            bagianIbunyaAyah = "1/6 → 2/17"
                            hartaIbunyaAyah = harta * 2/15
                        }
                    }
                }
            }
        }
    }
    //batas terbaruuuuu ke 10 23:58

    return TidakAdaAyahDanTidakAdaIbuAnakPerempuan1(
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
