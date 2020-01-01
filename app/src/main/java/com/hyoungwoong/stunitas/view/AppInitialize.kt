package com.hyoungwoong.stunitas.view

import android.app.Application
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.data.DataSourceImpl

class AppInitialize:Application(){
    companion object{
        lateinit var dataSource:DataSource
    }
    override fun onCreate() {
        super.onCreate()
        dataSource = DataSourceImpl()
    }
}