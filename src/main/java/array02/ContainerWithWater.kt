package array02

import kotlin.math.max

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by
 * array [1,8,6,2,5,4,8,3,7]. In this case, the max area
 * of water (blue section) the container can contain is 49.
 */
object ContainerWithWater {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size -1
        var maxArea = Int.MIN_VALUE
        while(start < end){
            // different between index and min height
            val area = (end-start) * minOf(height[start],height[end])
            if(area > maxArea)
                maxArea = area
            if(height[start] > height[end])
                end --
            else
                start ++
         }
        return maxArea
    }
}