package com.ch.al_mirats.presentation.fatwa

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ch.al_mirats.model.Fatwa

class FatwaViewModel(private val extras: Bundle?) : ViewModel() {
    val fatwa = extras?.getParcelable<Fatwa>(FatwaActivity.FATWA_KEY)
}