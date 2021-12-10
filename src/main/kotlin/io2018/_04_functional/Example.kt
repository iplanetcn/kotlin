package io2018._04_functional

fun main() {
    val numbers = (1..100).toList()

    val list = mutableListOf<String>()
    for (it in numbers) {
        if (it % 16 == 0) {
            list.add("0x" + it.toString(16))
        }
    }

    val anotherList = numbers
            .filter { it -> it % 16 == 0 }
            .also { print(it) }
            .map { it -> "0x" + it.toString(16) }

    println(list)
    println(anotherList)

    repeat(6, {
        println(list)
    })
}

inline fun repeat(times: Int, body: (Int) -> Unit) {
    for (index in 0 until times) {
        body(index)
    }
}