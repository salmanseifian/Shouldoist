package com.salmanseifian.shouldoist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salmanseifian.shouldoist.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao
}