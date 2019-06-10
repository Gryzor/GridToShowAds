package com.neutobo.recyclerviewwithads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neutobo.recyclerviewwithads.model.Thing


class ThingAdapterWithAds : ListAdapter<Thing, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    internal val viewTypeGreen = 0
    internal val viewTypePurple = 1
    internal val viewTypeAd = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            viewTypeGreen -> ColoredViewHolder(inflater.inflate(R.layout.green_item_layout, parent, false))
            viewTypePurple -> ColoredViewHolder(inflater.inflate(R.layout.purple_item_layout, parent, false))
            viewTypeAd -> AdViewHolder(inflater.inflate(R.layout.ad_item_layout, parent, false))
            else -> throw IllegalArgumentException("You must supply a valid type for this adapter")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    internal abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(data: Thing)
    }

    internal class ColoredViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.item_text)

        override fun bind(data: Thing) {
            title.text = data.title
        }
    }

    internal class AdViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(data: Thing) {
            //fetch an ad? :)
        }
    }

    internal class DiffUtilCallback : DiffUtil.ItemCallback<Thing>() {
        override fun areItemsTheSame(oldItem: Thing, newItem: Thing): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Thing, newItem: Thing): Boolean {
            return oldItem.title == newItem.title && oldItem.type == oldItem.type
        }
    }
}