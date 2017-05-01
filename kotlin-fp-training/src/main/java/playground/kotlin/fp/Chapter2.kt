package playground.kotlin.fp

object Chapter2 {

    fun factorial(n: Long): Long {
        tailrec fun factorial(accumulator: Long, n: Long): Long =
                if (n == 0L) accumulator
                else factorial(accumulator * n, n - 1)
        return factorial(1, n)
    }

    fun fibonacci(num: Long): Long {
        tailrec fun go(counter: Long, acc1: Long, acc2: Long): Long  =
            if (counter == 0L)  acc2
            else  go(counter - 1,acc1 + acc2, acc1)

        return go(num, 1L, 0L)
    }

    fun greetCurried(greet: String): (String) -> String {
        return fun(name: String): String {
            return greet + " " + name;
        }
    }

    fun sumCurried(f: (Int, Int) -> Int): (Int, Int) -> Int {
        return fun(a: Int,b: Int): Int {
            return f(a,b) + f(a,b)
        }
    }




}
