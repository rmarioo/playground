
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import playground.kotlin.fp.*
import playground.kotlin.fp.Either.Error
import playground.kotlin.fp.Either.Value

class Chapter4Test {


    @Test
    fun mapAValue() {
        val result = Value(5)
                .map { x -> "*** " + x.toString() + " ***" }
                .fold({ it }, { "errore: $it" })

        assertThat(result, equalTo("*** 5 ***"))
    }

    @Test
    fun mapAnError() {
        val result = Error(IllegalArgumentException("wrong input parameter"))
                .map { x -> "*** " + x.toString() + " ***" }
                .fold({ it }, { exception -> "errore: " + exception.message })

        assertThat(result, equalTo("errore: wrong input parameter"))
    }

    @Test
    fun mapAValue_getOrThrow() {
        val result = Value(5)
                .map { x -> "*** " + x.toString() + " ***" }
                .getOrThrow();

        assertThat(result, equalTo("*** 5 ***"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun mapAnError_getOrThrow() {

        Error(IllegalArgumentException("wrong input parameter"))
                .map { x -> "*** " + x.toString() + " ***" }
                .getOrThrow()
    }

    @Test
    fun toInt_ok() {

        val fold = myToInt("54").fold({ it -> "il numero convertito in intero e' $it" },
                { exc -> "errore convertendo in intero " + exc.message })
        assertThat(fold, equalTo("il numero convertito in intero e' 54"))
    }

    @Test
    fun toInt_ko() {

        val fold = myToInt("xyz").fold({ it -> "il numero convertito in intero e' $it" },
                { exc -> "errore convertendo in intero " + exc.message })
        assertThat(fold, equalTo("errore convertendo in intero For input string: \"xyz\""))
    }

    @Test
    fun flatMap_and_map_ok() {

        assertThat(sampleFlatMap("44",2), equalTo("il risultato della conversione e' {{ 22 }}"))
    }

    @Test
    fun flatMap_and_map_ko() {

        assertThat(sampleFlatMap("44", 0), equalTo("errore convertendo in intero / by zero"))
    }

    private fun sampleFlatMap(str: String, div: Int): String
    {
        return   Try     { str.toInt() }
                .flatMap { x -> Try { x / div } }
                .map     { x -> "{{ $x }}" }

                .fold(   { it -> "il risultato della conversione e' $it" },
                         { exc -> "errore convertendo in intero " + exc.message })
    }
}
