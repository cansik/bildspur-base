package ch.bildspur.test

import ch.bildspur.util.Easing
import org.junit.Test

class EasingTest {

    @Test
    fun easingTest() {
        for(i in 0..100) {
            val value = 0.01f * i
            val eased = Easing.EaseInOutQuad(value)
            println("In: $value Out: $eased")
        }
    }
}