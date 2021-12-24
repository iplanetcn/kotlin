package learn

import kotlinx.coroutines.*

fun main() {
//    exampleBlocking()
//    exampleBlockingDispatcher()
//    exampleLaunchGlobal()
//    exampleLaunchGlobalWaiting()
//    exampleLaunchCoroutineScope()
//    exampleAsyncAwait()
    exampleWithContext()
}

suspend fun printlnDelayed(message: String) {
    delay(1000)
    println(message)
}
suspend fun calculateHardThings(startNum: Int):Int {
    delay(1000)
    return startNum * 10
}

fun exampleBlocking() = runBlocking {
    println("one")
    printlnDelayed("two")
    println("three")
}

fun exampleBlockingDispatcher() {
    runBlocking(Dispatchers.Default) {
        println("one - from thread ${Thread.currentThread().name}")
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
}

fun exampleLaunchGlobal() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
    GlobalScope.launch {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
    delay(3000)
}

fun exampleLaunchGlobalWaiting() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
    val job = GlobalScope.launch {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
    job.join()
}

fun exampleLaunchCoroutineScope() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
    launch(Dispatchers.Default) {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
}


fun exampleAsyncAwait() = runBlocking {
    val startTime = System.currentTimeMillis()

    val deferred1 = async { calculateHardThings(10) }
    val deferred2 = async { calculateHardThings(20) }
    val deferred3 = async { calculateHardThings(30) }

    val sum = deferred1.await() + deferred2.await() + deferred3.await()
    println("async/await result = $sum ")

    val endTime = System.currentTimeMillis()

    println("Time taken: ${endTime - startTime}")
}

fun exampleWithContext() = runBlocking {
    val startTime = System.currentTimeMillis()

    val result1 = withContext(Dispatchers.Default) { calculateHardThings(10) }
    val result2 = withContext(Dispatchers.Default) { calculateHardThings(20) }
    val result3 = withContext(Dispatchers.Default) { calculateHardThings(30) }

    val sum = result1 + result2 + result3
    println("async/await result = $sum ")

    val endTime = System.currentTimeMillis()

    println("Time taken: ${endTime - startTime}")
}