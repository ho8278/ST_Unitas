package com.hyoungwoong.stunitas.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.data.model.Image
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: DataSource) : ViewModel() {
    val searchText = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>(false)
    val isEmpty = MutableLiveData<Boolean>(false)
    val imageList = MutableLiveData<MutableList<Image>>()
    val compositeDisposable = CompositeDisposable()

    private val _imageList = mutableListOf<Image>()
    private var exSearchText = ""
    fun getImage() {
        if (searchText.value?.isEmpty() ?: true)
            return
        isLoading.value = true
        compositeDisposable.add(
            repository.getImages(searchText.value ?: "")
                .subscribe({
                    if(exSearchText.isEmpty()){
                        exSearchText = searchText.value ?: ""
                    }
                    if(exSearchText == searchText.value)
                        _imageList.addAll(it.images)
                    else{
                        _imageList.clear()
                        _imageList.addAll(it.images)
                    }
                    imageList.value = _imageList
                    isLoading.value = false
                    if(_imageList.isEmpty())
                        isEmpty.value = true
                    else
                        isEmpty.value = false
                    exSearchText = searchText.value ?: ""
                }, {
                    TODO("오류 메세지에 맞춰 알림 띄우기")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}