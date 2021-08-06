package hash

/**
 * HashTest
 *
 * @author john
 * @since 2021-07-15
 */
class HashTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val p1 = Person("John", 33)
            val p2 = Person("John", 33)

            println("${p1.hashCode()}")
            println("${p2.hashCode()}")
            println("$p1")
            println("$p2")

            println("${p1.hashCode() == p2.hashCode()}")
        }
    }
}