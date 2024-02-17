package com.ch.al_mirats.dummy

import com.ch.al_mirats.model.Feature
import com.ch.al_mirats.model.Materi

interface DummyMateriDataSource {
    fun getMateriData(): List<Materi>
}

class DummyMateriDataSourceImpl() : DummyMateriDataSource {
    override fun getMateriData(): List<Materi> {
        return mutableListOf(
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                name = "Apa Itu Ahli Waris",
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                name = "Waris Menurut Pandangan Islam",
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                name = "Rumus Pembagian Waris",
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                name = "Panduan",
            )
        )
    }
}