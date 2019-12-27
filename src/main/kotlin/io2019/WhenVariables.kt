package io2019

fun capturingWhenBefore(year: Int) {
    val response = calculateROI(year)
    when (response) {
        50 -> println("Too long")
        5 -> println("Bargain")
        else -> println("Can't handle $response")
    }
}

fun calculateROI(year: Int) : Int {
    return Math.random().toInt() + year
}