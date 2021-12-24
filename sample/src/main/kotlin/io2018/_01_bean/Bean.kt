package io2018._01_bean

data class Bean(var name: String, var age: Int)

val bean:Bean = Bean("John", 31)

fun main() {
    println(bean.toString())
}