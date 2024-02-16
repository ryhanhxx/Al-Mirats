package com.ch.al_mirats.dummy

import com.ch.al_mirats.model.Feature

interface DummyHomeDataSource {
    fun getHomeData(): List<Feature>
}

class DummyHomeDataSourceImpl() : DummyHomeDataSource {
    override fun getHomeData(): List<Feature> {
        return mutableListOf(
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_burger_icon.webp",
                name = "Kalkulator Waris",
                desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_mie_icon.webp",
                name = "Al-Quran",
                desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_snack_icon.webp",
                name = "Tajweed",
                desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_drink_icon.webp",
                name = "Panduan",
                desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            )
        )
    }
}