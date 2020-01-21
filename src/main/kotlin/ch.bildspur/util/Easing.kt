@file:Suppress("NAME_SHADOWING")

package ch.bildspur.util

/**
 * Created by cansik on 08.06.17.
 */
object Easing {
    // t = current time, b = start value, c = change in value, d = duration
    fun easeInQuad(t: Float, b: Float, c: Float, d: Float): Float {
        var v = t
        v /= d
        return c * v * v + b
    }

    fun linearTween(t: Float, b: Float, c: Float, d: Float): Float {
        return c * t / d + b
    }

    fun easeOutQuad(t: Float, b: Float, c: Float, d: Float): Float {
        var v = t
        v /= d
        return -c * v * (v - 2) + b
    }

    fun easeInSine(t: Float, b: Float, c: Float, d: Float): Float {
        return Math.round(-c * Math.cos(t / d * (Math.PI / 2.0)) + c.toDouble() + b.toDouble()).toFloat()
    }

    fun easeOutSine(t: Float, b: Float, c: Float, d: Float): Float {
        return Math.round(c * Math.sin(t / d * (Math.PI / 2.0)) + b).toFloat()
    }
}