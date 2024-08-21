package threading

import java.util.concurrent.locks.ReentrantLock


class Producer(private val buffer: MutableList<String>, private val reentrantLock : ReentrantLock) : Runnable {
    override fun run() {
        val numbers = arrayOf("1", "2", "3", "4", "5")
        for (number in numbers) {
                reentrantLock.lock()
                buffer.add(number)
                println("${Thread.currentThread().name} added number $number")
                reentrantLock.unlock()

        }
        println("${Thread.currentThread().name} added eof")
        reentrantLock.lock()
        buffer.add(ProducerConsumerMain.EOF)
        reentrantLock.unlock()
    }

}

class Consumer(private val buffer: MutableList<String>,private val reentrantLock : ReentrantLock) : Runnable {
    override fun run() {
        while (true) {
                reentrantLock.lock()
                if (buffer.isEmpty()) return
                if (buffer.get(0) == ProducerConsumerMain.EOF) {
                    println("${Thread.currentThread().name} exiting")
                } else {
                    val element = buffer.removeAt(0)
                    println("${Thread.currentThread().name} removed $element")
                }
                reentrantLock.unlock()
        }
    }

}

class ProducerConsumerMain {
    val buffer = mutableListOf<String>()
    val reentrantLock  = ReentrantLock(true)
    fun testMultiThread(){
        val produceThread = Thread(Producer(buffer,reentrantLock))
        produceThread.name = "producerThread"

        val consumerThread1 = Thread(Consumer(buffer,reentrantLock))
        consumerThread1.name = "consumerThread1"

        val consumerThread2 = Thread(Consumer(buffer,reentrantLock))
        consumerThread2.name = "consumerThread2"

        produceThread.start()
        consumerThread1.start()
        consumerThread2.start()

    }

    companion object {
        const val EOF = "eof"
    }
}