package com.ch.al_mirats.presentation.tutorial

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ch.al_mirats.model.Tutorial

class TutorialViewModel(private val extras: Bundle?) : ViewModel() {
    val tutorial = extras?.getParcelable<Tutorial>(TutorialDetailActivity.TUTORIAL_KEY)
}