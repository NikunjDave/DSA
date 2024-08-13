package tree.dfs

import data.TreeNode
import java.util.Stack

class PostOderTraversal {
    /**
     * left, right,root
     * in order to get post order will use two stack
     * stack1 --> root,left,right
     * stack2--> root,right,left
     * pop out stack2--> left, right root
     */
    fun postOrderTraversal(node : TreeNode<Int>?) : List<Int>{
        //var curr: TreeNode<Int>? = node
        val output = mutableListOf<Int>()
        val stack1 = Stack<TreeNode<Int>>()
        val stack2 = Stack<TreeNode<Int>>()
        stack1.push(node)
        while(stack1.isNotEmpty()){
            val top = stack1.pop()
            stack2.push(top)
            if(top.left != null){
                stack1.push(top.left)
            }
            if(top.right != null){
                stack1.push(top.right)
            }
        }
        while (stack2.isNotEmpty()){
            val top = stack2.pop()
            output.add(top.data)
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