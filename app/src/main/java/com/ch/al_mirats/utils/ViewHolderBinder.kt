package com.ch.al_mirats.utils

import com.ch.al_mirats.model.Materi

interface ViewHolderBinder<T> {
    fun bind(item: Materi)
}