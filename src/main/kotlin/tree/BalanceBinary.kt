package tree

import data.TreeNode
import data.createTree
import java.util.LinkedList
import kotlin.math.absoluteValue

/**
 * Leetcode : 110
 * Check if the tree is balanced or not,
 * The height difference between left-subtree and right subtree should not be more than 1.
 */
object BalanceBinary {
    fun isBalanced(root: TreeNode<Int>?): Boolean {
        if(root == null)
            return true
        val lh = maxDepth(root.left)
        val rh = maxDepth(root.right)

//        val lh = heightOfTree(root?.left)
//        val rh = heightOfTree(root?.right)
        println("lh is $lh and rh is $rh")
        return (lh - rh).absoluteValue <= 1
    }

    private fun heightOfTree(root : TreeNode<Int>?) : Int{
        var level = 0
        val queue = LinkedList<TreeNode<Int>>()

        if (root != null)
            queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size) {
                val current = queue.remove()
                val left = current.left
                val right = current.right
                if (left != null)
                    queue.add(left)
                if (right != null)
                    queue.add(right)
            }
            level ++
        }
        return  level
    }


    // using recursive appraoch
    private fun maxDepth(node: TreeNode<Int>?) : Int{
        if(node == null)
            return  0
        val lh = maxDepth(node.left)
        val rh = maxDepth(node.right)
        return 1 + maxOf(lh,rh)
    }
}

fun main(){
//    val root = TreeNode(1)
//    root.right = TreeNode(2)
//    root.right?.right = TreeNode(3)
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)

    root.left?.left = TreeNode(3)
    root.left?.left?.left = TreeNode(4)

    root.right?.right = TreeNode(3)
    root.right?.right?.right = TreeNode(4)



    //val root  = createTree(listOf(1,2,2,3,null,null,3,4,null,null,4))
    val isBalanced = BalanceBinary.isBalanced(root)
    println("is balanced : $isBalanced")
}