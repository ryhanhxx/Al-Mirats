package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.model.Tutorial

interface DummyTutorialDataSource {
    fun getTutorialData(context: Context): List<Tutorial>
}

class DummyTutorialDataSourceImpl() : DummyTutorialDataSource {
    override fun getTutorialData(context: Context): List<Tutorial> {

        return mutableListOf(
            Tutorial(
                title = "Panduan Penggunaan Kalkulator",
                imgUrl = ""
            ),
            Tutorial(
                title = "Panduan Pengunaan Umpan Balik",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FEEDBACK.png"
            ),
            Tutorial(
                title = "Panduan Cara Membaca Materi",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI.png"
            ),
            Tutorial(
                title = "Panduan Cara Membaca Tentang Aplikasi",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_ABOUT.png"
            ),

            )
    }
}