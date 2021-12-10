package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

suspend fun main() = coroutineScope {
    for (i in 0 until 10) {
        launch {
            delay(1000L)
            print("$i ")
        }
    }
}
