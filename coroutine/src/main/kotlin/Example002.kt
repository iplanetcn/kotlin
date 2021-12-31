import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    launch {
        println("This is executed before the first delay")
        stallForTime()
        println("This is executed after the first delay")
        println("This is executed before the Second delay")
        stallForTime()
        println("This is executed after the Second delay")
    }
    println("This is executed immediately")
}
