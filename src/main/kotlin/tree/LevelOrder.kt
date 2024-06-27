package tree

import data.TreeNode
import java.util.LinkedList
import java.util.Stack

/**
 * Leetcode : 102
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
object LevelOrder {
    fun levelOrder(root: TreeNode<Int>?): List<List<Int>> {
        val output = mutableListOf<List<Int>>()
        if(root == null)
            return output
        val queue = LinkedList<TreeNode<Int>?>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            val level = mutableListOf<Int>()
            for(i in 0 until size){
                val current = queue.poll()
                if(current != null)
                    level.add(current.data)
                if(current?.left != null)
                    queue.add(current.left)
                if(current?.right != null)
                    queue.add(current.right)
            }
            output.add(level)
        }
        return output
    }
}


fun main(){
    val root = TreeNode<Int>(3)
    root.left = TreeNode<Int>(9)
    root.right = TreeNode<Int>(20)

    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val result = LevelOrder.levelOrder(root)
    result.forEach {
        println(it.joinToString(""))
    }
}