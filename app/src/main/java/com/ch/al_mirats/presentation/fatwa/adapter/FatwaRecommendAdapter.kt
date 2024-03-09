package com.ch.al_mirats.presentation.fatwa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardRecommendBinding
import com.ch.al_mirats.model.Fatwa

class FatwaRecommendAdapter(private val onItemClick: (Fatwa) -> Unit) :
    RecyclerView.Adapter<FatwaRecommendAdapter.FatwaRecommendItemListViewHolder>() {

    private var items: MutableList<Fatwa> = mutableListOf()

    fun setItems(items: List<Fatwa>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FatwaRecommendItemListViewHolder {
        val binding =
            ItemCardRecommendBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FatwaRecommendItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: FatwaRecommendItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class FatwaRecommendItemListViewHolder(
        private val binding: ItemCardRecommendBinding,
        private val onItemClick: (Fatwa) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Fatwa) {
            binding.ivImg.load(item.imgUrl)
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.desc
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}