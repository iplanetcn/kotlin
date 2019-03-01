package com.phenix

import sun.util.calendar.BaseCalendar
import java.util.*


fun main(args: Array<String>) {
    val p = Human("John", 31, "Android Engineer.")
    println(p.toString())
}


class Human {
    private var name: String = ""
    private var age: Int = 0
    private var message = "Hi"

    constructor(name: String, age: Int, message: String) {
        this.name = name
        this.age = age
        this.message = message
    }

    override fun toString(): String {
        return "Human(name='$name', age=$age, message='$message')"
    }

}


interface Greeting {
    fun sayHello(name: String)
}

class Person {
    var greeting: Greeting? = null

    fun doing() {
        greeting?.sayHello("John")
    }

    fun set(greeting: Greeting) {
        this.greeting = greeting
    }
}

abstract class Base {
    public fun run() {
        var person = Person()
        person.set(object : Greeting {
            override fun sayHello(name: String) {
                this@Base.sayHello(name)
            }
        })
    }

    protected abstract fun sayHello(name: String)
}