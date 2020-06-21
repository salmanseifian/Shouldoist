package com.salmanseifian.shouldoist

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todos")
data class ToDo constructor(
    var title: String?,
    var description: String?,
    var createdAt: Date?,
    var dueDate: Date?,
    var priority: Priority = Priority.NORMAL
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}

enum class Priority(val value: Int) {
    MAJOR(1), NORMAL(0), MINOR(-1)
}