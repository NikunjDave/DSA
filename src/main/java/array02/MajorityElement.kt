package array02


/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 */
object MajorityElement {
    fun findMajorityElements(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val countMap = HashMap<Int,Int>()
        for(num  in nums){
            countMap[num] = countMap.getOrDefault(num,0) + 1
        }
        for((key,count) in countMap.entries){
            if(count > nums.size / 3)
                result.add(key)
        }
        return result
    }
}
fun main(){
    val output = MajorityElement.findMajorityElements(intArrayOf(1,2))
    println(output.joinToString(" "))
}