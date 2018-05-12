package io2018._05_coroutines

class CallbackService(val name: String) {
    class Response(val from: CallbackService, val message: String)

    fun request(from: String, callback: (Response) -> Unit) {
        callback(Response(this, "Hi $from!\n -- Yours, $name"))
    }
}

fun CallbackService.sendMany(vararg from: String, callback: (CallbackService.Response) -> Unit) {
    if (from.isEmpty()) {

    }
}


fun main(args: Array<String>) {
    val s1 = CallbackService("1")
    val s2 = CallbackService("2")

    s1.request(s2.name) { r1 ->
        println(r1.message)
        r1.from.request(s1.name) { r2 ->
            println(r2.message)
        }
    }
}


