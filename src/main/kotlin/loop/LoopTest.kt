package loop


/**
 * LoopTest
 *
 * @author john
 * @since 2021-07-14
 */

fun main() {
    println("*********************")
    run loop@{
        (1..10).forEach {
            if (it == 5) {
                return@loop
            }
            println("$it")
        }
        println("xxxxxxxxxxxxxx")
    }

    println("----------------------")


}