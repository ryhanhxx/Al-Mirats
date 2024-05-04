package com.ch.al_mirats.presentation.fatwa.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardGridBinding
import com.ch.al_mirats.databinding.ItemCardListBinding
import com.ch.al_mirats.model.Fatwa
import com.ch.al_mirats.utils.ViewHolderFatwaBinder

class LinearFatwaViewHolder(
    private val binding: ItemCardListBinding,
    private val onItemClick: (Fatwa) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderFatwaBinder<Fatwa> {
    override fun bind(item: Fatwa) {
        binding.ivImg.load(item.imgUrl) {
            crossfade(true)
        }
        binding.tvTitle.text = item.title
        binding.tvDesc.text = item.desc
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}

class GridFatwaViewHolder(
    private val binding: ItemCardGridBinding,
    private val onItemClick: (Fatwa) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderFatwaBinder<Fatwa> {
    override fun bind(item: Fatwa) {
        binding.ivImg.load(item.imgUrl) {
            crossfade(true)
        }
        binding.tvTitle.text = item.title
        binding.tvDesc.text = item.desc
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}