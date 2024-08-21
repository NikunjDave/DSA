package tree.dfs

import data.TreeNode
import data.createTree

/**
 * LC-543
 * The diameter of binary tree is the longest path between
 * two nodes
 */
class DiameterOfBinaryTree {
    private var ans = 0
    fun findDiameter(root : TreeNode<Int>?) : Int{
        maxDepth(root)
        return ans
    }

    private fun maxDepth(node : TreeNode<Int>?) : Int{
        if(node == null)
            return 0
        val lh = maxDepth(node.left)
        val rh = maxDepth(node.right)
        ans = maxOf(ans,lh+rh)
        return 1+ maxOf(lh,rh)
    }
}

fun main(){
    val root  = createTree(listOf(1,2,3,4,5,6))
    val diameter = DiameterOfBinaryTree().findDiameter(root)
    println("diameter is $diameter")
}