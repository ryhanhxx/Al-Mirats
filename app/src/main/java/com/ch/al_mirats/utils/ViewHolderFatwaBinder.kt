package com.ch.al_mirats.utils

import com.ch.al_mirats.model.Fatwa

interface ViewHolderFatwaBinder<T> {
    fun bind(item: Fatwa)
}