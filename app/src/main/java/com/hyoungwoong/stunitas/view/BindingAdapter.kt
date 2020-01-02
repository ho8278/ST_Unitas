package com.hyoungwoong.stunitas.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyoungwoong.stunitas.data.model.Image

@BindingAdapter("app:bind_items")
fun setListItem(view: RecyclerView, item: List<Image>?) {
    if (item == null)
        return
    (view.adapter as ImageAdapter).setList(item)
}