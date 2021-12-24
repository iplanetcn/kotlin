package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

fun main() {
    GlobalScope.launch {
        delay(1000)
        print("World")
    }
    println("Hello, "
    )
}