package com.example.parcial1samael.ui.sculpture.sculpturelist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1samael.data.models.SculptureModel
import com.example.parcial1samael.data.sculptures

class SculptureRecyclerViewAdapter (
    private val clickListener: (SculptureModel) -> Unit
): RecyclerView.Adapter<SculptureRecyclerViewHolder>() {
    private val sculptures = ArrayList<SculptureModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SculptureRecyclerViewHolder {
        val binding = SculptureItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SculptureRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sculptures.size
    }

    override fun onBindViewHolder(holder: SculptureRecyclerViewHolder, position: Int) {
        val sculpture = sculptures[position]
        holder.bind(sculpture, clickListener)
    }

    fun setData(sculpturesList: List<SculptureModel>) {
        sculptures.clear()
        sculptures.addAll(sculpturesList)
    }
}