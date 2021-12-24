package learn

const val string: String = "HelloWorld"
val fromChars: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))

fun main() {
    println(string == fromChars)
    println(string === fromChars)
    println("print string $string")

    val a: Int = 1
    val b: Int = 2
    println("$a+$b=${a + b}")

    val json:String="""
        {
            "code":0,
            "message":"success"
        }
    """.trimIndent()
    println(json)
}