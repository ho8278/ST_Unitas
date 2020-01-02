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
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hyoungwoong.stunitas.data.model.Image
import com.hyoungwoong.stunitas.databinding.ItemEmptyBinding
import com.hyoungwoong.stunitas.databinding.ItemImageBinding

class ImageAdapter(val phoneWidth:Int,val phoneHeight:Int):ListAdapter<Image,ImageAdapter.ViewHolder>(object: DiffUtil.ItemCallback<Image>(){
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.imageURL == newItem.imageURL

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.imageURL == newItem.imageURL
}){
    private val LIST_EMPTY = 0
    private val LIST_NON_EMPTY = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        when(viewType){
            LIST_EMPTY->{
                val binding = ItemEmptyBinding.inflate(LayoutInflater.from(parent.context))
                EmptyViewHolder(binding)
            }
            LIST_NON_EMPTY->{
                val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context))
                ImageViewHolder(binding)
            }
            else -> throw Throwable("Unknwon ViewType!")
        }

    fun setList(list:List<Image>){
        submitList(list)
    }

    override fun getItemViewType(position: Int): Int {
        if(itemCount == 0)
            return LIST_EMPTY
        else
            return LIST_NON_EMPTY
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class EmptyViewHolder(val binding:ItemEmptyBinding):ViewHolder(binding.root){
        override fun bind(position: Int) {

        }
    }

    inner class ImageViewHolder(val binding:ItemImageBinding):ViewHolder(binding.root){
        override fun bind(position: Int) {
            Glide.with(binding.ivImage)
                .load(getItem(position).imageURL)
                .override(phoneWidth,phoneHeight)
                .into(binding.ivImage)

        }
    }

    abstract class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        abstract fun bind(position:Int)
    }
}