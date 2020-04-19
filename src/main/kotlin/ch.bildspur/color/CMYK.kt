package ch.bildspur.color

import com.google.gson.annotations.Expose
import kotlin.math.roundToInt

data class CMYK(@Expose val c: Int, @Expose val m: Int, @Expose val y: Int, @Expose val k: Int, @Expose val a: Float = 1f) : ConvertibleColor {
    init {
        require(c in 0..100) { "c must be in range [0, 100] in $this" }
        require(m in 0..100) { "m must be in range [0, 100] in $this" }
        require(y in 0..100) { "y must be in range [0, 100] in $this" }
        require(k in 0..100) { "k must be in range [0, 100] in $this" }
        require(a in 0f..1f) { "a must be in range [0, 1] in $this" }
    }

    override val alpha: Float get() = a

    override fun toRGB(): RGB {
        val c = this.c / 100.0
        val m = this.m / 100.0
        val y = this.y / 100.0
        val k = this.k / 100.0
        val r = 255 * (1 - c) * (1 - k)
        val g = 255 * (1 - m) * (1 - k)
        val b = 255 * (1 - y) * (1 - k)
        return RGB(r.roundToInt(), g.roundToInt(), b.roundToInt(), alpha)
    }

    override fun toCMYK() = this
}
