package com.hyoungwoong.stunitas.data.remote

import com.hyoungwoong.stunitas.R
import com.hyoungwoong.stunitas.data.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageSearchAPI {
    @Headers("Authorization: KakaoAK ${R.string.api_key}")
    @GET("image")
    fun getImages(@Query("query")
                  query:String,
                  @Query("page")
                  page:Int = 1,
                  @Query("size")
                  size:Int = 20,
                  @Query("sort")
                  sort:String = "accuracy"): Single<ImageResponse>
}