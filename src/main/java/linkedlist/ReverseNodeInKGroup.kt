package linkedlist

/**
 * The task is to reverse the nodes in groups of k in a given linked list, where
 * K is a positive integer, e.g. 1,3,2,3,4,5,6 and k is 3 then start from 1 who makes group
 * of 3 reverse them
 *  o.p -> 2,3,1,5,4,3,6
 */
class ReverseNodeInKGroup {

    fun reverseInKGroup(head : Node?,k : Int): Node?{
        if (head == null) return null
        if(k <= 1) return head
        var dummy : Node?  = Node(0)
        dummy?.next = head
        var ptr : Node? = dummy
        while (ptr != null){
            var tracker: Node?= ptr
            for (i in 0 until k){
                if(tracker == null)
                    break
               tracker = tracker.next
            }
            if (tracker == null)
                break
            val(prev, current) = reverseList(ptr.next,k)

            var lastNodeOfPrevGroup: Node? = ptr.next
            lastNodeOfPrevGroup?.next = current
            ptr.next = prev
            ptr = lastNodeOfPrevGroup
        }
        return dummy?.next
    }

    private fun reverseList(head: Node?,k : Int) : Pair<Node?,Node?>{
        if (head == null) return Pair(null,null)
        var curr:Node? = head
        var prev:Node? = null
        var next: Node? = null
        for (i in 0 until k){
            next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }
        return Pair(prev,curr)
    }
}