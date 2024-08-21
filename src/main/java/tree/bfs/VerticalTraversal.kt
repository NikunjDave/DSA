package tree.bfs

import data.TreeNode
import data.createTree
import java.util.*
import kotlin.collections.ArrayList

/**
 * LC : 987
 */
object VerticalTraversal {
    fun verticalTraversal(root : TreeNode<Int>?): List<List<Int>>{
        val output : MutableList<List<Int>> = ArrayList()
        if(root == null)
            return output
        // for traversal
        val queue = LinkedList<Pair<TreeNode<Int>?,Pair<Int,Int>>>()
        val xToSortedPairs = sortedMapOf<Int, MutableList<IntArray>>()
        queue.add(Pair(root,Pair(0,0)))
        while (queue.isNotEmpty()){
            val p = queue.poll()
            val node = p.first
            val(column,level)= p.second
            // add it to the hashmap
            if(node != null) {
                xToSortedPairs.computeIfAbsent(column) { mutableListOf() }
                println("col is : $column and level is :$level, and data is ${root.data}")
                xToSortedPairs[column]!!.add(intArrayOf(level, node.data))
                queue.offer(Pair(node.left, Pair(column - 1, level + 1)))
                queue.offer(Pair(node.right, Pair(column + 1, level + 1)))
            }
        }

        for (pairs in xToSortedPairs.values) {
            pairs.sortWith(compareBy({ it[0] }, { it[1] })) // Sorting based on the custom comparator
            val vals = pairs.map { it[1] }
            output.add(vals)
        }
        return output
    }
}

fun main(){
    val result = VerticalTraversal.verticalTraversal(createTree(listOf(3,1,4,0,2,2)))
    result.forEach{
        println(it.joinToString( ))
    }
}