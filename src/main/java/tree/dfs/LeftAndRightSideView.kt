package tree.dfs

import data.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeftAndRightSideView {

    fun leftSideView(root : TreeNode<Int>) : List<Int>{
        val output = mutableListOf<Int>()
        recursionLeft(root,0,output)
        return output
    }


    private fun recursionLeft(node : TreeNode<Int>?,level : Int, list : MutableList<Int>){
        if(node == null)
            return
        if(level == list.size){
            list.add(node.data)
        }
        recursionLeft(node.left,level+1,list)
        recursionLeft(node.right,level+1,list)
    }

    fun rightSideView(root : TreeNode<Int>) : List<Int>{
        val output = mutableListOf<Int>()
        recursionRight(root,0,output)
        return output
    }





    private fun recursionRight(node : TreeNode<Int>?,level : Int, list : MutableList<Int>){
        if(node == null)
            return
        if(level == list.size){
            list.add(node.data)
        }
        recursionRight(node.right,level+1,list)
        recursionRight(node.left,level+1,list)
    }


    fun rightSideViewNormal(root : TreeNode<Int>?): List<Int>{
        val res = mutableListOf<Int>()
        var k = 0
        if(root == null)
            return res
        val queue : Queue<Pair<TreeNode<Int>,Int>> = LinkedList()
        queue.add(root to 0)
        while(queue.isNotEmpty()){
            val(node, height) = queue.remove()
            if(height == k){
                res.add(node.data)
                k++
            }
            node.right?.let { queue.add(it to (height + 1)) }
            node.left?.let { queue.add(it to (height + 1)) }
        }
        return res
    }


}

fun main(){
    val root  = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(10)
    root.right?.left = TreeNode(9)
    root.right?.right = TreeNode(11)

    root.left?.left?.right = TreeNode(5)
    root.left?.left?.right?.right = TreeNode(6)

    val result = LeftAndRightSideView().rightSideViewNormal(root)
    println(result)
}