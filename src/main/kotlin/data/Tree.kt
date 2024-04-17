package data

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