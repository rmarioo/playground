package playground.kotlin.coroutines

import kotlinx.coroutines.experimental.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

object PlaygroundCorutines {

    @JvmStatic
    fun main(args: Array<String>) {
        addOneMillionNumbers_withCoroutines()
    }

    private fun addOneMillionNumbers_withCoroutines() {
        println("starting!")

        val deferred = (1..1_000_000).map { n ->
            async (CommonPool) {
                n
            }
        }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            println("Sum: $sum")
        }    }
    private fun addOneMillionNumbers_withThreads() {
        println("starting!")
        val c = AtomicInteger()

        for (i in 1..1_000_000)
            thread(start = true) {
                c.addAndGet(i)
            }

        println(c.get())
    }



    private fun helloSample() {
        println("Start")

        // Start a coroutine
        launch(CommonPool) {
            delay(1000)
            println("Hello")
        }

        Thread.sleep(2000) // wait for 2 seconds
        println("Stop")
    }
}