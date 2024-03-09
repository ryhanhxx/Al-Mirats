package com.ch.al_mirats.presentation.fatwa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ch.al_mirats.databinding.ItemCardGridBinding
import com.ch.al_mirats.databinding.ItemCardListBinding
import com.ch.al_mirats.model.Fatwa
import com.ch.al_mirats.presentation.fatwa.viewholder.GridFatwaViewHolder
import com.ch.al_mirats.presentation.fatwa.viewholder.LinearFatwaViewHolder
import com.ch.al_mirats.utils.AdapterLayoutMode
import com.ch.al_mirats.utils.ViewHolderFatwaBinder

class FatwaAdapter(
    var adapterLayoutMode: AdapterLayoutMode,
    private val onClickListener: (Fatwa) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Fatwa>() {
        override fun areItemsTheSame(oldItem: Fatwa, newItem: Fatwa): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fatwa, newItem: Fatwa): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterLayoutMode.GRID.ordinal -> (GridFatwaViewHolder(
                binding = ItemCardGridBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), onClickListener
            ))

            else -> {
                LinearFatwaViewHolder(
                    binding = ItemCardListBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickListener
                )
            }
        }
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderFatwaBinder<Fatwa>).bind(dataDiffer.currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return adapterLayoutMode.ordinal
    }

    fun setItems(data: List<Fatwa>) {
        dataDiffer.submitList(data)
    }

    fun refreshList() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }
}