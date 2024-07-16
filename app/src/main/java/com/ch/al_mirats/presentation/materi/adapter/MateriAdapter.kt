package com.ch.al_mirats.presentation.materi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ch.al_mirats.databinding.ItemCardGridBinding
import com.ch.al_mirats.databinding.ItemCardListBinding
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.materi.viewholder.GridMateriViewHolder
import com.ch.al_mirats.presentation.materi.viewholder.LinearMateriViewHolder
import com.ch.al_mirats.utils.AdapterLayoutMode
import com.ch.al_mirats.utils.ViewHolderBinder

class MateriAdapter(
    var adapterLayoutMode: AdapterLayoutMode,
    private val onClickListener: (Materi) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Materi>() {
        override fun areItemsTheSame(oldItem: Materi, newItem: Materi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Materi, newItem: Materi): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterLayoutMode.GRID.ordinal -> (GridMateriViewHolder(
                binding = ItemCardGridBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), onClickListener
            ))

            else -> {
                LinearMateriViewHolder(
                    binding = ItemCardListBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickListener
                )
            }
        }
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderBinder<Materi>).bind(dataDiffer.currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return adapterLayoutMode.ordinal
    }

    fun setItems(data: List<Materi>) {
        dataDiffer.submitList(data)
    }

    fun refreshList() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }
}