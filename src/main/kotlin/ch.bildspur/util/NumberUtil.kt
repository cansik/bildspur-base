package ch.bildspur.util

import kotlin.math.roundToInt

/**
 * Created by cansik on 04.02.17.
 */
fun Number.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

fun Float.isApproximate(value: Double, error: Double): Boolean {
    return (Math.abs(Math.abs(this) - Math.abs(value)) < error)
}

fun Float.limit(min: Float, max: Float): Float {
    return Math.max(Math.min(max, this), min)
}

fun Float.map(start1: Float, stop1: Float, start2: Float, stop2: Float): Float {
    return start2 + (stop2 - start2) * ((this - start1) / (stop1 - start1))
}

fun Long.formatSeconds(): String {
    return (this / 1000.0).format(2)
}

fun Int.map(start1: Int, stop1: Int, start2: Int, stop2: Int): Int {
    return this.toDouble().map(
            start1.toDouble(),
            stop1.toDouble(),
            start2.toDouble(),
            stop2.toDouble()
    ).roundToInt()
}

fun Double.map(start1: Double, stop1: Double, start2: Double, stop2: Double): Double {
    return start2 + (stop2 - start2) * ((this - start1) / (stop1 - start1))
}

fun Double.isBetween(low: Double, high: Double): Boolean {
    return low < this && this < high
}

fun Double.isInMargin(limit: Double, margin: Double): Boolean {
    return this.isBetween(limit - margin, limit + margin)
}

fun Boolean.toFloat(): Float {
    return if (this) 1f else 0f
}

fun Boolean.toSign(): Int {
    return if (this) 1 else -1
}

fun Boolean.toInvertSign(): Int {
    return if (this) -1 else 1
}

fun Boolean.toInt(): Int {
    return if (this) 1 else 0
}