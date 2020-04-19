package ch.bildspur.model

import ch.bildspur.math.Float4
import ch.bildspur.math.clamp

/**
 * Four component color capped to range 0.0f to 1.0f
 */
class Color {
    private val minValue = 0.0f
    private val maxValue = 1.0f

    val raw : Float4

    constructor(v : Float) : this(v,1.0f)
    constructor(v : Float, a : Float) : this(v, v, v, a)
    constructor(r : Float = 0.0f, g : Float = 0.0f, b : Float = 0.0f, a : Float = 1.0f) : this(Float4(r, g, b, a))
    constructor(v : Float4) {
        raw = v
        clamp()
    }

    var red: Float
        get() = raw.r
        set(value) {
            raw.r = value
            clamp()
        }

    var green: Float
        get() = raw.g
        set(value) {
            raw.g = value
            clamp()
        }

    var blue: Float
        get() = raw.b
        set(value) {
            raw.b = value
            clamp()
        }

    var alpha: Float
        get() = raw.a
        set(value) {
            raw.a = value
            clamp()
        }

    operator fun get(index: Int) : Float {
        return raw[index]
    }

    operator fun set(index: Int, v: Float) {
        raw[index] = v
        clamp()
    }

    operator fun inc(): Color {
        raw.inc()
        return this.clamp()
    }

    operator fun dec(): Color {
        raw.dec()
        return this.clamp()
    }

    operator fun plus(v: Float)  = Color(raw + v).clamp()
    operator fun minus(v: Float) = Color(raw - v).clamp()
    operator fun times(v: Float) = Color(raw * v).clamp()
    operator fun div(v: Float) = Color(raw / v).clamp()

    operator fun plus(v: Color)  = Color(raw + v.raw).clamp()
    operator fun minus(v: Color) = Color(raw - v.raw).clamp()
    operator fun times(v: Color) = Color(raw * v.raw).clamp()
    operator fun div(v: Color) = Color(raw / v.raw).clamp()

    inline fun transform(block: (Float) -> Float): Color {
        raw.transform(block)
        return this.clamp()
    }

    fun clamp() : Color {
        raw.r = clamp(raw.r, minValue, maxValue)
        raw.g = clamp(raw.g, minValue, maxValue)
        raw.b = clamp(raw.b, minValue, maxValue)
        raw.a = clamp(raw.a, minValue, maxValue)
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Color

        if (raw != other.raw) return false

        return true
    }

    override fun hashCode(): Int {
        return raw.hashCode()
    }

    override fun toString(): String {
        return "Color(r=$red g=$green b=$blue a=$alpha)"
    }
}