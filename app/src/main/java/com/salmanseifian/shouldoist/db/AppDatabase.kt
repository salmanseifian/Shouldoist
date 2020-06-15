package com.salmanseifian.shouldoist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.salmanseifian.shouldoist.ToDo

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(PriorityConverter::class, DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao
}