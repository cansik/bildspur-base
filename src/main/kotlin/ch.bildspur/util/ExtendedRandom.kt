package ch.bildspur.util

import java.util.*
import kotlin.math.roundToInt

class ExtendedRandom @JvmOverloads constructor(seed: Long = System.currentTimeMillis()) {
    private val r: Random = Random(seed)

    fun randomBoolean(value: Float = 0.5f): Boolean {
        return randomFloat() <= value
    }

    fun randomFloat(min: Float = 0f, max: Float = 1f): Float {
        return min + r.nextFloat() * (max - min)
    }

    fun randomInt(min: Int = 0, max: Int = 1): Int {
        return randomFloat((min - 0.49999).toFloat(), (max + 0.49999).toFloat()).roundToInt()
    }
}