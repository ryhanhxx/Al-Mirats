package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Fatwa (
    val id: String = UUID.randomUUID().toString(),
    val imgUrl: String,
    val videoUrl: String,
    val title: String,
    val source: String,
    val desc: String
): Parcelable