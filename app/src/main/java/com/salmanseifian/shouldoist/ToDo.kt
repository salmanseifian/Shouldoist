package com.salmanseifian.shouldoist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class ToDo constructor(
    val title: String,
    val description: String,
    val priority: Priority,
    val createdAt: String,
    val dueDate: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}

enum class Priority(val value: Int) {
    MAJOR(1), NORMAL(0), MINOR(-1)
}