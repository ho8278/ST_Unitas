package com.hyoungwoong.stunitas.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyoungwoong.stunitas.data.model.Image
import com.hyoungwoong.stunitas.databinding.ItemEmptyBinding
import com.hyoungwoong.stunitas.databinding.ItemImageBinding

class ImageAdapter:RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    private val LIST_EMPTY = 0
    private val LIST_NON_EMPTY = 1
    val imageList = mutableListOf<Image>()
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
            else -> throw IllegalArgumentException("Unknwon ViewType!")
        }


    override fun getItemCount(): Int = imageList.size

    override fun getItemViewType(position: Int): Int {
        if(imageList.size == 1 && imageList[position].thumbnailURL.isEmpty())
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
            Glide.with(binding.root)
                .load(imageList[position].thumbnailURL)
                .into(binding.ivImage)
        }
    }

    abstract class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        abstract fun bind(position:Int)
    }
}