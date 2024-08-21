package array02

import java.util.Stack

/**
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 *
 * You should return the array of nums such that the the array follows the given conditions:
 *
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 *
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 */
object ReArrangeArrayBySign {
    fun solution(nums: IntArray): IntArray {
        val output = IntArray(nums.size)
        val stackA = Stack<Int>()
        val stackB = Stack<Int>()
        for (element in nums){
            if(element > 0){
                stackA.push(element)
            }else{
                stackB.push(element)
            }
        }
        var index = nums.size -1
        while (stackA.isNotEmpty()){
            output[index--] = stackB.pop()
            output[index--] = stackA.pop()
        }
        return output
    }

    fun solution2(nums: IntArray): IntArray {
        var i = 0
        var j = 1
        val output = IntArray(nums.size)
        for(element in nums){
            if(element > 0){
                output[i] = element
                i += 2
            }else{
                output[j] = element
                j += 2
            }
        }
        return output
    }

}

fun main(){
    val output = ReArrangeArrayBySign.solution2(intArrayOf(3,1,-2,-5,2,-4))
    println("outputs is ${output.joinToString(",")}")

}