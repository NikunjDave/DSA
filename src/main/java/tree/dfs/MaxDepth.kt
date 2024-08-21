package tree.dfs

import data.TreeNode
import java.util.LinkedList

/**
 * LeetCode : 104
 */
object MaxDepth {
    fun findMaxDepth(root : TreeNode<Int>?): Int{
        var level = 0
        if(root == null)
            return  0
        val queue = LinkedList<TreeNode<Int>>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            for (i in 0 until size) {
                val current = queue.poll()
                val left = current.left
                val right = current.right
                if (left != null)
                    queue.add(left)
                if (right != null)
                    queue.add(right)
            }
            level++
        }
        return  level
    }

    fun maxDepth(root: TreeNode<Int>?): Int {
        if(root == null) return 0
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return 1 + Math.max(left, right)
    }
}
fun main() {
    val root = TreeNode<Int>(1)
    root.left = TreeNode<Int>(2)
    root.right = TreeNode<Int>(3)

    root.left?.left = TreeNode(4)
    root.left?.right = null

    root.right?.left = null
    root.right?.right = TreeNode<Int>(5)


    val size = MaxDepth.maxDepth(root)
    println("Size is $size")
    //[1,2,3,4,null,null,5]
}