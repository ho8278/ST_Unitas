package com.hyoungwoong.stunitas.data.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("collection")
                 val collection:String,
                 @SerializedName("thumbnail_url")
                 val thumbnailURL:String,
                 @SerializedName("image_url")
                 val imageURL:String,
                 @SerializedName("width")
                 val width:Int,
                 @SerializedName("height")
                 val height:Int,
                 val bitmap:Bitmap? = null)