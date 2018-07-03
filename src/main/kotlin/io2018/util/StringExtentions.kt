package io2018.util

fun String.firstWord(separator: String = " "): String {
    val index = indexOf(separator)
    return if (index < 0) this else substring(0, index)
}

fun addSum(a: Int, b: Int): Int {
    return a + b
}