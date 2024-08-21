package tree.bfs

import data.TreeNode
import data.createTree
import java.util.LinkedList

/**
 * LC : 101
 */
object SymmetricTree {
    fun isSymmetric(root: TreeNode<Int>?): Boolean {
        val queue = LinkedList<TreeNode<Int>?>()
        if(root == null)
            return false
        // Enqueue left and right node of tree
        queue.add(root.left)
        queue.add(root.right)
        while (queue.isNotEmpty()){
            val left = queue.poll()
            val right = queue.poll()
            if (left == null && right == null)
                continue

            if (left == null || right == null)
                return false

            if (left.data != right.data)
                return false

            // Enqueue  left node of left
            queue.add(left.left)
            // Enqueue right node of right
            queue.add(right.right)
            // enqueue right of left
            queue.add(left.right)
            // enqueue left of right
            queue.add(right.left)
        }
        return true
    }
}

fun main(){
    val root = createTree(listOf(1,2,2,3,4,4,3))
    val isSymmetric = SymmetricTree.isSymmetric(root)
    println(" Is tree  symmetric : $isSymmetric")
}