package linkedlist



class Node(var data: Int) {
    var next : Node? = null
    constructor(data: Int, node : Node) : this(data) {
        this.next = node
        this.data = data
    }

    companion object {
        fun buildLinkedList(input : IntArray) : Node?{
            var head : Node? = null
            for (i in input.size-1 downTo 0){
                // create a node
                val node = Node(input[i])
                // insert node at head
                if(head == null){
                    head = node
                }else{
                    node.next = head
                    head = node
                }
            }
            return head;
        }

        fun printList(head : Node?){
            var current = head
            println("linked list is :")
            while (current != null){
                print(current.data)
                print(" ,")
                current  = current.next
            }
        }
    }
}