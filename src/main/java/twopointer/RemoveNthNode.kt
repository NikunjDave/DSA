package twopointer

class RemoveNthNode {
    fun removeNthNode(head: Node?, n : Int) : Node?{
        // first init both pointer
        // first init both pointer
        var left: Node? = head
        var right: Node? = head
        //move right towrads n mode
        //move right towrads n mode
        for (i in 0 until n) {
            right = right?.next
        }
        // now move both node forwards until right reach to end
        while (right?.next != null) {
            right = right.next
            left = left?.next
        }
        // the left next is nth node from the end, which is to be removed
        //left.next = left.next.next;
        // the left next is nth node from the end, which is to be removed
        //left.next = left.next.next;
        val nodeTobeRemoved = left?.next
        left?.next = nodeTobeRemoved?.next
        // Replace this placeholder return statement with your code
        return head
    }
}


data class Node(val data : Int, var next: Node? = null)

class LinkedList {
    var head : Node? = null
    fun appendData(data: Int){
        val newNode = Node(data)
        if(head == null){
            head = newNode
            return
        }
        var current = head
        while(current?.next != null){
            current = current.next
        }
        // this is where magic happens, you hold the reference
        current?.next = newNode
    }

    fun printList() {
        var current = head
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
        println()
    }

}



