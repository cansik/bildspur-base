package ch.bildspur.test

import ch.bildspur.event.Event
import org.junit.Test

class EventTest {

    class Person {
        var age = 10

        val onBirthday = Event<Int>()

        fun aging() {
            onBirthday(++age)
        }
    }

    @Test
    fun eventTest() {
        val p = Person()
        var newage = 0

        p.onBirthday += {
            println("He is now: $it")
            newage = it
        }

        p.aging()

        assert(newage == 11)
    }
}