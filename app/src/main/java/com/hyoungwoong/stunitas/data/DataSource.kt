package com.hyoungwoong.stunitas.data

import com.hyoungwoong.stunitas.data.model.ImageResponse
import io.reactivex.Single

interface DataSource{
    fun getImages(query:String,page:Int = 1,size:Int = 20,sort:String = "accuracy"): Single<ImageResponse>
}