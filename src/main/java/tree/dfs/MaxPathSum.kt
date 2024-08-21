package tree.dfs

import data.TreeNode
import data.createTree

/**
 * LC: 124
 */
object MaxPathSum {
    var maxSum = Int.MIN_VALUE
     fun maxPathSum(root: TreeNode<Int>?):Int{
        maxContrib(root)
        return maxSum;
    }
    private fun maxContrib(root: TreeNode<Int>?): Int {
        if(root == null)
            return 0
        val maxLeft = maxContrib(root.left)
        val maxRight = maxContrib(root.right)
        var leftSubTree = 0
        var rightSubTree = 0
        if(maxLeft > 0)
            leftSubTree = maxLeft
        if(maxRight > 0)
            rightSubTree = maxRight
        val valueNewPath = root.data + leftSubTree + rightSubTree
        println("new path at ${root.data} is $valueNewPath")
        maxSum = maxOf(maxSum,valueNewPath)
        println("max sum is $maxSum")
        val result = root.data + maxOf(leftSubTree,rightSubTree)
        println("return for node ${root.data} is $result")
        println("****************************")
        return result
    }
}

fun main(){
    val tree = createTree(listOf(-8,2,17,1,4,19,5))
    val max = MaxPathSum.maxPathSum(tree)
    println("max sum is $max")
}