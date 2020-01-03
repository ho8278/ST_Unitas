package com.hyoungwoong.stunitas.view

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hyoungwoong.stunitas.data.model.Image
import com.hyoungwoong.stunitas.databinding.ItemImageBinding

class ImageAdapter(val glide:RequestManager, val phoneWidth:Int):ListAdapter<Image,ImageAdapter.ImageViewHolder>(object: DiffUtil.ItemCallback<Image>(){
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.imageURL == newItem.imageURL

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.imageURL == newItem.imageURL
}){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context))
        return ImageViewHolder(binding)
    }

    fun setList(list:List<Image>){
        submitList(list.toMutableList())
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ImageViewHolder(val binding:ItemImageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            val item = getItem(position)
            val ratio = phoneWidth/item.width.toFloat()
            val resizeHeight = (item.height * ratio).toInt()
            glide.load(item.imageURL)
                .override(phoneWidth,resizeHeight)
                .into(binding.ivImage)

        }
    }
}