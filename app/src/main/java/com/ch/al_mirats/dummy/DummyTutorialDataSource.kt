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
                title = context.getString(R.string.title_tutorial_1),
                videoUrl = "V_01X45d91g",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_KALKULATOR.png",
                desc = context.getString(R.string.desc_tutorial_1)
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_2),
                videoUrl = "uty6VhU-gJ0",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FEEDBACK.png",
                desc = context.getString(R.string.desc_tutorial_2)
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_3),
                videoUrl = "xAOfOCcG2gA",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI.png",
                desc = context.getString(R.string.desc_tutorial_3),
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_4),
                videoUrl = "og7U5sDLJqY",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_ABOUT.png",
                desc = context.getString(R.string.desc_tutorial_4),
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_5),
                videoUrl = "9q0Dt2NGDDs",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FATWA.png",
                desc = context.getString(R.string.desc_tutorial_5),
            ),
        )
    }
}