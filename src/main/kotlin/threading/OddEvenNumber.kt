package threading

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

/**
 * Use two thread to concurrently print odd and even number.
 *
 * One thread will print odd number and another will print even.
 * The print should happen in correct order
 *
 */
class SharedResource(private val limit: Int) {
    private val lock = ReentrantLock()
    private val oddCondition = lock.newCondition()
    private val evenCondition = lock.newCondition()
    private var number = 1

    fun printOdd() {
        lock.withLock {
            while (number <= limit) {
                if (number % 2 != 0) {
                    println("${Thread.currentThread().name}: $number")
                    number++
                    evenCondition.signal()
                } else {
                    oddCondition.await()
                }
            }
        }
    }

    fun printEven() {
        lock.withLock {
            while (number <= limit) {
                if (number % 2 == 0) {
                    println("${Thread.currentThread().name}: $number")
                    number++
                    oddCondition.signal()
                } else {
                    evenCondition.await()
                }
            }
        }
    }

}

class OddNumberPrinter(private val sharedResource: SharedResource) : Runnable {
    override fun run() {
        sharedResource.printOdd()
    }
}

class EvenNumberPrinter(private val sharedResource: SharedResource) : Runnable {
    override fun run() {
        sharedResource.printEven()
    }
}


class TestMultiThreading() {
    val sharedResource = SharedResource(100) // Set the limit
    val oddThread = Thread(OddNumberPrinter(sharedResource), "OddThread")
    val evenThread = Thread(EvenNumberPrinter(sharedResource), "EvenThread")

    fun printNumber() {
        oddThread.start()
        evenThread.start()

        oddThread.join()
        evenThread.join()
    }
}

