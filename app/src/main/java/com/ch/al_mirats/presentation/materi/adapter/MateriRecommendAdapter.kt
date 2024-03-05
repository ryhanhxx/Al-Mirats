package com.ch.al_mirats.presentation.materi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.al_mirats.databinding.ItemCardMateriRecommendBinding
import com.ch.al_mirats.model.Materi

class MateriRecommendAdapter(private val onItemClick: (Materi) -> Unit) :
    RecyclerView.Adapter<MateriRecommendAdapter.MateriRecommendItemListViewHolder>() {

    private var items: MutableList<Materi> = mutableListOf()

    fun setItems(items: List<Materi>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriRecommendItemListViewHolder {
        val binding =
            ItemCardMateriRecommendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MateriRecommendItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MateriRecommendItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MateriRecommendItemListViewHolder(
        private val binding: ItemCardMateriRecommendBinding,
        private val onItemClick: (Materi) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Materi) {
            binding.ivImg.load(item.imgUrl)
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.desc
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}