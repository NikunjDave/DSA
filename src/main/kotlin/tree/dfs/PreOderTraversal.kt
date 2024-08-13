package tree.dfs

import data.TreeNode
import java.util.Stack

class PreOderTraversal {
    /**
     * root, left, right
     *
     */
    fun preOrderTraversal(node : TreeNode<Int>?) : List<Int>{
        var curr: TreeNode<Int>? = node
        val output = mutableListOf<Int>()
        val stack = Stack<TreeNode<Int>>()
        while(true){
            if(curr != null){
                stack.push(curr)
                output.add(curr.data)
                curr = curr.left
            }else {
                if(stack.isEmpty())
                    break
                val top = stack.pop()
                curr = top.right
            }
        }
        return output
    }

    val output = mutableListOf<Int>()
    fun preOrderStart(node: TreeNode<Int>?): List<Int>{
        preOrderReversal(node)
        return output
        //println(output.joinToString(","))
    }
    fun preOrderReversal(node: TreeNode<Int>?){
        if(node == null)
           return
        output.add(node.data)
        preOrderReversal(node.left)
        preOrderReversal(node.right)
    }

}