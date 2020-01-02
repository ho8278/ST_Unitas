package com.hyoungwoong.stunitas.data

import com.hyoungwoong.stunitas.data.model.ImageResponse
import com.hyoungwoong.stunitas.data.remote.ImageSearchAPI
import com.hyoungwoong.stunitas.data.remote.ImageSearchImpl
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DataSourceImpl:DataSource{
    val kakaoAPi:ImageSearchAPI = ImageSearchImpl.api


    override fun getImages(query: String, page: Int, size: Int, sort: String): Single<ImageResponse> {
        return kakaoAPi.getImages(query,page,size,sort)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}