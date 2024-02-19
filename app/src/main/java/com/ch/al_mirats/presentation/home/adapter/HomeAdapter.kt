package com.ch.al_mirats.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardBinding
import com.ch.al_mirats.databinding.ItemCardGridBinding
import com.ch.al_mirats.model.Feature
import com.ch.al_mirats.model.Materi

class HomeAdapter(private val onItemClick: (Materi) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeItemListViewHolder>() {

    private var items: MutableList<Materi> = mutableListOf()

    fun setItems(items: List<Materi>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Materi>) {
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
        private val onItemClick: (Materi) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Materi) {
            binding.ivImg.load(item.imgUrl)
            binding.tvName.text = item.name
            binding.tvDesc.text = item.desc
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}