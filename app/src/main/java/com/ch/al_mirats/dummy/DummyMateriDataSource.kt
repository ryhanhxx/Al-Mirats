package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Materi

interface DummyMateriDataSource {
    fun getMateriData(context:Context): List<Materi>

}

class DummyMateriDataSourceImpl() : DummyMateriDataSource {
    override fun getMateriData(context:Context): List<Materi> {
        return mutableListOf(
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi.jpg",
                title = context.getString(R.string.title_materi_1),
                heading = context.getString(R.string.heading_materi_1),
                desc = context.getString(R.string.desc_materi_1),
                subHeading =  context.getString(R.string.subheading_materi_1),
                subDesc = context.getString(R.string.subdesc_materi_1),
                imgUrl2 = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi1.jpg",
                title = context.getString(R.string.title_materi_2),
                heading = context.getString(R.string.heading_materi_2),
                desc =  context.getString(R.string.desc_materi_2),
                subHeading = context.getString(R.string.subheading_materi_2),
                subDesc = context.getString(R.string.subdesc_materi_2),
                imgUrl2 = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi2.jpg",
                title = context.getString(R.string.title_materi_3),
                heading = context.getString(R.string.heading_materi_3),
                desc =  context.getString(R.string.desc_materi_3),
                subHeading = context.getString(R.string.subheading_materi_3),
                subDesc = context.getString(R.string.subdesc_materi_3),
                imgUrl2 = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi3.jpg",
                title = context.getString(R.string.title_materi_4),
                heading = context.getString(R.string.heading_materi_4),
                desc = context.getString(R.string.desc_materi_4),
                subHeading = context.getString(R.string.subheading_materi_4),
                subDesc = context.getString(R.string.subdesc_materi_4),
                imgUrl2 = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_materi_utama.png"
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi4.jpg",
                title = context.getString(R.string.title_materi_5),
                heading = context.getString(R.string.heading_materi_5),
                desc = context.getString(R.string.desc_materi_5),
                subHeading = context.getString(R.string.subheading_materi_5),
                subDesc = context.getString(R.string.subdesc_materi_5),
                imgUrl2 = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi5.jpg",
                title = context.getString(R.string.title_materi_6),
                heading = context.getString(R.string.heading_materi_6),
                desc = context.getString(R.string.desc_materi_6),
                subHeading = context.getString(R.string.subheading_materi_6),
                subDesc = context.getString(R.string.subdesc_materi_6),
                imgUrl2 = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_materi6.jpg",
                title = context.getString(R.string.title_materi_7),
                heading = context.getString(R.string.heading_materi_7),
                desc =  context.getString(R.string.desc_materi_7),
                subHeading = "",
                subDesc = "",
                imgUrl2 = ""
            )
        )
    }
}