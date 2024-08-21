package tree.dfs

import data.TreeNode
import data.createTree
import tree.bfs.LevelOrder
import java.lang.StringBuilder

/**
 * Serialize and Deserialize Binary tree
 * LC : 297
 *
 */
object SerializeBinaryTree {
    fun serialize(root: TreeNode<Int>?): String {
        val stream = StringBuilder()
        serializeHelper(root,stream)
        return stream.toString()
    }
    private fun serializeHelper(root : TreeNode<Int>?,stream : StringBuilder){
        if(root == null){
            stream.append("n ")
            return
        }
        stream.append(root.data).append(" ")
        serializeHelper(root.left,stream)
        serializeHelper(root.right,stream)
    }


    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode<Int>? {
        val list = data.split(" ")
        val q = ArrayDeque(list)
        val node = deserializeHelper(q)
        return node
    }

    fun deserializeHelper(queue : ArrayDeque<String>): TreeNode<Int>?{
        val element = queue.first()
        queue.removeFirst()
        if(element == "n")
            return null
        val root = TreeNode<Int>(element.toInt())
        root.left = deserializeHelper(queue)
        root.right = deserializeHelper(queue)
        return root
    }
}

fun main(){
    val root = createTree(listOf(1,2,3,4,5,6))
    println("before ${LevelOrder.levelOrder(root).joinToString( )}")
    val result = SerializeBinaryTree.serialize(root)
    println("Serialization string : $result")
    val de = SerializeBinaryTree.deserialize(result)
    println("after ${LevelOrder.levelOrder(de).joinToString( )}")


}