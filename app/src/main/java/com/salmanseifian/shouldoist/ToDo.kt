package com.salmanseifian.shouldoist

import androidx.room.Entity
import java.util.*

@Entity(tableName = "todos")
data class ToDo constructor(
    val title: String,
    val description: String,
    val priority: PRIORITY,
    val createdAt: Date,
    val dueDate: Date
) {

}

enum class PRIORITY {
    HIGH, LOW
}