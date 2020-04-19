package ch.bildspur.test

import ch.bildspur.color.RGB
import org.junit.Test

class ColorTest {

    @Test
    fun basicColorTest() {
        val red = RGB(0.8, 0.1, 0.1)
        val green = RGB(0.3, 0.1, 0.8)
        val magenta = red + green

        print(magenta)
    }
}