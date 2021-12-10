package io2018._02_properties

private var prop: String = "..."
    set(v) {
        println("New Value:$v")
        field = v
    }

val os: String by lazy {
    println("Computing...")
    System.getProperty("os.name") +
            " v" + System.getProperty("os.version") +
            " (" + System.getProperty("os.arch") + " )"
}


fun main() {
    prop = "john"

    for (i in 1..3) {
        println(os)
    }
}