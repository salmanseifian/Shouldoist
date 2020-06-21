package com.salmanseifian.shouldoist.todos

import com.salmanseifian.shouldoist.TodoRepository
import com.salmanseifian.shouldoist.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class TodosViewModel(private val todosRepository: TodoRepository) : BaseViewModel() {

    init {
        getTodos()
    }

     fun getTodos() {
        todosRepository.getAllTodos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                it.forEach {
                    Timber.d(it.toString())
                }
            }
            .addTo(compositeDisposable)
    }
}