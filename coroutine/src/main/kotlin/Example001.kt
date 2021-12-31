private suspend fun main() {
    println("This is executed before the delay")
    stallForTime()
    println("This is executed after the delay")
}