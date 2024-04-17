package linkedlist

/**
 * Given the head of a singly linked list,
 * reorder the list as if it were folded on itself.
 * For example, if the list is represented as follows:
 * l0,l1,l2,l3 ---- ln-2, ln-1,ln
 * reorder
 * l0,ln,l1,ln-1,l2,ln-1
 * E.g 1,2,3,4 ----> 1,4,2,3
 *
 */
class ReorderList {
    /**
     * find middle of list using two pointer,
     * reversed the second half of list and merge them
     */

    fun reorderListUsingInPlace(head: Node?): Node?{
        if(head == null)
            return head
        var slow: Node? = head
        var fast: Node? = head
        while (fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
        }

        // 1,2,3,4,5 --> prev = null, curr = 1, next = 2, --> prev = 1--> null
        // next = 3, curr = 2,  ----> prev = 2,1,null
        var prev : Node? = null
        var curr = slow // middle node
        var next : Node?
        while (curr != null){
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        var first: Node? = head
        var second: Node? = prev
        var temp : Node? = head
        while(second?.next != null){
            temp = temp?.next
            first?.next = second
            second = second.next
            first?.next?.next = temp
            first = first?.next?.next
        }
        return head
    }

    // Brute force technique
    fun reorderList(head: Node?): Node? {

        if (head?.next == null) {
            return head
        }
        var current : Node? = head
        while (current?.next != null) {
            val lastNode = findLastNode(current.next)
            lastNode?.next = current.next
            current.next = lastNode
            current = lastNode?.next
        }
        return head
    }

    private fun findLastNode(start: Node?) : Node?{
        var current: Node? = start
        var prev: Node? = null
        while (current?.next != null){
            prev = current
            current = current.next
        }
        prev?.next = null
        return current
    }

    /*
    * input == 1,2,3,4,5 -----> 1,5,2,4,3
    *  init -> odd = 1, even = 2
    *   while loop until even.next != null
    *    step 1 ->
    *       odd.next = even.next(2 -> 3)
    *       odd = 1,3,4,5
    *       even.next = odd.next( 2 -> 3
    *
    *
    *
    *
    * */
}
