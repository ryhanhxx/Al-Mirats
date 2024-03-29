package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Materi

interface DummyMateriDataSource {
    fun getMateriData(context:Context): List<Materi>

    fun searchMusicByTitle(context: Context, query: String): List<Materi>
}

class DummyMateriDataSourceImpl() : DummyMateriDataSource {
    override fun searchMusicByTitle(context: Context, query: String): List<Materi> {
        return getMateriData(context).filter { it.title.contains(query, ignoreCase = true) }
    }

    override fun getMateriData(context:Context): List<Materi> {
        return mutableListOf(
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                title = context.getString(R.string.title_materi_1),
                heading = context.getString(R.string.heading_materi_1),
                desc = context.getString(R.string.desc_materi_1),
                subHeading =  context.getString(R.string.subheading_materi_1),
                subDesc = context.getString(R.string.subdesc_materi_1),
                source = "https://keltunggulwulung.malangkota.go.id/2022/11/02/pengertian-dan-istilah-dalam-hukum-waris/"
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                title = context.getString(R.string.title_materi_2),
                heading = context.getString(R.string.heading_materi_2),
                desc =  context.getString(R.string.desc_materi_2),
                subHeading = context.getString(R.string.subheading_materi_2),
                subDesc = context.getString(R.string.subdesc_materi_2),
                source = "https://alukhuwah.com/2022/06/24/faraidh-ayat-al-quran-seputar-warisan/"
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_2.jpg",
                title = context.getString(R.string.title_materi_3),
                heading = context.getString(R.string.heading_materi_3),
                desc =  context.getString(R.string.desc_materi_3),
                subHeading = context.getString(R.string.subheading_materi_3),
                subDesc = context.getString(R.string.subdesc_materi_3),
                source = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/img_kalkulator.webp",
                title = context.getString(R.string.title_materi_4),
                heading = context.getString(R.string.heading_materi_4),
                desc = context.getString(R.string.desc_materi_4),
                subHeading = context.getString(R.string.subheading_materi_4),
                subDesc = context.getString(R.string.subdesc_materi_4),
                source = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_1.jpg",
                title = context.getString(R.string.title_materi_5),
                heading = context.getString(R.string.heading_materi_5),
                desc = context.getString(R.string.desc_materi_5),
                subHeading = context.getString(R.string.subheading_materi_5),
                subDesc = context.getString(R.string.subdesc_materi_5),
                source = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                title = context.getString(R.string.title_materi_6),
                heading = context.getString(R.string.heading_materi_6),
                desc = context.getString(R.string.desc_materi_6),
                subHeading = context.getString(R.string.subheading_materi_6),
                subDesc = context.getString(R.string.subdesc_materi_6),
                source = ""
            ),
            Materi(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_2.jpg",
                title = "Bagian Ahli Waris Utama",
                heading = "",
                desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                subHeading = "",
                subDesc = "",
                source = ""
            )
        )
    }

}