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
                name = "Apa Itu Ahli Waris",
            ),
            Materi(
                name = "Waris Menurut Pandangan Islam",
            ),
            Materi(
                name = "Rumus Pembagian Waris",
            ),
            Materi(
                name = "Panduan",
            )
        )
    }
}