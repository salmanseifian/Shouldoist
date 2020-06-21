package com.salmanseifian.shouldoist.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel() : ViewModel() {
    internal val compositeDisposable = CompositeDisposable()


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}