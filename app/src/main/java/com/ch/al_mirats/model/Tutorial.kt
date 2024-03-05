package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tutorial (
    val title: String,
    val imgUrl: String,
    val descOne: String,
    val descTwo: String,
    val descThree: String,
): Parcelable