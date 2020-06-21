package com.salmanseifian.shouldoist.add

import com.salmanseifian.shouldoist.ToDo
import com.salmanseifian.shouldoist.TodoRepository
import com.salmanseifian.shouldoist.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat

class AddTodoViewModel constructor(private val todoRepository: TodoRepository) : BaseViewModel() {

    private var todo: ToDo = ToDo(null, null, null, null)

    fun addTitle(title: String) {
        todo.title = title
    }

    fun addDescription(description: String) {
        todo.description = description
    }

    fun addDate(dateString: String) {
        val date = SimpleDateFormat("yyyy/MM/dd").parse(dateString)
        todo.dueDate = date
        todo.createdAt = date
    }


    fun addTodo() {
        todoRepository.addTodo(todo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .addTo(compositeDisposable)
    }

}