package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tutorial (
    val title: String,
    val videoUrl: String,
    val imgUrl: String,
    val desc: String,
): Parcelable