package ch.bildspur.test

import ch.bildspur.model.Color
import org.junit.Test

class ColorTest {

    @Test
    fun basicColorTest() {
        val red = Color(1.0f, 0.0f, 0.0f)
        val blue = Color(0.0f, 0.0f, 1.0f)

        var magenta = red + blue
        magenta *= 0.2f

        print(magenta)
    }
}