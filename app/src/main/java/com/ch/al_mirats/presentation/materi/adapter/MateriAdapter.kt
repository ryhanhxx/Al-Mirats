package com.ch.al_mirats.presentation.materi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardBinding
import com.ch.al_mirats.databinding.ItemCardMateriBinding
import com.ch.al_mirats.model.Feature
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.home.adapter.HomeAdapter

class MateriAdapter (private val onItemClick: (Materi) -> Unit) :
    RecyclerView.Adapter<MateriAdapter.MateriItemListViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriItemListViewHolder {
        val binding =
            ItemCardMateriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MateriItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MateriItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MateriItemListViewHolder(
        private val binding: ItemCardMateriBinding,
        private val onItemClick: (Materi) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Materi) {
            binding.tvName.text = item.name
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}