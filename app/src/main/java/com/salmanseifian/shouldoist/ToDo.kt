package com.salmanseifian.shouldoist

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todos")
data class ToDo constructor(
    val title: String,
    val description: String,
    val priority: Priority,
    val createdAt: Date,
    val dueDate: Date
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}

enum class Priority(val value: Int) {
    MAJOR(1), NORMAL(0), MINOR(-1)
}