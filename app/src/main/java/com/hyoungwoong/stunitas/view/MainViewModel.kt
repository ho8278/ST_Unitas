package com.hyoungwoong.stunitas.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.data.model.Image

class MainViewModel(private val repository:DataSource): ViewModel(){
    val isLoading = MutableLiveData<Boolean>()
    val percentage = MutableLiveData<Int>()
    val imageList = MutableLiveData<MutableList<Image>>()
}