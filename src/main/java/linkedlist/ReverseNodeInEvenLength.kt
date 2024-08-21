package linkedlist

/**
 * Given the head of a linked list,
 * the nodes in it are assigned to each group in a sequential manner.
 * For. eg.
 * [1,2,3,5] -> group will be [1],[2,3], [5]
 * so we need to reverse nodes for even number group, which is in case [2,3]
 * so output will be : [1,3,2,5]
 *
 */
class ReverseNodeInEvenLength {
    /* Approach
    *  so we traverse linked list start with groupLen = 2, numOfNodes.
    *  now firstly for groupLen == 2 can have max 2 nodes,(if it has 2 nodes just revrese it)
    *  numOfNodes is reached to groupLen of end of list, in that case if numOfNodes % 2== 0, reverse
    *  will have groupHead
    *
    * */

    fun reverseEvenLengthGroup(head : Node?) : Node? {
        var prev: Node? = head
        var node: Node? = null
        var currNext: Node? = null
        var current: Node? = null
        var prevNext: Node? = null
        var reverse: Node? = null
        var groupLen = 2
        var numOfNodes = 0
        while (prev?.next != null){
            node = prev
            numOfNodes = 0
            for (i in 0 until groupLen){
                if (node?.next == null)
                    break
                numOfNodes += 1
                node = node.next
            }

            if(numOfNodes % 2 != 0){
                prev = node
            }else{
                reverse = node?.next
                current = prev.next
                for (j in 0 until numOfNodes){
                    currNext = current?.next
                    current?.next = reverse
                    reverse = current
                    current = currNext
                }
                prevNext = prev.next
                prev.next = node
                prev = prevNext
            }
            groupLen += 1

        }
        return  head
    }

}