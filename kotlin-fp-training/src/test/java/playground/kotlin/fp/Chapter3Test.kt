import playground.kotlin.fp.MyList.Factory.of
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import playground.kotlin.fp.*

class Chapter3Test {

    @Test
    fun sumTest() {
        assertThat(sumOfList(of(1,2,3,50)), equalTo(56))
    }

    @Test
    fun productTest() {
        assertThat(productOfList(of(1,2,8)), equalTo(16))
    }

    @Test
    fun sumTailRecTest() {
        assertThat(sum_tr(of(1,2,3,50)), equalTo(56))
    }

    @Test
    fun foldRightTest() {

        assertThat(foldRight(of(1,2,8)   ,1, { x, y -> x * y } ), equalTo(16))

        val foldLeftOfOne = foldLeft_curriedWith1();
        assertThat(foldLeftOfOne(of(1,2,8) , { x,y -> x * y } ), equalTo(16))

        assertThat(foldRight(of(1,2,3,50),0, { x, y -> x + y } ), equalTo(56))
    }

    @Test
    fun foldLeftTest() {
        assertThat(foldLeft(of(1,2,8)   ,1, { x, y -> x * y }), equalTo(16))
        assertThat(foldLeft(of(1,2,3,50),0, { x, y -> x + y }), equalTo(56))
    }

}
