package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Materi

interface DummyTopMateriDataSource {
    fun getTopMateriData(context: Context): List<Materi>
}

class DummyTopMateriDataSourceImpl() : DummyTopMateriDataSource {
    override fun getTopMateriData(context: Context): List<Materi> {

        return mutableListOf(
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi.jpg",
                title = context.getString(R.string.title_materi_1),
                heading = context.getString(R.string.heading_materi_1),
                desc = context.getString(R.string.desc_materi_1),
                imgUrl2 = "",
                source = context.getString(R.string.source_materi_1)
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi2.jpg",
                title = context.getString(R.string.title_materi_8),
                heading = context.getString(R.string.heading_materi_8),
                desc = context.getString(R.string.desc_materi_8),
                imgUrl2 = "",
                source = context.getString(R.string.source_materi_7)
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi5.jpg",
                title = context.getString(R.string.title_materi_6),
                heading = context.getString(R.string.heading_materi_6),
                desc = context.getString(R.string.desc_materi_6),
                imgUrl2 = "",
                source = context.getString(R.string.source_materi_6)
            ),
        )
    }
}