package com.phenix

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