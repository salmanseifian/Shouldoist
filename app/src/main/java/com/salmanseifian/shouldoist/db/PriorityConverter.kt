package com.salmanseifian.shouldoist.db

import androidx.room.TypeConverter
import com.salmanseifian.shouldoist.Priority

class PriorityConverter {

    @TypeConverter
    fun fromPriority(value: Priority): Int {
        return value.ordinal
    }

    @TypeConverter
    fun toPriority(value: Int): Priority {
        return when (value) {
            1 -> Priority.MAJOR
            -1 -> Priority.MINOR
            else -> Priority.NORMAL
        }
    }

}