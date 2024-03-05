package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Tutorial

interface DummyTutorialDataSource {
    fun getTutorialData(context: Context): List<Tutorial>
}

class DummyTutorialDataSourceImpl() : DummyTutorialDataSource {
    override fun getTutorialData(context: Context): List<Tutorial> {

        return mutableListOf(
            Tutorial(
                title = "Panduan Penggunaan Kalkulator",
                imgUrl = "",
                descOne = "1",
                descTwo = "",
                descThree = ""
            ),
            Tutorial(
                title = "Panduan Pengunaan Umpan Balik",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FEEDBACK.png",
                descOne = context.getString(R.string.desc_tutorial_2_1),
                descTwo = context.getString(R.string.desc_tutorial_2_2),
                descThree = context.getString(R.string.desc_tutorial_2_3)
            ),
            Tutorial(
                title = "Panduan Cara Membaca Materi",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI.png",
                descOne = context.getString(R.string.desc_tutorial_3_1),
                descTwo = context.getString(R.string.desc_tutorial_3_2),
                descThree = context.getString(R.string.desc_tutorial_3_3)
            ),
            Tutorial(
                title = "Panduan Cara Membaca Tentang Aplikasi",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_ABOUT.png",
                descOne = context.getString(R.string.desc_tutorial_4_1),
                descTwo = context.getString(R.string.desc_tutorial_4_2),
                descThree = context.getString(R.string.desc_tutorial_4_3)
            ),
            )
    }
}