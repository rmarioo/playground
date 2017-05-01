package playground.kotlin.fp

sealed class Either<out E, out V> {
     class Error<out E>(val error: E) : playground.kotlin.fp.Either<E, Nothing>()
     class Value<out V>(val value: V) : playground.kotlin.fp.Either<Nothing, V>()
}

fun <V> value(value: V): playground.kotlin.fp.Either<Nothing, V> = playground.kotlin.fp.Either.Value(value)
fun <E> error(value: E): playground.kotlin.fp.Either<E, Nothing> = playground.kotlin.fp.Either.Error(value)

fun <V> Try(action: () -> V): playground.kotlin.fp.Either<Exception, V> =
        try {
            playground.kotlin.fp.value(action())
        } catch (e: Exception) {
            playground.kotlin.fp.error(e)
        }

inline infix fun <E, V, V2> playground.kotlin.fp.Either<E, V>.map(f: (V) -> V2): playground.kotlin.fp.Either<E, V2> =
        when (this) {
            is playground.kotlin.fp.Either.Error -> this
            is playground.kotlin.fp.Either.Value -> playground.kotlin.fp.Either.Value(f(this.value))
        }

inline fun <E, V, A> playground.kotlin.fp.Either<E, V>
        .fold(v: (V) -> A, e: (E) -> A): A = when(this) {
    is playground.kotlin.fp.Either.Value -> v(this.value)
    is playground.kotlin.fp.Either.Error -> e(this.error)
}

inline infix fun <E, V, V2> playground.kotlin.fp.Either<E, V>
        .flatMap(f: (V) -> playground.kotlin.fp.Either<E, V2>): playground.kotlin.fp.Either<E, V2> = when(this) {
    is playground.kotlin.fp.Either.Error -> this
    is playground.kotlin.fp.Either.Value -> f(value)
}

infix fun <E, V, V2> playground.kotlin.fp.Either<E, (V) -> V2>
        .apply(f: playground.kotlin.fp.Either<E, V>): playground.kotlin.fp.Either<E, V2> = when(this) {
    is playground.kotlin.fp.Either.Error -> this
    is playground.kotlin.fp.Either.Value -> f.map(this.value)
}

inline fun <V> playground.kotlin.fp.Either<Exception, V>.getOrThrow(): V =
        when (this) {
            is playground.kotlin.fp.Either.Error -> throw this.error
            is playground.kotlin.fp.Either.Value -> this.value
        }


fun myToInt(str: String): playground.kotlin.fp.Either<Exception, Int> =
        playground.kotlin.fp.Try { str.toInt() }
