package com.ch.al_mirats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Harta(
//    val id: String = UUID.randomUUID().toString(),
    val harta: Double = 0.0,
    val hutang: Double = 0.0,
    val wasiat: Double = 0.0,
    val jenazah: Double = 0.0,
    val gender: Boolean = true
) : Parcelable