package hashmap

/**
 * LC : 217
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 */
object ContainDuplicateOne {
    fun containsDuplicate(nums: IntArray): Boolean {
        // hashmap to store value as key and count as value
        val hashmap = mutableMapOf<Int,Int>()
        for(num in nums){
            if(hashmap.containsKey(num))
                return true
            hashmap[num] = hashmap.getOrDefault(num,0)+1
        }
        return false
    }
    // using set
    fun containsDuplicate2(nums: IntArray): Boolean {
        val frequency = mutableSetOf<Int>()
        for (num in nums) {
            if (!frequency.add(num))
                return true
        }
        return false
    }
}

fun main(){
    val output = ContainDuplicateOne.containsDuplicate(intArrayOf(1,2,3,4))
    println("contain duplicate $output")
}