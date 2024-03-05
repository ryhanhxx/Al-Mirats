package com.ch.al_mirats.presentation.tutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ch.al_mirats.databinding.ItemTutorialCardBinding
import com.ch.al_mirats.model.Tutorial

class TutorialAdapter(private val onItemClick: (Tutorial) -> Unit) :
    RecyclerView.Adapter<TutorialAdapter.TutorialItemListViewHolder>() {

    private var items: MutableList<Tutorial> = mutableListOf()

    fun submitData(items: List<Tutorial>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialItemListViewHolder {
        val binding =
            ItemTutorialCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TutorialItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: TutorialItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class TutorialItemListViewHolder(
        private val binding: ItemTutorialCardBinding,
        private val onItemClick: (Tutorial) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tutorial) {
            binding.tvName.text = item.title
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}