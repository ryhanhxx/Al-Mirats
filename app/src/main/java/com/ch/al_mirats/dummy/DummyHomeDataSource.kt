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
                name = "Burger",
                desc = "Burger"
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_mie_icon.webp",
                name = "Mie",
                desc = "Mie"
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_snack_icon.webp",
                name = "Snack",
                desc = "Snack"
            ),
            Feature(
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/FlavourFairApp/master/app/src/main/res/drawable/img_drink_icon.webp",
                name = "Drink",
                desc = "Drink"
            )
        )
    }
}