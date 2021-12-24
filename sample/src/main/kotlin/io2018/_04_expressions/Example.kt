package io2018._04_expressions

class Example(val a: Int, val b: String?, val c: Boolean)

fun main() {
    val ex = Example(1, null, true)

    with(ex) {
        println("a = $a, b = $b, c = $c")
    }

    val map = mapOf(
            "k1" to 1,
            "k2" to 2,
            "k3" to 3
    )

    map.forEach { key, value -> println("$key -> $value") }
    for ((key, value) in map.entries) {
        println("$key -> $value")
    }

    val numbers = (1..100).toList()

    val list = numbers.filter { it % 16 == 0 }
            .also { println(it) }
            .map { "0x" + it.toString(16) }
    println(list)

    var s: String
    if (System.currentTimeMillis() % 2L == 0L) {
        println("Yay!")
        s = "Luck!"
    } else {
        s = "Not this time"
    }
    println(s)

    println(test(ex))
}


fun test(e: Example): String {
    return when (e.a) {
        1, 3, 5 -> "Odd"
        in setOf(2, 4, 6) -> "Even"
        else -> "Too big"
    }
}

fun test2(str: String?): String? {
    println(str?.length)

    if (str != null) {
        str?.forEach(::println)
    }

    str ?: return null
    if (str==null) return null
    if (str==null) throw RuntimeException("Unexpected null!")
    if (str==null) error("Unexpected null")

    return str
}