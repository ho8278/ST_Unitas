package com.hyoungwoong.stunitas.view

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class TopMarginDecorator(val offset:Int): RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        if(itemPosition != 0)
            outRect.set(outRect.left,outRect.top+offset,outRect.right,outRect.bottom)
    }
}