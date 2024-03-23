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
                videoUrl = "pYy69BYUIxw",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_KALKULATOR.png",
                desc = context.getString(R.string.desc_tutorial_1)
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_2),
                videoUrl = "VtkLKuOr9UM",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FEEDBACK.png",
                desc = context.getString(R.string.desc_tutorial_2)
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_3),
                videoUrl = "ZJQK_A5zueM",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI.png",
                desc = context.getString(R.string.desc_tutorial_3),
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_4),
                videoUrl = "6hyScFfqzGY",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_ABOUT.png",
                desc = context.getString(R.string.desc_tutorial_4),
            ),
            Tutorial(
                title = context.getString(R.string.title_tutorial_5),
                videoUrl = "NatpNvZptJM",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_FATWA.png",
                desc = context.getString(R.string.desc_tutorial_5),
            ),
        )
    }
}