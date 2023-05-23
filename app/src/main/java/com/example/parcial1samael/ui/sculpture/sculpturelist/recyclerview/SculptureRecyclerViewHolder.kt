package com.example.parcial1samael.ui.sculpture.sculpturelist.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1samael.data.models.SculptureModel

class SculptureRecyclerViewHolder(private val binding: SculptureItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(sculpture: SculptureModel, clickListener: (SculptureModel) -> Unit){
        binding.titleTextView. = sculpture.name
        binding.materialTextView.text = sculpture.material

        binding.sculptureItemCardView.setOnClickListener {
            clickListener(sculpture)
        }
    }
}