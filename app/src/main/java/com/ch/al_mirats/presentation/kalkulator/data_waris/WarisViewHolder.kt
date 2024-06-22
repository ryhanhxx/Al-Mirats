package com.ch.al_mirats.presentation.kalkulator.data_waris

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ch.al_mirats.R

class WarisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ahliWarisTextView: TextView = itemView.findViewById(R.id.txt_ahliWaris)
    val bagianTextView: TextView = itemView.findViewById(R.id.txt_bagian)
    val jumlahOrangTextView: TextView = itemView.findViewById(R.id.txt_jumlahOrang)
    val hartaPerOrangTextView: TextView = itemView.findViewById(R.id.txt_hartaPerOrang)
    val hartaBagian: TextView = itemView.findViewById(R.id.txt_hartaBagian)
}