package com.salmanseifian.shouldoist

import java.text.SimpleDateFormat
import java.util.*

fun Date.toFormattedString(): String{
    val dateFormat= "MMM d, yyyy  k:mm"
    val simpleDateFormat = SimpleDateFormat(dateFormat)
    return simpleDateFormat.format(this)
}