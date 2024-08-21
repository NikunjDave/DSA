package threading

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * Use two thread to concurrently print odd and even number.
 *
 * One thread will print odd number and another will print even.
 * The print should happen in correct order
 *
 */
class OddEvenPrint(val limit: Int) {
    private var counter = 1
    private val lock = ReentrantLock()
    private val oddCondition = lock.newCondition()
    private val evenCondition = lock.newCondition()
  fun printOdd() {
        lock.withLock {
            while (counter <= limit) {
                if (counter % 2 != 0) {
                    println("${Thread.currentThread().name}: $counter")
                    counter++
                    evenCondition.signal()
                }else{
                    oddCondition.await()
                }
            }
        }
  }
    fun printEven() {
        lock.withLock {
            while (counter <= limit) {
                if (counter % 2 == 0) {
                    println("${Thread.currentThread().name}: $counter")
                    counter++
                    oddCondition.signal()
                } else {
                    evenCondition.await()
                }
            }
        }
    }
}
class OddNumberThread(val oddEvenPrint: OddEvenPrint) : Runnable{
    override fun run() {
        oddEvenPrint.printOdd()
    }

}

class EvenNumberThread(val oddEvenPrint: OddEvenPrint) : Runnable {
    override fun run() {
        oddEvenPrint.printEven()
    }
}

class TestEvenOddPrint {
    val oddEvenPrint = OddEvenPrint(100)
    val evenThread = Thread(EvenNumberThread(oddEvenPrint),"even-thread")
    val oddThread = Thread(OddNumberThread(oddEvenPrint),"odd-thread")
    fun startPrinting(){
        oddThread.start()
        evenThread.start()
        oddThread.join()
        evenThread.join()
    }
}