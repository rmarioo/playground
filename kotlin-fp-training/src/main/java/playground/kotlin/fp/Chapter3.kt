package playground.kotlin.fp

sealed class MyList<out T> {
    object Nil : MyList<Nothing>()
    class  Cons<T>(val head: T, val tail: MyList<T>) : MyList<T>()

    companion object Factory {

        fun <T> of(vararg ts: T): MyList<out T> {
            var result : MyList<T> = Nil
            for (t in ts)
                result = Cons(t, result)
            return result
        }

    }

}


fun sumOfList(list: MyList<Int>): Int {
    return when (list) {
        is MyList.Nil -> 0
        is MyList.Cons -> list.head + sumOfList(list.tail)
    }
}

fun productOfList(list: MyList<Int>): Int =
        when(list) {
            is MyList.Nil -> 1
            is MyList.Cons -> list.head * productOfList(list.tail)
        }


fun foldRight(list: MyList<Int>, acc: Int, f: (Int, Int) -> Int): Int =
    when(list) {
        is MyList.Nil -> acc
        is MyList.Cons -> f(list.head, foldRight(list.tail, acc, f))
    }


fun sum_tr(list: MyList<Int>): Int {
    fun loop(list: MyList<Int>, acc: Int): Int =
            when (list) {
                is MyList.Nil -> acc
                is MyList.Cons -> loop(list.tail, list.head + acc)
            }
    return loop(list, 0)
}


tailrec
fun foldLeft(list: MyList<Int>, acc: Int, f: (Int, Int) -> Int): Int =
    when(list) {
        is MyList.Nil -> acc
        is MyList.Cons -> foldLeft(list.tail, f(list.head, acc), f)
    }

fun foldLeft_curriedWith1(): (list: MyList<Int>, f: (Int, Int) -> Int) -> Int {
    return fun(list: MyList<Int>, f: (Int, Int) -> Int): Int {
        return foldLeft(list, 1, f)
    }
}

fun main(args: Array<String>) {

    val list1 = MyList.of(1, 2, 3, 50)
    println(list1)
    println(sumOfList(list1))
}