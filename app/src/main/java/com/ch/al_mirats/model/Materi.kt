package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Materi(
    val id: String = UUID.randomUUID().toString(),
    val imgUrl: String,
    val title: String,
    val heading: String,
    val desc: String,
    val subHeading: String,
    val subDesc: String,
    val source: String,
) : Parcelable