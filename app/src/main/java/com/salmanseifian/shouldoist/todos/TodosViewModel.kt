package com.salmanseifian.shouldoist.todos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.salmanseifian.shouldoist.ToDo
import com.salmanseifian.shouldoist.TodoRepository
import com.salmanseifian.shouldoist.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class TodosViewModel(private val todosRepository: TodoRepository) : BaseViewModel() {

    val todos: LiveData<List<ToDo>>
        get() = _todos

    private var _todos = MutableLiveData<List<ToDo>>()

    init {
        getTodos()
    }

    fun getTodos() {
        todosRepository.getAllTodos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _todos.value = it
            }
            .addTo(compositeDisposable)
    }
}