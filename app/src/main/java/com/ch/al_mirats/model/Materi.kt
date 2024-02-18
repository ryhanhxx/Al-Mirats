package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Materi(
    val id: String = UUID.randomUUID().toString(),
    val imgUrl: String,
    val name: String,
    val desc: String
) : Parcelable