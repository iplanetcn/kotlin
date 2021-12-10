package com.phenix

fun main() {
    val p = Human("John", 31, "Android Engineer.")
    println(p.toString())
    val nums = intArrayOf( 2, 7, 11, 15)
    val target  = 9
    val answer = intArrayOf(0,1)
    if(answer.contentEquals(twoSum(nums, target))) {
        println("equals")
    }else {
        println("not equals")
    }
}


class Human(private var name: String, private var age: Int, private var message: String) {
    override fun toString(): String {
        return "Human(name='$name', age=$age, message='$message')"
    }
}