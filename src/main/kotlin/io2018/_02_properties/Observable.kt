package io2018._02_properties

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

var observeMe by Delegates.observable("a") { p, old, new ->
    println("${p.name} goes $old->$new")
}

var p1 by Prop("initial")
var p2 by Prop("initial")
var p3 by Prop("initial")

class Prop(var field: String) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): String {
        println("You read me")
        return field
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: String) {
        println("You write me")
        field = v
    }
}

fun main() {
    println("\n\nObservable property:")
    observeMe = "bb"
    observeMe = "ccc"
    observeMe = "dddd"

    p1 = "john"
}