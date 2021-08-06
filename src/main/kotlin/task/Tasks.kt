package task

import java.lang.Thread.sleep

/**
 * Tasks
 *
 * @author john
 * @since 2021-07-19
 */

val task1: () -> String = {
    sleep(2000)
    "Hello".also { println("task1 finished: $it") }
}

val task2: () -> String = {
    sleep(2000)
    "World".also { println("task2 finished: $it") }
}

val task3: (String, String) -> String = { p1, p2 ->
    sleep(2000)
    "$p1 $p2".also { println("task3 finished: $it") }
}