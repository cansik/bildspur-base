package ch.bildspur.test

import ch.bildspur.util.Easing
import ch.bildspur.util.Mapping
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
        val mapping = Mapping.Linear
        val value = 0.2

        val mapped = mapping.mapping(value)
        val inverted = mapping.inverseMapping(mapped)

        assert(mapped == inverted)
    }
}