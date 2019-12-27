package io2019

@Experimental(level = Experimental.Level.WARNING)
annotation class NewAPI

@NewAPI
class MicroserviceAPI

fun main() {
    val microserviceAPI = MicroserviceAPI()
}