package fp.kotlin

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import playground.kotlin.fp.Chapter2.factorial
import playground.kotlin.fp.Chapter2.fibonacci
import playground.kotlin.fp.Chapter2.greetCurried
import playground.kotlin.fp.Chapter2.sumCurried


class Chapter2Test {


    @Test
    fun factorial0() {
        assertThat(factorial(0) , equalTo(1L))
    }
    @Test
    fun factorial1() {
        assertThat(factorial(1) , equalTo(1L))
    }
    @Test
    fun factorial2() {
        assertThat(factorial(2) , equalTo(2L))
    }
    @Test
    fun factorial3() {
        assertThat(factorial(3) , equalTo(6L))
    }
    @Test
    fun factorial5() {
        assertThat(factorial(5) , equalTo(120L))
    }

    @Test
    fun fibonacci() {
        assertThat("fibonacci 0 ",fibonacci(0),equalTo(0L))
        assertThat("fibonacci 1 ",fibonacci(1),equalTo(1L))
        assertThat("fibonacci 2 ",fibonacci(2),equalTo(1L))
        assertThat("fibonacci 3 ",fibonacci(3),equalTo(2L))
        assertThat("fibonacci 4 ",fibonacci(4),equalTo(3L))
        assertThat("fibonacci 5 ",fibonacci(5),equalTo(5L))
        assertThat("fibonacci 6 ",fibonacci(6),equalTo(8L))
    }

    @Test
    fun greetCurried() {
        val greet = greetCurried("Ciao")
        assertThat(greet("Mario"), equalTo("Ciao Mario"))
        assertThat(greet("Franco"), equalTo("Ciao Franco"))
    }

    @Test
    fun curriedSumOfFunctions() {

        val sf = sumCurried({ x, y -> x * y})
        assertThat(sf(2,3), equalTo(12))
    }

}

