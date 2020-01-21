package ch.bildspur.util

import ch.fhnw.exakt.util.BatchingSequence
import java.util.ArrayList

/**
 * Returns a single list of all elements from all arrays in the given array.
 */
fun <T> Array<out Array<out T>>.flatten(): List<T> {
    val result = ArrayList<T>(sumBy { it.size })
    for (element in this) {
        result.addAll(element)
    }
    return result
}

fun <T> Sequence<T>.batch(n: Int): Sequence<List<T>> {
    return BatchingSequence(this, n)
}