package com.hyoungwoong.stunitas.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyoungwoong.stunitas.data.DataSource
import com.hyoungwoong.stunitas.data.model.Image
import com.hyoungwoong.stunitas.util.CustomException
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: DataSource) : ViewModel() {
    val searchText = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>(false)
    val isEmpty = MutableLiveData<Boolean>(false)
    val imageList = MutableLiveData<MutableList<Image>>()
    val compositeDisposable = CompositeDisposable()
    var refreshCount = 1
    val exception = MutableLiveData<String>()

    private var noMoreRefresh = false
    private val _imageList = mutableListOf<Image>()

    fun getImage() {
        if (searchText.value?.isEmpty() ?: true)
            return
        isLoading.value = true
        refreshCount = 1
        noMoreRefresh = false
        compositeDisposable.add(
            repository.getImages(searchText.value ?: "")
                .subscribe({
                    if (it.meta.isEnd)
                        noMoreRefresh = true
                    _imageList.clear()
                    _imageList.addAll(it.images)
                    imageList.value = _imageList
                    isEmpty.value = _imageList.isEmpty()
                    isLoading.value = false
                }, {
                    exception.value = CustomException.mapException(it)
                    isLoading.value = false
                })
        )
    }

    fun refresh() {
        if (noMoreRefresh) {
            return
        }
        isLoading.value = true
        refreshCount++
        compositeDisposable.add(
            repository.getImages(searchText.value ?: "", refreshCount)
                .subscribe({
                    if (it.meta.isEnd)
                        noMoreRefresh = true
                    _imageList.addAll(it.images)
                    imageList.value = _imageList
                    isLoading.value = false
                }, {
                    exception.value = CustomException.mapException(it)
                    isLoading.value = false
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}