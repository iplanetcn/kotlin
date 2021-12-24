package io2018._01_bean

data class FullName(val first: String, val last: String)

fun parseName(name: String): FullName {
    val space = name.indexOf(' ')
    return FullName(name.substring(0, space), name.substring(space + 1))
}


fun main() {
    val name = parseName("John Lee")
    val first = name.first
    val last = name.last

    println("$first $last")
    if (name != parseName("John Lee")) {
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        println("Equals doesn't work :(")
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }
}