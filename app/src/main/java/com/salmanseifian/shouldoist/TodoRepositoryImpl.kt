package com.salmanseifian.shouldoist

import com.salmanseifian.shouldoist.db.TodoDao
import io.reactivex.Completable
import io.reactivex.Flowable

class TodoRepositoryImpl(private val todoDao: TodoDao) : TodoRepository {

    override fun addTodo(toDo: ToDo): Completable {
        return Completable.fromAction { todoDao.insert(toDo) }
    }

    override fun getAllTodos(): Flowable<List<ToDo>> {
        return todoDao.getTodos()
    }
}