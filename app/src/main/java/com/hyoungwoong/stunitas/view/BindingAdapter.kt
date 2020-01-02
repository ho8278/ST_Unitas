package com.hyoungwoong.stunitas.view

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.github.lzyzsd.circleprogress.CircleProgress
import com.hyoungwoong.stunitas.data.model.Image

@BindingAdapter("app:bind_items")
fun setListItem(view:RecyclerView, item:List<Image>?){

}

@BindingAdapter("app:progress")
fun setProgress(view:CircleProgress, progress:Int?){
    view.progress=progress ?: 0
}