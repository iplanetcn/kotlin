package io2018._05_coroutines

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) = coroutines(100_000)

fun threads(n: Int) {
    val threads = List(n) {
        thread {
            Thread.sleep(1000L)
            println(it)
        }
    }

    threads.forEach { it.join() }
}

fun coroutines(n: Int) = runBlocking {
    val jobs = List(100_000) {
        async {
            delay(1000L)
            println(it)
        }
    }

    jobs.forEach { it.join() }
}