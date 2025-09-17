package tree.bfs

import data.TreeNode
class BottomView {

    fun bottomViewOfTree(root : TreeNode<Int>?) : List<Int?> {
        if (root == null) return emptyList()
        // Map from horizontal distance -> node value
        val hdMap = mutableMapOf<Int, Int?>()
        // Queue of pairs: node + its horizontal distance
        val queue = ArrayDeque<Pair<TreeNode<Int>?, Int>>()
        queue.add(root to 0)
        while(queue.isNotEmpty()){
            val (node,hd) = queue.removeFirst()
            hdMap[hd] = node?.data
            if(node?.left != null){
                queue.add(Pair(node.left,hd-1))
            }
            if(node?.right != null){
                queue.add(Pair(node.right,hd+1))
            }
        }
        val output = mutableListOf<Int?>()
        for(entry in hdMap.entries){
            output.add(entry.value)
        }
        return output
    }
}

fun main(){
    val root  = TreeNode(2)
    root.left = TreeNode(7)
    root.right = TreeNode(5)

    root.left?.left = TreeNode(8)
    root.left?.right = TreeNode(6)
    root.right?.right = TreeNode(9)

    root.left?.right?.left = TreeNode(5)
    root.left?.right?.right = TreeNode(11)
    root.right?.right?.left = TreeNode(4)

    val result = BottomView().bottomViewOfTree(root)
    println(result)
}