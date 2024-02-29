package com.ch.al_mirats.presentation.materi

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ch.al_mirats.model.Materi

class MateriViewModel(private val extras: Bundle?) : ViewModel() {
    val product = extras?.getParcelable<Materi>(MateriActivity.MATERIAL_KEY)

}