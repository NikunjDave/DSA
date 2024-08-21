package linkedlist
class LruCache(val capacity: Int) {
    val head : Node  = Node(0,0)
    val tail : Node  = Node(0,0)
    val hashmap = hashMapOf<Int, Node>()
    init{
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = hashmap.getOrDefault(key,null)
        if(node != null){
            removeNode(node)
            insertNodeFirst(node)
        }
        return node?.value ?: -1
    }


    /*fun put(key: Int, value : Int){
        if(hashmap.containsKey(key)){
            removeNode(hashmap.get(key))
        }
        if(hashmap.size == capacity){
            removeNode(tail.prev)
        }
        insertNodeFirst(Node(key,value))
    }*/
    fun put(key: Int, value: Int) {
        val node = Node(key,value)
        if(hashmap.containsKey(key))
            removeNode(hashmap.get(key))
        if(hashmap.size == capacity){
            removeNode(tail.prev)
        }
        insertNodeFirst(node)
    }

    private fun removeNode(node: Node?){
        hashmap.remove(node?.key)
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev

    }
    private fun insertNodeFirst(node: Node){
        hashmap.put(node.key,node)
        /*val temp = head.next
        head.next = node
        node.next = temp
        node.prev = head
        temp?.prev = node*/

        val headNext = head.next
        head.next = node
        node.prev = head
        headNext?.prev = node
        node.next = headNext
    }

    /*
    * val headNext = head.next
        head.next = node
        node.prev = head
        headNext?.prev = node
        node.next = headNext
    * */
/*
class LruCache(val capacity: Int){
    val head = Node(0,0)
    val tail = Node(0,0)
    init {
        head.next = tail
        tail.prev = head
    }
    val map = HashMap<Int,Node>()
     fun get(key: Int): Int{
        if(map.containsKey(key)){
            val node = map.get(key)
             remove(node)
             insert(node!!)
            return node.value
        }else
            return -1
    }
    fun put(key: Int, value : Int){
        if(map.containsKey(key)){
            remove(map.get(key))
        }
        if(map.size == capacity){
            remove(tail.prev)
        }
        insert(Node(key,value))
    }
    private fun remove(node:Node?){
        map.remove(node?.key)
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    private fun insert(node: Node){
        map.put(node.key,node)
        val headNext = head.next
        head.next = node
        node.prev = head
        headNext?.prev = node
        node.next = headNext
    }
*/



    inner class Node(val key: Int, val value: Int) {
        var prev : Node? = null
        var next : Node? = null
    }
}

