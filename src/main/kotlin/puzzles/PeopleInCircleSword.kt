package puzzles

/**
 * 100 people standing in a circle in an order 1 to 100.
 * No. 1 has a sword. He kills the next person (i.e. No. 2) and
 * gives the sword to the next (i.e. No. 3).
 * All people do the same until only 1 survives. Which number survives at the last?
 * There are 100 people starting from 1 to 100.
 *
 */
object PeopleInCircleSword {
    fun findLastPersonLeft(numOfPerson : Int) {
        val person = numOfPerson

        // Placeholder array for person
        var a = IntArray(person) { it + 1 }

        // Will start the game from 1st person (Which is at
        // placeholder 0)
        var pos = 0

        // Game will be continued till we end up with only one
        // person left
        while (a.size > 1) {
            // Current person will shoot the person next to
            // him/her. So incrementing the position.
            pos++

            // As person are standing in circular manner, for
            // person at last place has right neighbour at
            // placeholder 0. So we are taking modulo to make it
            // circular
            pos %= a.size

            // Killing the person at placeholder 'pos'
            // To do that we simply remove that element
            val anotherArray = IntArray(a.size - 1)
            System.arraycopy(a, 0, anotherArray, 0, pos)
            System.arraycopy(a, pos + 1, anotherArray, pos, a.size - pos - 1)
            a = anotherArray

            // There is no need to increment the pos again to
            // pass the gun Because by erasing the element at
            // 'pos', now next person will be at 'pos'.
        }

        // Print Person that survive the game
        println(a[0])
    }
}