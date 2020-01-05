package com.hyoungwoong.stunitas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.view.MainViewModel

class ViewModelFactory(private val repository:DataSource): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
                isAssignableFrom(MainViewModel::class.java)-> MainViewModel(repository)
                else -> throw IllegalArgumentException("Unknown ViewModel class!")
            }
        } as T

}