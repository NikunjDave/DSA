package heap

import java.util.*

/**
 * Given a list of points on a plane, where the plane is a 2-D array with (x, y) coordinates, find the kth closest
 * points to the origin
 * Eg. Input : [(1, 3),(3, 4), (2, -1)] and k = 2,
 * output  = [(1,3)(2,-1)]
 */

object KClosestPointToOrigin {
    fun kClosest(points: Array<Point>, k: Int): List<Point?> {
        val maxHeap: PriorityQueue<Point> =
            PriorityQueue<Point> { p1: Point, p2: Point -> p2.distFromOrigin() - p1.distFromOrigin() }
        for (i in 0 until k) maxHeap.add(points[i])
        for (i in k until points.size) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll()
                maxHeap.add(points[i])
            }
        }
        return ArrayList(maxHeap)
    }
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // max heap
        val closestPoint = PriorityQueue<IntArray> { p1, p2 -> p2.distFromOrigin() - p1.distFromOrigin() }
        // insert first K element to the queue
        for(i in 0 until k){
            closestPoint.add(points[i])
        }

        for(i in k until points.size){
            // compare with root, if smaller then enter
            if(points[i].distFromOrigin() < closestPoint.peek().distFromOrigin()){
                // remove root
                closestPoint.poll()
                closestPoint.add(points[i])
            }

        }
        return closestPoint.toTypedArray()

    }

    fun IntArray.distFromOrigin() = (this[0] * this[0]) + (this[1] * this[1])
}
data class Point(val x: Int,val y:Int){
  fun distFromOrigin() = (x*x) + (y*y)
}

/**
 * Time Complexity = O(n(log(k))where n is the total number of points and k
 * is the number of points closest to the origin.
 * Space Complexity = O(k), because we need to store k points to the heap
 */
fun main(){
    val pointsOne = arrayOf(
        Point(1, 3), Point(3, 4), Point(2, -1)
    )
    val pointsTwo = arrayOf(
        Point(1, 3), Point(2, 4), Point(2, -1), Point(-2, 2), Point(5, 3), Point(3, -2)
    )

    val pp = arrayOf(intArrayOf(1,3),intArrayOf(3,4),intArrayOf(2,-1))
    val result = KClosestPointToOrigin.kClosest(pp,2)
    result.forEach {
        print(it.joinToString ())
        println()
    }
    println("output is ${result.joinToString(" ")  }")

}