package com.hyoungwoong.stunitas.data.remote

import com.hyoungwoong.stunitas.R
import com.hyoungwoong.stunitas.data.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageSearchAPI {
    @Headers("Authorization: KakaoAK 76426a954d7a20f3d98f0191c5c908ad")
    @GET("image")
    fun getImages(@Query("query")
                  query:String,
                  @Query("page")
                  page:Int,
                  @Query("size")
                  size:Int,
                  @Query("sort")
                  sort:String ): Single<ImageResponse>
}