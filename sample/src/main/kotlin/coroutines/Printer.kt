package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Printer
 *
 * @author john
 * @since 2022-04-15
 */
fun main() {
    runBlocking {
        launch {
            delay(200)
            print("World")
        }
        print("Hello,")
    }

    println()

    "Hello,World".toCharArray()
        .forEach {
            runBlocking {
                launch {
                    delay(300)
                    print(it)
                }
            }
        }
}