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
                title = "Belum Bayar Hutang Puasa Lalu Meninggal Dunia, Ahli Waris Mengqadha Atau Bagaimana?",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_materi_1),
                videoUrl = "V4CYS6xzQug",
            ),
            Fatwa(
                title = "Belum Diaqiqah, Apakah Diaqiqahkan Dari Harta Waris Ayahnya Atau Si Anak Mengaqiqah Sendiri?",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_materi_1),
                videoUrl = "nX_koEe7sjM"
            ),
            Fatwa(
                title = "Bolehkah Bagian Waris Laki Laki Dan Wanita Disamakan?",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_materi_1),
                videoUrl = "68f9RPNybow"
            ),
            Fatwa(
                title = "Bagaimana Jika Harta Waris Lebih Banyak Bagi Yang Lebih Berjasa Kepada Almarhum?",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/img_asset/main/IMG_MATERI_3.jpg",
                desc = context.getString(R.string.desc_materi_1),
                videoUrl = "Kq2gT8BfIL8"
            ),
        )
    }
}