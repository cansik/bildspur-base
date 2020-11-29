package ch.bildspur.test

import ch.bildspur.util.*
import org.junit.Test

class EasingAndMappingTest {

    @Test
    fun easingTest() {
        for(i in 0..100) {
            val value = 0.01f * i
            val eased = Easing.EaseInOutQuad(value)
            println("In: $value Out: $eased")
        }
    }

    @Test
    fun mappingTest() {
        val mapping = Mapping.SCurve
        for(i in 0..100) {
            val value = 0.01 * i
            val mapped = mapping.mapping(value)
            val inverted = mapping.inverseMapping(mapped)

            println("In: $value Mapped: $mapped Inverted: $inverted")
            assert(value.isInMargin(inverted, 1.0E-8))
        }
    }

    @Test
    fun precisionTest1() {
        val x = 1234.12345678901
        assert(x.precision == 11)
    }

    @Test
    fun precisionTest2() {
        val x = 0.0000000000025
        assert(x.precision == 13)
    }

    @Test
    fun roundTest() {
        val x = 1234.12345678901
        assert(x.round(5) == 1234.12346)
    }
}