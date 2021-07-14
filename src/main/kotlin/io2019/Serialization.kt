package io2019

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

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

fun main() {
    println(Json.encodeToString(Customer.serializer(), customer))
//    println(Json.encodeToString((List<Customer>).serializer(), customers))

    val json = "{\n  \"id\": 1,\n  \"name\": \"me\",\n  \"email\": \"you@me.com\"}"

    println(Json.decodeFromString(Customer.serializer(), json))
}