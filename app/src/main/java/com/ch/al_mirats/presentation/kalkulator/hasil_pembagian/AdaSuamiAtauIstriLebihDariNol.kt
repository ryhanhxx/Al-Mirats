package com.ch.al_mirats.presentation.kalkulator.hasil_pembagian

data class AdaSuamiAtauIstriLebihDariNol(
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

fun AdaSuamiAtauIstriLebihDariNolLogic(
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
): AdaSuamiAtauIstriLebihDariNol{
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
            val result = TidakAdaAyahDanTidakAdaIbuAnakPerempuan0Logic(
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
        else if (anakPerempuan == 1) {
            val result = TidakAdaAyahDanTidakAdaIbuAnakPerempuan1Logic(
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
        else if(anakPerempuan > 1){
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
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbunyaIbu = "1/6 → 7/40"
                                    hartaIbunyaIbu = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 1/8
                                    bagianAnakPerempuan = "2/3 → 7/8"
                                    hartaAnakPerempuan = harta * 7/8
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(1.0/4.0)
                                    bagianAnakPerempuan = "2/3 → 3/4"
                                    hartaAnakPerempuan = harta * 3/4
                                }
                            }else{
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbunyaIbu = "1/6 → 7/40"
                                    hartaIbunyaIbu = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "1/2 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "1/2 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudariSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                    bagianCucuPerempuan = "Mahjub"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                    bagianCucuPerempuan = "Mahjub"
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuPerempuan = "Mahjub"
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudaraSeayahSeibu = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudaraSeayahSeibu = harta * 5/24
                                    bagianCucuPerempuan = "Mahjub"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    hartaSaudaraSeayahSeibu = harta * 1/12
                                    bagianCucuPerempuan = "Mahjub"
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuPerempuan = "Mahjub"
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaSuami
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "1/2 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
                                    hartaCucuLaki = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAnakPerempuan = "2/3 → 8/12"
                                    hartaAnakPerempuan = harta * 8/12
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }
                    }
                }else if (adaIbunyaAyah  && !adaAyahnyaAyah){
                    if ((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                        bagianSaudaraSeayahSeibu = "Ashobah"
                        bagianSaudariSeayahSeibu = "Ashobah"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                    bagianIbunyaAyah = "1/6 → 7/40"
                                    hartaIbunyaAyah = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                    bagianIbunyaAyah = "1/6 → 7/40"
                                    hartaIbunyaAyah = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "1/2 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianCucuLaki = "Ashobah"
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSaudariSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudariSeayahSeibu = "Ashobah"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianCucuLaki = "Ashobah"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else{
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianCucuLaki = "Ashobah"
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianIbunyaAyah = "1/6 → 2/13"
                                    hartaIbunyaAyah = harta * 2/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianCucuPerempuan = "Mahjub"
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri  - hartaIbunyaAyah
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianCucuLaki = "Ashobah"
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 1/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianIbunyaAyah = "1/6 → 4/24"
                                    hartaIbunyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaIbunyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/15
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
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                    bagianAyahnyaAyah = "1/6 → 7/40"
                                    hartaAyahnyaAyah = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                    bagianAyahnyaAyah = "1/6 → 7/40"
                                    hartaAyahnyaAyah = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
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
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri -  hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
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
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
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
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/18"
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
                                    bagianAnakPerempuan = "2/3 → 16/31"
                                    hartaAnakPerempuan = harta * 16/31
                                    bagianAyahnyaAyah = "1/6 → 4/31"
                                    hartaAyahnyaAyah = harta * 4/13
                                    bagianIbunyaAyah = "1/6 → 4/31"
                                    hartaIbunyaAyah = harta * 4/31
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/17.0)
                                    bagianIbunyaIbu = "1/6 → 2/17"
                                    hartaIbunyaIbu = harta * 2/17
                                    bagianAnakPerempuan = "2/3 → 8/17"
                                    hartaAnakPerempuan = harta * 8/17
                                    bagianAyahnyaAyah = "1/6 → 2/17"
                                    hartaAyahnyaAyah = harta * 2/17
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/17
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/18"
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
                                    bagianAnakPerempuan = "2/3 → 16/31"
                                    hartaAnakPerempuan = harta * 16/31
                                    bagianAyahnyaAyah = "1/6 → 4/31"
                                    hartaAyahnyaAyah = harta * 4/13
                                    bagianIbunyaAyah = "1/6 → 4/31"
                                    hartaIbunyaAyah = harta * 4/31
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/17.0)
                                    bagianIbunyaIbu = "1/6 → 2/17"
                                    hartaIbunyaIbu = harta * 2/17
                                    bagianAnakPerempuan = "2/3 → 8/17"
                                    hartaAnakPerempuan = harta * 8/17
                                    bagianAyahnyaAyah = "1/6 → 2/17"
                                    hartaAyahnyaAyah = harta * 2/17
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/17
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianCucuLaki = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/18"
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
                                    bagianAnakPerempuan = "2/3 → 16/31"
                                    hartaAnakPerempuan = harta * 16/31
                                    bagianAyahnyaAyah = "1/6 → 4/31"
                                    hartaAyahnyaAyah = harta * 4/13
                                    bagianIbunyaAyah = "1/6 → 4/31"
                                    hartaIbunyaAyah = harta * 4/31
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/17.0)
                                    bagianIbunyaIbu = "1/6 → 2/17"
                                    hartaIbunyaIbu = harta * 2/17
                                    bagianAnakPerempuan = "2/3 → 8/17"
                                    hartaAnakPerempuan = harta * 8/17
                                    bagianAyahnyaAyah = "1/6 → 2/17"
                                    hartaAyahnyaAyah = harta * 2/17
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/17
                                }
                            }
                        }else{
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                    bagianIbunyaAyah = "1/6 → 4/27"
                                    hartaIbunyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/18"
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
                                    bagianAnakPerempuan = "2/3 → 16/31"
                                    hartaAnakPerempuan = harta * 16/31
                                    bagianAyahnyaAyah = "1/6 → 4/31"
                                    hartaAyahnyaAyah = harta * 4/13
                                    bagianIbunyaAyah = "1/6 → 4/31"
                                    hartaIbunyaAyah = harta * 4/31
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/17.0)
                                    bagianIbunyaIbu = "1/6 → 2/17"
                                    hartaIbunyaIbu = harta * 2/17
                                    bagianAnakPerempuan = "2/3 → 8/17"
                                    hartaAnakPerempuan = harta * 8/17
                                    bagianAyahnyaAyah = "1/6 → 2/17"
                                    hartaAyahnyaAyah = harta * 2/17
                                    bagianIbunyaAyah = "1/6 → 2/15"
                                    hartaIbunyaAyah = harta * 2/17
                                }
                            }
                        }
                    }
                }
            }
        }
        //batas terakhir 14 8:08 05/06/2024
    }else if (!adaAyah && adaIbu){
        if (anakPerempuan == 0) {
            if (anakLaki >= 1) {
                bagianAnakLaki = "Ashobah"
                hartaAnakLaki = harta
                bagianIbunyaIbu = "Mahjub"
                bagianIbunyaAyah = "Mahjub"
                bagianSaudaraSeayahSeibu = "Mahjub"
                bagianSaudariSeayahSeibu = "Mahjub"
                bagianCucuLaki = "Mahjub"
                bagianCucuPerempuan = "Mahjub"
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    hartaAnakLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    hartaAnakLaki = harta * 7/12
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if(adaIbunyaIbu || !adaIbunyaIbu){
                        bagianAnakLaki = "Ashobah"
                        bagianSuami = "1/4 → 3/12"
                        bagianIstri = "1/8 → 3/24"
                        if (jenisKelaminPewaris.equals("Laki-Laki")){
                            hartaIstri = harta * 3/24
                            bagianIbu = "1/6 → 4/24"
                            hartaIbu = harta * 4/24
                            hartaAnakLaki = harta * 13/24
                            bagianAyahnyaAyah = "1/6 → 4/24"
                            hartaAyahnyaAyah = harta * 4/24
                        }else if(jenisKelaminPewaris.equals("Perempuan")){
                            hartaSuami = harta*(3.0/12.0)
                            bagianIbu = "1/6 → 2/12"
                            hartaIbu = harta * 2/12
                            hartaAnakLaki = harta * 5/12
                            bagianAyahnyaAyah = "1/6 → 2/12"
                            hartaAyahnyaAyah = harta * 2/12
                        }
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                bagianIbunyaIbu = "Mahjub"
                bagianIbunyaAyah = "Mahjub"
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah)){
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                bagianSuami = "1/2 → 1/2"
                                bagianIstri = "1/4 → 1/4"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 1/4
                                    bagianIbu = "1/3 → 3/4"
                                    hartaIbu = harta * 3/4
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(1.0/2.0)
                                    bagianIbu = "1/3 → 1/2"
                                    hartaIbu = harta * 1/2
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 4/32
                                    bagianIbu = "1/6 → 7/32"
                                    hartaIbu = harta * 7/32
                                    bagianCucuPerempuan = "1/2 → 21/32"
                                    hartaCucuPerempuan = harta * 21/32
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(4.0/16.0)
                                    bagianIbu = "1/6 → 3/16"
                                    hartaIbu = harta * 3/16
                                    bagianCucuPerempuan = "1/2 → 9/16"
                                    hartaCucuPerempuan = harta * 9/16
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                    bagianCucuPerempuan = "1/2 → 28/40"
                                    hartaCucuPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianCucuPerempuan = "2/3 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                bagianCucuLaki = "Ashobah"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    hartaCucuLaki = harta * 7/12
                                }
                            }
                        }else{
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSuami = "1/2 → 3/8"
                            bagianIstri = "1/4 → 3/13"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/13
                                    bagianIbu = "1/3 → 4/13"
                                    hartaIbu = harta * 4/13
                                    bagianSaudariSeayahSeibu = "1/2 → 6/13"
                                    hartaSaudariSeayahSeibu = harta * 6/13
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/8.0)
                                    bagianIbu = "1/3 → 2/8"
                                    hartaIbu = harta * 2/8
                                    bagianSaudariSeayahSeibu = "1/2 → 3/8"
                                    hartaSaudariSeayahSeibu = harta * 3/8
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuPerempuan = "Ashobah"
                                    hartaCucuPerempuan = harta * 7/12
                                }
                            }
                        }else{
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if (adaSaudariSeayahSeibu > 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSuami = "1/2 → 3/8"
                            bagianIstri = "1/4 → 3/13"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/13
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianSaudariSeayahSeibu = "2/3 → 8/13"
                                    hartaSaudariSeayahSeibu = harta * 8/13
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/8.0)
                                    bagianIbu = "1/6 → 1/8"
                                    hartaIbu = harta * 1/8
                                    bagianSaudariSeayahSeibu = "2/3 → 4/8"
                                    hartaSaudariSeayahSeibu = harta * 4/8
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    bagianCucuPerempuan = "2/3 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianSaudariSeayahSeibu = "Mahjub"
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 7/12
                                }
                            }
                        }else{
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSuami = "1/2 → 3/6"
                            bagianIstri = "1/4 → 3/12"
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/12
                                    bagianIbu = "1/3 → 4/12"
                                    hartaIbu = harta * 4/12
                                    hartaSaudaraSeayahSeibu = harta * 5/12
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/6.0)
                                    bagianIbu = "1/3 → 2/6"
                                    hartaIbu = harta * 2/6
                                    hartaSaudaraSeayahSeibu = harta * 1/6
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    hartaSaudaraSeayahSeibu = harta * 5/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    hartaSaudaraSeayahSeibu = harta * 1/12
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianCucuPerempuan = "2/3 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 7/12
                                }
                            }
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianCucuPerempuan = "1/2 → 12/24"
                                    hartaCucuPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianCucuPerempuan = "1/2 → 6/12"
                                    hartaCucuPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            bagianSuami = "1/4 → 3/13"
                            bagianIstri = "1/8 → 3/24"
                            bagianSaudaraSeayahSeibu = "Ashobah"
                            bagianSaudariSeayahSeibu = "Ashobah"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianCucuPerempuan = "2/3 → 16/24"
                                    hartaCucuPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianCucuPerempuan = "1/2 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 7/12
                                }
                            }
                        }else{
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaIbu = "Mahjub"
                    bagianIbunyaAyah = "Mahjub"
                    if((adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu >= 1) || (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu == 0)){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if(cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/2 → 3/6"
                                bagianIstri = "1/4 → 3/12"
                                if(adaIbunyaIbu || !adaIbunyaIbu){
                                    if (jenisKelaminPewaris.equals("Laki-Laki")){
                                        hartaIstri = harta * 3/12
                                        bagianIbu = "1/3 → 4/12"
                                        hartaIbu = harta * 4/12
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = harta * 5/12
                                    }else if(jenisKelaminPewaris.equals("Perempuan")){
                                        hartaSuami = harta*(3.0/6.0)
                                        bagianIbu = "1/3 → 2/6"
                                        hartaIbu = harta * 2/6
                                        bagianAyahnyaAyah = "Ashobah"
                                        hartaAyahnyaAyah = harta * 1/6
                                    }
                                }
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan == 0){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if(adaIbunyaIbu || !adaIbunyaIbu){
                                    if (jenisKelaminPewaris.equals("Laki-Laki")){
                                        hartaIstri = harta * 3/24
                                        bagianIbu = "1/6 → 4/24"
                                        hartaIbu = harta * 4/24
                                        bagianCucuLaki = "Ashobah"
                                        hartaCucuLaki = harta * 13/24
                                        bagianAyahnyaAyah = "1/6 → 4/24"
                                        hartaAyahnyaAyah = harta * 4/24
                                    }else if(jenisKelaminPewaris.equals("Perempuan")){
                                        hartaSuami = harta*(3.0/12.0)
                                        bagianIbu = "1/6 → 2/12"
                                        hartaIbu = harta * 2/12
                                        bagianCucuLaki = "Ashobah"
                                        hartaCucuLaki = harta * 5/12
                                        bagianAyahnyaAyah = "1/6 → 2/12"
                                        hartaAyahnyaAyah = harta * 2/12
                                    }
                                }
                            }
                        }else if(cucuLaki >= 1 && cucuPerempuan >= 1){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            bagianSuami = "1/4 → 3/12"
                            bagianIstri = "1/8 → 3/24"
                            if(adaIbunyaIbu || !adaIbunyaIbu){
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAyahnyaAyah = "1/6 → 2/12"
                                    hartaAyahnyaAyah = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(cucuPerempuan == 1){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if(adaIbunyaIbu || !adaIbunyaIbu){
                                    if (jenisKelaminPewaris.equals("Laki-Laki")){
                                        hartaIstri = harta * 5/40
                                        bagianIbu = "1/6 → 7/40"
                                        hartaIbu = harta * 7/40
                                        bagianCucuPerempuan = "1/2 → 21/40"
                                        hartaCucuPerempuan = harta * 21/40
                                        bagianAyahnyaAyah = "1/6 → 7/40"
                                        hartaAyahnyaAyah = harta * 7/40
                                    }else if(jenisKelaminPewaris.equals("Perempuan")){
                                        hartaSuami = harta*(3.0/13.0)
                                        bagianIbu = "1/6 → 2/13"
                                        hartaIbu = harta * 2/13
                                        bagianCucuPerempuan = "1/2 → 6/13"
                                        hartaCucuPerempuan = harta * 6/13
                                        bagianAyahnyaAyah = "1/6 → 2/13"
                                        hartaAyahnyaAyah = harta * 2/13
                                    }
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if(adaIbunyaIbu || !adaIbunyaIbu){
                                    if (jenisKelaminPewaris.equals("Laki-Laki")){
                                        hartaIstri = harta * 3/27
                                        bagianIbu = "1/6 → 4/27"
                                        hartaIbu = harta * 4/27
                                        bagianCucuPerempuan = "2/3 → 16/27"
                                        hartaCucuPerempuan = harta * 16/27
                                        bagianAyahnyaAyah = "1/6 → 4/27"
                                        hartaAyahnyaAyah = harta * 4/27
                                    }else if(jenisKelaminPewaris.equals("Perempuan")){
                                        hartaSuami = harta*(3.0/15.0)
                                        bagianIbu = "1/6 → 2/15"
                                        hartaIbu = harta * 2/15
                                        bagianCucuPerempuan = "2/3 → 8/15"
                                        hartaCucuPerempuan = harta * 8/15
                                        bagianAyahnyaAyah = "1/6 → 2/15"
                                        hartaAyahnyaAyah = harta * 2/15
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        }
        else if (anakPerempuan == 1) {
            bagianIbunyaIbu = "Mahjub"
            bagianIbunyaAyah = "Mahjub"
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah  && !adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaAyahnyaAyah
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAyahnyaAyah = "1/6 → 2/12"
                                    hartaAyahnyaAyah = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaAyahnyaAyah
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 4/32
                                    bagianIbu = "1/6 → 7/32"
                                    hartaIbu = harta * 7/32
                                    bagianAnakPerempuan = "1/2 → 21/32"
                                    hartaAnakPerempuan = harta * 21/32
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(4.0/16.0)
                                    bagianIbu = "1/6 → 3/16"
                                    hartaIbu = harta * 3/16
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    hartaAnakPerempuan = harta * 9/16
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAnakPerempuan = harta * 21/40
                                    bagianCucuPerempuan = "1/6 → 7/40"
                                    hartaCucuPerempuan = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaCucuPerempuan = harta * 2/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/12
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuPerempuan = "1/6 → 4/24"
                                    hartaCucuPerempuan = harta * 4/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaCucuPerempuan = harta * 2/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = harta * 1/12
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuPerempuan = "1/6 → 4/24"
                                    hartaCucuPerempuan = harta * 4/24
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaCucuPerempuan = harta * 2/13
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }else{
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaSuami
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuPerempuan = "1/6 → 4/24"
                                    hartaCucuPerempuan = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri - hartaCucuPerempuan
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaCucuPerempuan = harta * 2/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAnakPerempuan = harta * 21/40
                                    bagianAyahnyaAyah = "1/6 → 7/40"
                                    hartaAyahnyaAyah = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianAyahnyaAyah = "1/6 → 2/13"
                                    hartaAyahnyaAyah = harta * 2/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    hartaAnakPerempuan = harta * 12/27
                                    bagianCucuPerempuan = "1/6 → 4/27"
                                    hartaCucuPerempuan = harta * 4/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    hartaAnakPerempuan = harta * 6/15
                                    bagianCucuPerempuan = "1/6 → 2/15"
                                    hartaCucuPerempuan = harta * 2/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyahnyaAyah = "1/6 → 2/13"
                                    hartaAyahnyaAyah = harta * 2/13
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri - hartaAyahnyaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianAyahnyaAyah = "1/6 → 2/13"
                                    hartaAyahnyaAyah = harta * 2/13
                                }
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        }
        else if(anakPerempuan > 1) {
            bagianIbunyaIbu = "Mahjub"
            bagianIbunyaAyah = "Mahjub"
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah  && !adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || cucuLaki >= 1 || cucuPerempuan >= 1){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (adaIbunyaIbu || !adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAyahnyaAyah = "1/6 → 4/24"
                                    hartaAyahnyaAyah = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaAyahnyaAyah
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAyahnyaAyah = "1/6 → 2/12"
                                    hartaAyahnyaAyah = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaAyahnyaAyah
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                bagianCucuPerempuan = "Mahjub"
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            bagianCucuPerempuan = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }
                    }else if(adaSaudariSeayahSeibu >= 1 && adaSaudaraSeayahSeibu == 0){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                    hartaSaudariSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianSaudariSeayahSeibu = "Ashobah"
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSaudariSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                }
                            }
                        }
                    }else if (adaSaudariSeayahSeibu == 0 && adaSaudaraSeayahSeibu >= 1){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                    hartaSaudaraSeayahSeibu = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianSaudaraSeayahSeibu = "Ashobah"
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            bagianSaudaraSeayahSeibu = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                    bagianCucuPerempuan = "Ashobah"
                                }
                            }
                        }
                    }else{
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Ashobah"
                                bagianSaudariSeayahSeibu = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaSaudaraSeayahSeibu = sisaHarta * (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu) / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()
                                    hartaSaudariSeayahSeibu = (sisaHarta * (adaSaudariSeayahSeibu / (adaSaudaraSeayahSeibu + adaSaudaraSeayahSeibu + adaSaudariSeayahSeibu).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianCucuLaki = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSaudaraSeayahSeibu = "Mahjub"
                                bagianSaudariSeayahSeibu = "Mahjub"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }
                        }
                    }
                }else if((!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    bagianIbunyaAyah = "Mahjub"
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || adaSaudaraSeayahSeibu >= 1 || adaSaudariSeayahSeibu >= 1 || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1)){
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        bagianSaudariSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            bagianCucuPerempuan = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
                                }
                            }
                        }else if((cucuPerempuan == 0 && cucuLaki >= 1) || (cucuPerempuan >= 1 && cucuLaki >= 1)){
                            bagianCucuPerempuan = "Ashobah"
                            bagianCucuLaki = "Ashobah"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyahnyaAyah = "1/6 → 4/27"
                                    hartaAyahnyaAyah = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyahnyaAyah = "1/6 → 2/15"
                                    hartaAyahnyaAyah = harta * 2/15
                                }
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
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 7/12
                                }
                            }else {
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 13/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 5/12
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta * 2/12
                                }
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
                                bagianSuami = "1/2 → 1/2"
                                bagianIstri = "1/4 → 1/4"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 1/4
                                    bagianAyah = "1/6 → 3/4"
                                    hartaAyah = harta * 3/4
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(1.0/2.0)
                                    bagianAyah = "1/6 → 1/2"
                                    hartaAyah = harta * 1/2
                                }
                            }else {
                                bagianSuami = "1/4 → 1/2"
                                bagianIstri = "1/4 → 1/4"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 2/8
                                    bagianAyah = "1/6 → 3/8"
                                    hartaAyah = harta * 3/8
                                    bagianIbunyaIbu = "1/6 → 3/8"
                                    hartaIbunyaIbu = harta * 3/8
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(2.0/4.0)
                                    bagianAyah = "1/6 → 1/4"
                                    hartaAyah = harta * 1/4
                                    bagianIbunyaIbu = "1/6 → 1/4"
                                    hartaIbunyaIbu = harta * 1/4
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 4/32
                                    bagianAyah = "1/6 → 7/32"
                                    hartaAyah = harta * 7/32
                                    bagianCucuPerempuan = "1/2 → 21/32"
                                    hartaCucuPerempuan = harta * 21/32
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(4.0/16.0)
                                    bagianAyah = "1/6 → 3/16"
                                    hartaAyah = harta * 3/16
                                    bagianCucuPerempuan = "1/2 → 9/16"
                                    hartaCucuPerempuan = harta * 9/16
                                }
                            }else {
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianIbunyaIbu = "1/6 → 7/40"
                                    hartaIbunyaIbu = harta * 7/40
                                    bagianCucuPerempuan = "1/2 → 21/40"
                                    hartaCucuPerempuan = harta * 21/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                    bagianCucuPerempuan = "1/2 → 6/13"
                                    hartaCucuPerempuan = harta * 6/13
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianCucuPerempuan = "2/3 → 28/40"
                                    hartaCucuPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianCucuPerempuan = "2/3 → 8/13"
                                    hartaCucuPerempuan = harta * 8/13
                                }
                            }else {
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianCucuPerempuan = "1/2 → 16/27"
                                    hartaCucuPerempuan = harta * 16/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianCucuPerempuan = "2/3 → 8/15"
                                    hartaCucuPerempuan = harta * 8/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 17/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 7/12
                                }
                            }else {
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 13/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }
                        }else{
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if (!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }else {
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIstri - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaSuami - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        }
        else if (anakPerempuan == 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuPerempuan = "Mahjub"
                            bagianCucuLaki = "Mahjub"
                            bagianAnakLaki = "Ashobah"
                            bagianAnakPerempuan = "Ashobah"
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }else{
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaIbunyaIbu
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaIbunyaIbu
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }

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
                                bagianSuami = "1/4 → 1/4"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 4/32
                                    bagianAyah = "1/6 → 7/32"
                                    hartaAyah = harta * 7/32
                                    bagianAnakPerempuan = "1/2 → 21/32"
                                    hartaAnakPerempuan = harta * 21/32
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(4.0/16.0)
                                    bagianAyah = "1/6 → 3/16"
                                    hartaAyah = harta * 3/16
                                    bagianAnakPerempuan = "1/2 → 9/16"
                                    hartaAnakPerempuan = harta * 9/16
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAnakPerempuan = harta * 21/40
                                    bagianIbunyaIbu = "1/6 → 7/40"
                                    hartaIbunyaIbu = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                }

                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAnakPerempuan = harta * 21/40
                                    bagianCucuPerempuan = "1/6 → 7/40"
                                    hartaCucuPerempuan = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuPerempuan = "1/6 → 2/13"
                                    hartaCucuPerempuan = harta * 2/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    hartaAnakPerempuan = harta * 12/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianCucuPerempuan = "1/6 → 4/27"
                                    hartaCucuPerempuan = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    hartaAnakPerempuan = harta * 6/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianCucuPerempuan = "1/6 → 2/15"
                                    hartaCucuPerempuan = harta * 2/15
                                }

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/12
                                }
                            }else{
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianCucuLaki = "Ashobah"
                                }
                            }
                        }else{
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianAnakPerempuan = "1/2 → 6/12"
                                    hartaAnakPerempuan = harta * 6/12
                                    sisaHarta = harta - hartaAnakPerempuan - hartaSuami - hartaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }else{
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaAyah - hartaIbunyaIbu
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianIbunyaIbu = "1/6 → 2/13"
                                    hartaIbunyaIbu = harta * 2/13
                                }
                            }
                        }
                    }
                }
            }
            //batas terbaruuuuu ke 10 23:58
        }
        else if(anakPerempuan > 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        bagianSaudariSeayahSeibu = "Mahjub"
                        bagianSaudaraSeayahSeibu = "Mahjub"
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuPerempuan = "Mahjub"
                            bagianCucuLaki = "Mahjub"
                            bagianAnakLaki = "Ashobah"
                            bagianAnakPerempuan = "Ashobah"
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }else{
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbunyaIbu = "1/6 → 4/24"
                                    hartaIbunyaIbu = harta * 4/24
                                    sisaHarta = harta - hartaIbu - hartaIstri - hartaIbunyaIbu
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbunyaIbu = "1/6 → 2/12"
                                    hartaIbunyaIbu = harta * 2/12
                                    sisaHarta = harta - hartaIbu - hartaSuami - hartaIbunyaIbu
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }

                            }

                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                bagianCucuPerempuan = "Mahjub"
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianAnakPerempuan = "2/3 → 28/40"
                                    hartaAnakPerempuan = harta * 28/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 3/13"
                                    hartaAyah = harta * 3/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                }

                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                    bagianCucuLaki = "Ashobah"
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                    bagianCucuLaki = "Ashobah"
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                    bagianCucuLaki = "Ashobah"
                                }
                            }
                        }else{
                            bagianCucuLaki = "Ashobah"
                            bagianCucuPerempuan = "Ashobah"
                            if(!adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianAnakPerempuan = "2/3 → 16/24"
                                    hartaAnakPerempuan = harta * 16/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaIstri - hartaAyah
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianAnakPerempuan = "2/3 → 8/13"
                                    hartaAnakPerempuan = harta * 8/13
                                }
                            }else{
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianIbunyaIbu = "1/6 → 4/27"
                                    hartaIbunyaIbu = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianIbunyaIbu = "1/6 → 2/15"
                                    hartaIbunyaIbu = harta * 2/15
                                }
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
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 13/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianAnakLaki = "Ashobah"
                                    hartaAnakLaki = harta * 5/12
                                }
                            }
                        }
                    }
                }
                //garis baru 1 31/05/2024
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if (cucuLaki == 0 && cucuPerempuan == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/2 → 1/2"
                                bagianIstri = "1/4 → 1/4"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 2/8
                                    bagianAyah = "1/6 → 3/8"
                                    hartaAyah = harta * 3/8
                                    bagianIbu = "1/6 → 3/8"
                                    hartaIbu = harta * 3/8
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(2.0/4.0)
                                    bagianAyah = "1/6 → 1/4"
                                    hartaAyah = harta * 1/4
                                    bagianIbu = "1/6 → 1/4"
                                    hartaIbu = harta * 1/4
                                }
                            }
                        }else if(cucuPerempuan == 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                    bagianCucuPerempuan = "1/2 → 21/40"
                                    hartaCucuPerempuan = harta * 21/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                    bagianCucuPerempuan = "1/2 → 6/13"
                                    hartaCucuPerempuan = harta * 6/13
                                }
                            }
                        }else if (cucuPerempuan > 1 && cucuLaki == 0){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                    bagianCucuPerempuan = "2/3 → 16/27"
                                    hartaCucuPerempuan = harta * 16/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                    bagianCucuPerempuan = "2/3 → 8/15"
                                    hartaCucuPerempuan = harta * 8/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 13/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 5/12
                                }
                            }
                        }else{
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaSuami
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }
            }
            //garis baru 3 15:32 01/06/2024
        }
        else if (anakPerempuan == 1) {
            if (anakLaki >= 1) {
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuLaki >=1  && cucuPerempuan == 0) || (cucuLaki == 0 && cucuPerempuan >= 1) || (cucuLaki >= 1 && cucuPerempuan >= 1)){
                            bagianCucuLaki = "Mahjub"
                            bagianCucuPerempuan = "Mahjub"
                            if (!adaIbunyaIbu || adaIbunyaIbu){
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
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
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 1/8"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 5/40
                                    bagianAnakPerempuan = "1/2 → 21/40"
                                    hartaAnakPerempuan = harta * 21/40
                                    bagianAyah = "1/6 → 7/40"
                                    hartaAyah = harta * 7/40
                                    bagianIbu = "1/6 → 7/40"
                                    hartaIbu = harta * 7/40
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                }
                            }
                        }else if(cucuPerempuan >= 1 && cucuLaki == 0){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "1/2 → 12/27"
                                    hartaAnakPerempuan = harta * 12/27
                                    bagianCucuPerempuan = "1/6 → 4/27"
                                    hartaCucuPerempuan = harta * 4/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "1/2 → 6/15"
                                    hartaAnakPerempuan = harta * 6/15
                                    bagianCucuPerempuan = "1/6 → 2/15"
                                    hartaCucuPerempuan = harta * 2/15
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                }
                            }
                        }else if(cucuPerempuan == 0 && cucuLaki >= 1){
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianCucuLaki = "Ashobah"
                                    hartaCucuLaki = harta * 1/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianCucuLaki = "Ashobah"
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/13"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAnakPerempuan = "1/2 → 12/24"
                                    hartaAnakPerempuan = harta * 12/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAnakPerempuan - hartaAyah - hartaIbu - hartaIstri
                                    hartaCucuLaki = sisaHarta * (cucuLaki + cucuLaki) / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()
                                    hartaCucuPerempuan = (sisaHarta * (cucuPerempuan / (cucuLaki + cucuLaki + cucuPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/13.0)
                                    bagianAnakPerempuan = "1/2 → 6/13"
                                    hartaAnakPerempuan = harta * 6/13
                                    bagianAyah = "1/6 → 2/13"
                                    hartaAyah = harta * 2/13
                                    bagianIbu = "1/6 → 2/13"
                                    hartaIbu = harta * 2/13
                                }
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
                                bagianAnakLaki = "Ashobah"
                                bagianAnakPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/12"
                                bagianIstri = "1/8 → 3/24"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/24
                                    bagianAyah = "1/6 → 4/24"
                                    hartaAyah = harta * 4/24
                                    bagianIbu = "1/6 → 4/24"
                                    hartaIbu = harta * 4/24
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaIstri
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/12.0)
                                    bagianAyah = "1/6 → 2/12"
                                    hartaAyah = harta * 2/12
                                    bagianIbu = "1/6 → 2/12"
                                    hartaIbu = harta * 2/12
                                    sisaHarta = harta - hartaAyah - hartaIbu - hartaSuami
                                    hartaAnakLaki = sisaHarta * (anakLaki + anakLaki) / (anakLaki + anakLaki + anakPerempuan).toDouble()
                                    hartaAnakPerempuan = (sisaHarta * (anakPerempuan / (anakLaki + anakLaki + anakPerempuan).toDouble()))
                                }
                            }
                        }
                    }
                }
                //garis baru 4 01/05/2024 paling baruuuu
            }else if(anakLaki == 0){
                if((!adaIbunyaAyah && !adaAyahnyaAyah) || (adaIbunyaAyah && !adaAyahnyaAyah) || (!adaIbunyaAyah && adaAyahnyaAyah) || (adaIbunyaAyah && adaAyahnyaAyah)){
                    if ((adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu == 0) || (adaSaudaraSeayahSeibu == 0 && adaSaudariSeayahSeibu >= 1) || (adaSaudaraSeayahSeibu >= 1 && adaSaudariSeayahSeibu >=1 )){
                        if ((cucuLaki == 0 && cucuPerempuan == 0) || (cucuPerempuan >= 1 && cucuLaki == 0)){
                            bagianCucuPerempuan = "Mahjub"
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                }
                            }
                        }else{
                            if(!adaIbunyaIbu || adaIbunyaIbu){
                                bagianCucuLaki = "Ashobah"
                                bagianCucuPerempuan = "Ashobah"
                                bagianSuami = "1/4 → 3/15"
                                bagianIstri = "1/8 → 3/27"
                                if (jenisKelaminPewaris.equals("Laki-Laki")){
                                    hartaIstri = harta * 3/27
                                    bagianAnakPerempuan = "2/3 → 16/27"
                                    hartaAnakPerempuan = harta * 16/27
                                    bagianAyah = "1/6 → 4/27"
                                    hartaAyah = harta * 4/27
                                    bagianIbu = "1/6 → 4/27"
                                    hartaIbu = harta * 4/27
                                }else if(jenisKelaminPewaris.equals("Perempuan")){
                                    hartaSuami = harta*(3.0/15.0)
                                    bagianAnakPerempuan = "2/3 → 8/15"
                                    hartaAnakPerempuan = harta * 8/15
                                    bagianAyah = "1/6 → 2/15"
                                    hartaAyah = harta * 2/15
                                    bagianIbu = "1/6 → 2/15"
                                    hartaIbu = harta * 2/15
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //Batas Suci terakhir 11 15:37 03/06/2024

    return AdaSuamiAtauIstriLebihDariNol(
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