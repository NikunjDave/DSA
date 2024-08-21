package hashmap

import java.util.Stack

/**
 * LC : 496-1
 *
 */
object NextGreaterElement {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val result = IntArray(nums1.size) { -1 }
        val hashMap = HashMap<Int, Int>()
        val stack = Stack<Int>()

        // Build a mapping from nums2 elements to their next greater element
        for (num in nums2) {
            while (stack.isNotEmpty() && stack.peek() < num) {
                hashMap[stack.pop()] = num
            }
            stack.push(num)
        }

        // Fill the result array by looking up the next greater element from the hashmap
        for (i in nums1.indices) {
            result[i] = hashMap.getOrDefault(nums1[i], -1)
        }

        return result
    }
}

fun main(){
    val output = NextGreaterElement.nextGreaterElement(intArrayOf(4,1,2),
        intArrayOf(1,3,4,2))
    println(output.joinToString())
}