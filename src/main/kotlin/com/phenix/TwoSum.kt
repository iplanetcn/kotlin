package com.phenix

fun main() {
    val nums = intArrayOf( 2, 7, 11, 15)
    val target  = 9
    val answer = intArrayOf(0,1)
    if(answer.contentEquals(twoSum(nums, target))) {
        println("equals")
    }else {
        println("not equals")
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int,Int>()
    for (i in 0..nums.size) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(map.getValue(target - nums[i]), i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}