package learn

fun main() {
    val list = intArrayOf(1, 2, 3, 4, 5)
    greeting(*list, greeting = "Hello,World!")
    greeting(greeting = "Hello,World!")
}

fun greeting(vararg args: Int, greeting: String) {
    args.forEach(::println)
    println(greeting)
}