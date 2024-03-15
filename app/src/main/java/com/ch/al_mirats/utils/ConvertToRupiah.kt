package com.ch.al_mirats.utils

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class ConvertToRupiah {
    fun convertToRupiahFormat(angka: Double): String {
        val localeID = Locale("id", "ID")
        val currencyFormat = NumberFormat.getCurrencyInstance(localeID)

        currencyFormat.currency = Currency.getInstance("IDR")
        currencyFormat.maximumFractionDigits = 0

        return "Rp. " + currencyFormat.format(angka).substring(2)
    }
}