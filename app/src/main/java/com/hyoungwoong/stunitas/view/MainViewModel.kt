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
    val imageList = MutableLiveData<MutableList<Image>>()
    val compositeDisposable = CompositeDisposable()

    fun getImage() {
        if (searchText.value?.isEmpty() ?: true)
            return
        isLoading.value = true
        compositeDisposable.add(
            repository.getImages(searchText.value ?: "")
                .subscribe({
                    imageList.value?.addAll(it.images)
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