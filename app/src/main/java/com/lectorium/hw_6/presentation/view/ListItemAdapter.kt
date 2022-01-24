package com.lectorium.hw_6.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.lectorium.hw_6.R
import com.lectorium.hw_6.databinding.RecyclerViewItemBinding
import com.lectorium.hw_6.domain.models.Item

class ListItemAdapter : ListAdapter<Item, ListItemAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(private val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {

            val url = GlideUrl(
                item.url, LazyHeaders.Builder()
                    .addHeader("User-Agent", "Android")
                    .build()
            )

            with(binding) {
                Glide.with(imgItem.context)
                    .load(url)
                    .error(R.drawable.ic_not_image)
                    .into(imgItem)

                titleItem.text = item.title
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
