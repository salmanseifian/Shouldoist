package com.salmanseifian.shouldoist

import io.reactivex.Completable
import io.reactivex.Flowable

interface TodoRepository {

    fun addTodo(toDo: ToDo): Completable

    fun getAllTodos(): Flowable<List<ToDo>>

}