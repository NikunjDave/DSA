package array02

import java.util.Arrays

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 *
 *
 */

object ThreeSum{
    // First approach, using two loop, we run two loop , i and j and look for the element k such that
    // like k = -(i+j), if k is present in set, we will save the triplet in main set.
    // Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
     fun findTriplet(input : IntArray) : List<List<Int>>{
         val ans = mutableSetOf<List<Int>>() // taking set as we don't want to have duplicate triplet element.
         for (i in input.indices){
             val innerSet = mutableSetOf<Int>()
             for(j in i+1 until input.size){
                 val k = -(input[i]+input[j])
                 if(innerSet.contains(k)){
                     val list = listOf(input[i],input[j],k)
                     ans.add(list.sorted())
                 }
                 innerSet.add(input[j])
             }
         }
        return ans.toList()
     }

    // optimal approach, using two pointer, we get rid of inner hashset.
    //Time Complexity: O(NlogN)+O(N2), where N = size of the array.
    fun findTriplet2(input : IntArray) : List<List<Int>>{
        input.sort() // sort entire array
        val outputList = mutableListOf<List<Int>>()
        for(i in input.indices){
            if(i > 0 && input[i] == input[i-1])
                continue // continue until find unique element
            var j = i +1
            var k = input.size - 1
            while (j < k){
                val sum = input[i] + input[j] + input[k]
                if(sum  > 0) {
                    k--
                }
                else if(sum < 0){
                    j++
                }
                else { // sum == 0
                    outputList.add(listOf(input[i],input[j],input[k]))
                    j++
                    k--
                    //skip the duplicates:
                    while (j < k && input[j] == input[j - 1]) j++;
                    while (j < k && input[k] == input[k + 1]) k--;
                }
            }
        }
        return outputList
    }
}

fun main(){
    val output = ThreeSum.findTriplet2(intArrayOf(-1,0,1,2,-1,-4))
    output.forEach {
        println(it.joinToString(" "))
    }


}