package tree.dfs

import data.TreeNode
import java.util.Stack

// InOrder -> left, root , right
class InorderTraversal {

    fun inorderTraversal(node: TreeNode<Int>) : List<Int>{
        val output = mutableListOf<Int>()
        val stack = Stack<TreeNode<Int>>()
        var curr: TreeNode<Int>? = node
        while (true){
            if(curr != null){
                stack.push(curr)
                curr = curr.left
            }else{
                if(stack.isEmpty())
                    break
                curr = stack.pop()
                output.add(curr.data)
                curr = curr.right
            }
        }
        return output
    }


    fun inorderTraversalRecursive(node: TreeNode<Int>?)  {
        val output = mutableListOf<Int>()
        if(node == null)
            return
        inorderTraversalRecursive(node.left)
        output.add(node.data)
        inorderTraversalRecursive(node.right)
    }
}