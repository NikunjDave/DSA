package tree.bfs

import data.TreeNode
import java.util.*
import kotlin.collections.HashMap

class TopView {
    fun topViewOfTree(root : TreeNode<Int>?) : List<Int?> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int?>()
        //node and vertical traversal position
        val queue = LinkedList<Pair<TreeNode<Int>?, Int>>()
        // map of vertical position and value.
        val map = TreeMap<Int, Int?>()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val node = pair.first
            val pos = pair.second
            if (!map.containsKey(pos)) {
                map.putIfAbsent(pos, node?.data)
            }
            // put left child
            if (node?.left != null) {
                queue.add(Pair(node.left, pos - 1))
            }
            if (node?.right != null) {
                queue.add(Pair(node.right, pos + 1))
            }
        }
        for (element in map.values) {
            result.add(element)
        }
        return result
    }
}


fun main(){
    val root  = TreeNode(2)
    root.left = TreeNode(7)
    root.right = TreeNode(5)

    root.left?.left = TreeNode(8)
    root.left?.right = TreeNode(6)
    root.right?.right = TreeNode(9)

    val result = TopView().topViewOfTree(root)
    println(result)
}