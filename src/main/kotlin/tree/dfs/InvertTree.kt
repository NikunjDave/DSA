package tree.dfs

import data.TreeNode
import data.createTree
import tree.bfs.LevelOrder

/**
 * Invert Binary tree/mirror binary tree
 * LC : 226
 */

/**
 * Algo
 * 1. Perform post-order traversal on the left child of the root node.
 * 2.Perform post-order traversal on the right child of the root node.
 * 3. Swap the left and right children of the root node.
 *
 */
object InvertTree {
        fun invertTree(root : TreeNode<Int>?) : TreeNode<Int>?{
            if(root == null)
                return null
            if(root.left != null)
                invertTree(root.left)

            if(root.right != null)
                invertTree(root.right)
            // swap
            val temp = root.left
            root.left = root.right
            root.right = temp
            return root
        }
}

fun main(){
    val root  = createTree(listOf(1,2,3,4,5,6))
    println(LevelOrder.levelOrder(root).joinToString(" "))
    val result = InvertTree.invertTree(root)
    val list = LevelOrder.levelOrder(result)
    println(list.joinToString(" "))
}