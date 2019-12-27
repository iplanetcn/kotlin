package io2019

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract


@UseExperimental(ExperimentalContracts::class)
fun String?.notNull(): Boolean {
    contract {
        returns(true) implies (this@notNull != null)
    }
    return this != null
}

fun printLength(s: String) {
    if (s.notNull()) {
        println(s.length)
    }
}