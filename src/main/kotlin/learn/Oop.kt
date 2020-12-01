package learn

abstract class Person {
    init {
        this.work()
    }

    abstract fun work()
}

class Programmer : Person() {
    override fun work() {
        println("写代码")
    }
}

class Doctor : Person() {
    override fun work() {
        println("看病人")
    }
}

object Oop {
    init {
        println("initial method called.")
    }

    fun funny(x: String) {
        println("the x value is $x @ $this")
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

fun main() {
    val doc = Doctor()
    val pro = Programmer()

    val perList: ArrayList<Person> = arrayListOf(doc, pro)
    perList.forEach(::println)

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map(String::toUpperCase)
            .forEach(::println)

    ('A'..'Z' step 1).forEach { print("$it ") }

    val op1 = Oop
    val op2 = Oop

    op1.funny("op1")

    op2.funny("op2")
    val con = Constructors(1)
}