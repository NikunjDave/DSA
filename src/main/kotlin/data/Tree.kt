package data

import java.util.LinkedList

class TreeNode<T>(var data: T) {
    var left : TreeNode<T>?  = null
    var right : TreeNode<T>?  = null
}

fun createTree(): TreeNode<Int>{
    val node  =  TreeNode(1)
    node.left = TreeNode(2)
    node.right = TreeNode(3)

    node.left?.left = TreeNode(4)
    node.left?.right = TreeNode(5)

    node.right?.left = TreeNode(6)
    node.right?.right = TreeNode(7)

    node.left?.right?.left = TreeNode(8)

    node.right?.right?.left = TreeNode(9)
    node.right?.right?.right = TreeNode(10)
    return node
}

fun <T>createTree(nodeList : List<T>) : TreeNode<T>?{
    if(nodeList.isEmpty())
        return null
    // Create the root node of the binary tree
    val  root : TreeNode<T> = TreeNode(nodeList[0])
    val queue = LinkedList<TreeNode<T>>()
    queue.add(root)
    // Start iterating over the list of listOfNodes starting from the second node
    var i = 1
    while(i < nodeList.size){
        // Get the next node from the queue
        val curr = queue.remove()

        // If the node is not null, create a new TreeNode object for its left child,
        // set it as the left child of the current node, and add it to the queue
        if(nodeList[i] != null){
            curr.left = TreeNode(nodeList[i])
            queue.add(curr.left!!)
        }
        i++
        // If there are more listOfNodes in the list and the next node is not null,
        // create a new TreeNode object for its right child, set it as the right child
        // of the current node, and add it to the queue
        if(i < nodeList.size && nodeList[i] != null){
            curr.right = TreeNode(nodeList[i])
            queue.add(curr.right!!)
        }
        i++
    }

    return root
}