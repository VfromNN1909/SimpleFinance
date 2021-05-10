package ru.vlasoff.simplefinance.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.vlasoff.simplefinance.domain.entities.recycler_items.Item

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Item)
}