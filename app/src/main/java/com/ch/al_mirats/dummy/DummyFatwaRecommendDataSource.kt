package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Fatwa

interface DummyFatwaRecommendDataSource {
    fun getFatwaRecommendData(context: Context): List<Fatwa>
}

class DummyFatwaRecommendDataSourceImpl() : DummyFatwaRecommendDataSource {
    override fun getFatwaRecommendData(context: Context): List<Fatwa> {

        return mutableListOf(
            Fatwa(
                title = context.getString(R.string.title_fatwa_1),
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_fatwa_1),
                videoUrl = "V4CYS6xzQug",
                source = ""
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_6),
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_fatwa_6),
                videoUrl = "WYy2ZBv_ZIs",
                source = ""
            ),
        )
    }
}