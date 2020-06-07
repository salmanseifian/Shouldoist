package com.salmanseifian.shouldoist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salmanseifian.shouldoist.ToDo
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TodoDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toDo: ToDo)

    @Query("select * from todos")
    fun getTodos(): Flowable<List<ToDo>>
}