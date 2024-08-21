package hashmap

import kotlin.math.absoluteValue

/**
 * LC: 219
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in
 * the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * ex : 1
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * ex:2
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 *
 *
 */
object ContainDuplicatesTwo {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        // key as nums element and nums index is as value
        val hashmap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (hashmap.containsKey(nums[i])) {
                val index = hashmap[nums[i]]!!
                println("element index is $i & value is  ${nums[i]}")
                println("difference is ${(index - i).absoluteValue}")
                if ((index - i).absoluteValue <= k)
                    return true
            }
            hashmap[nums[i]] = i
            /*else {
                hashmap[nums[i]] = i
            }*/
        }
        return false
    }

    // using hashset
    fun containsNearbyDuplicate2(nums: IntArray, k: Int): Boolean {
        var set = HashSet<Int>()
        var i = 0
        var j = 0

        while (j < nums.size) {
            if (j - i <= k) {
                if (set.contains(nums[j]))
                    return true
                set.add(nums[j])
                j++
            } else {
                set.remove(nums[i])
                i++
            }
        }

        return false
    }
}
fun main(){
    val output = ContainDuplicatesTwo.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3),2)
    println("contain nearby duplicates : $output")
}