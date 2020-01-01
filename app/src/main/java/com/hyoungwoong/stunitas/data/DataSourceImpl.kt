package com.hyoungwoong.stunitas.data

import com.hyoungwoong.stunitas.data.remote.ImageSearchAPI
import com.hyoungwoong.stunitas.data.remote.ImageSearchImpl

class DataSourceImpl:DataSource{
    val kakaoAPi:ImageSearchAPI = ImageSearchImpl.api

}