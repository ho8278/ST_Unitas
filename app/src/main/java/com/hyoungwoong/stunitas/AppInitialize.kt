package com.hyoungwoong.stunitas

import android.app.Application
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.data.DataSourceImpl

class AppInitialize:Application(){
    var dataSource:DataSource = DataSourceImpl()

    override fun onCreate() {
        super.onCreate()
    }
}