package learn

class Tree{
    val branch: String = "three branches"
    val leaf: String = "many leaves"
}

fun main() {
    val list = intArrayOf(1, 2, 3, 4, 5)
    greeting(*list, greeting = "Hello,World!")
    greeting(greeting = "Hello,World!")
    val tree = Tree()
    println(tree.branch)
    println(tree.leaf)
}

fun greeting(vararg args: Int, greeting: String) {
    args.forEach(::println)
    println(greeting)
}