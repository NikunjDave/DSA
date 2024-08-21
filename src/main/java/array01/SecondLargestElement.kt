package array01

object SecondLargestElement {
    fun findElement(numbers: IntArray): Int {
        var max = numbers[0]
        var max2 = 0
        for (i in 1 until numbers.size) {
            if (numbers[i] > max) {
                max2 = max
                max = numbers[i]
            } else if (numbers[i] > max2) {
                max2 = numbers[i]
            }
        }
        return max2
    }
}

fun main() {
    val element = SecondLargestElement.findElement(intArrayOf(1,5,2,6,7))
    println("second largest element is $element")
}