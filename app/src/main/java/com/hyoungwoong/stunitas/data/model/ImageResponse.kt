package com.hyoungwoong.stunitas.data.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(@SerializedName("meta")
                         val meta:Meta,
                         @SerializedName("document")
                         val images:List<Image>)

data class Meta(@SerializedName("total_count")
                val totalCount:Int,
                @SerializedName("pageable_count")
                val pageableCount:Int,
                @SerializedName("is_end")
                val isEnd:Boolean)