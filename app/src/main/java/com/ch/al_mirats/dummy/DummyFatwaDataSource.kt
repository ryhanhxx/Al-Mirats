package com.ch.al_mirats.dummy

import android.content.Context
import com.ch.al_mirats.R
import com.ch.al_mirats.model.Fatwa

interface DummyFatwaDataSource {
    fun getFatwaData(context: Context): List<Fatwa>
}

class DummyFatwaDataSourceImpl() : DummyFatwaDataSource {
    override fun getFatwaData(context: Context): List<Fatwa> {

        return mutableListOf(
            Fatwa(
                title = context.getString(R.string.title_fatwa_1),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view.jpg",
                desc = context.getString(R.string.desc_fatwa_1),
                videoUrl = "V4CYS6xzQug",
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_2),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view1.jpg",
                desc = context.getString(R.string.desc_fatwa_2),
                videoUrl = "nX_koEe7sjM",
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_3),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view2.jpg",
                desc = context.getString(R.string.desc_fatwa_3),
                videoUrl = "68f9RPNybow",
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_4),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view3.jpg",
                desc = context.getString(R.string.desc_fatwa_4),
                videoUrl = "Kq2gT8BfIL8",
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_5),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view4.jpg",
                desc = context.getString(R.string.desc_fatwa_5),
                videoUrl = "eqaTemfO2hM",
            ),
            Fatwa(
                title = context.getString(R.string.title_fatwa_6),
                imgUrl = "https://raw.githubusercontent.com/HaibraielRabbany/img_asset/main/img_view5.jpg",
                desc = context.getString(R.string.desc_fatwa_6),
                videoUrl = "WYy2ZBv_ZIs",
            ),
        )
    }
}