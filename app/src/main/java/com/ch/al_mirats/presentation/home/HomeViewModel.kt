package com.ch.al_mirats.presentation.home

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.materi.MateriActivity

class HomeViewModel(private val extras: Bundle?) : ViewModel() {
    val product = extras?.getParcelable<Materi>(MateriActivity.MATERIAL_KEY)
}