package com.hyoungwoong.stunitas.util

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.debounce(milli:Long) = MediatorLiveData<T>().also { data ->
    val source = this
    val handler = Handler(Looper.getMainLooper())

    val runnable = Runnable {
        data.value = source.value
    }

    data.addSource(source) {
        handler.removeCallbacks(runnable)
        handler.postDelayed(runnable, milli)
    }
}