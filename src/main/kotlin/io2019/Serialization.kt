package io2019

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Companion.stringify
import org.intellij.lang.annotations.Language

@Serializable
data class Customer(
        val id: Int,
        val name: String,
        val email: String,
        val source: String = "direct"
)

val customer = Customer(1, "Mary Jane", "mary.jane@domain.com")
val customers = listOf(
        Customer(1, "customer1", "customer1@domain.com", "indirect"),
        Customer(2, "customer2", "customer2@domain.com")
)

@UnstableDefault
fun main() {
//    println(stringify(Customer.serializer(), customer))
//    println(stringify(Customer.serializer().list, customers))
//
//    @Language("JSON") val json = "{\n  \"id\": 1,\n  \"name\": \"me\",\n  \"email\": \"you@me.com\",\n  \"age\": 32\n}"
//
//    println(Json.parse(Customer.serializer(), json))
}