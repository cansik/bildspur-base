package ch.bildspur.test

import ch.bildspur.collection.RingBuffer
import ch.bildspur.collection.batch
import ch.fhnw.exakt.util.BatchingSequence
import org.junit.Test

class CollectionTest {

    @Test
    fun batchingSequenceTest() {
        val numbers = sequenceOf(3, 5, 2, 6, 9, 3, 4, 6)
        val parts = numbers.batch(2)

        assert(parts.count() == 4)
        assert(parts.first()[0] == 3 && parts.first()[1] == 5)
    }

    @Test
    fun ringBufferTest() {
        val buffer = RingBuffer<Float>(10)
        buffer.add(20f)
        buffer.add(10f)

        buffer.forEach {
            println(it)
        }

        assert(buffer.size == 10)
        assert(buffer.elementCount == 2)
    }
}