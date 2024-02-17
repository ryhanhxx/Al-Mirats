package com.ch.al_mirats.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardBinding
import com.ch.al_mirats.model.Feature

class HomeAdapter(private val onItemClick: (Feature) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeItemListViewHolder>() {

    private var items: MutableList<Feature> = mutableListOf()

    fun setItems(items: List<Feature>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Feature>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemListViewHolder {
        val binding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class HomeItemListViewHolder(
        private val binding: ItemCardBinding,
        private val onItemClick: (Feature) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Feature) {
            binding.ivImg.load(item.imgUrl)
            binding.tvName.text = item.name
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}