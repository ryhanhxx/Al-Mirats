package com.ch.al_mirats.presentation.materi.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardBinding
import com.ch.al_mirats.databinding.ItemCardGridBinding
import com.ch.al_mirats.databinding.ItemMateriCardBinding
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.utils.ViewHolderBinder

class LinearMateriViewHolder(
    private val binding: ItemMateriCardBinding,
    private val onItemClick: (Materi) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Materi> {
    override fun bind(item: Materi) {
        binding.ivImg.load(item.imgUrl){
            crossfade(true)
        }
        binding.tvTitle.text = item.title
        binding.tvDesc.text = item.desc
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}

class GridMateriViewHolder(
    private val binding: ItemCardGridBinding,
    private val onItemClick: (Materi) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Materi> {
    override fun bind(item: Materi) {
        binding.ivImg.load(item.imgUrl){
            crossfade(true)
        }
        binding.tvTitle.text = item.title
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}