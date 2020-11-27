package ch.bildspur.test

import ch.bildspur.util.Easing
import ch.bildspur.util.Mapping
import ch.bildspur.util.isInMargin
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
}