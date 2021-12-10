package io2018._03_functions

fun String.firstWord(separator: String = " "): String {
    val index = indexOf(separator)
    return if (index < 0) this else substring(0, index)
}

fun main() {
    println("John Lee".firstWord())
}