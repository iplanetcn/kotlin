import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


private fun main() = runBlocking {
    launch {
        val channel = randomPercentages(10, 200)
        delay(1000)
        channel.consumeEach { println(it) }
        println("That's all folks!")
    }
    println("... and we're off!")
}


private fun CoroutineScope.randomPercentages(count: Int, delay: Long) = produce {
    for (i in 0 until count) {
        delay(delay)
        send(Random.nextInt(1, 100))
    }
}