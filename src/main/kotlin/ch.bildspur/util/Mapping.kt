package ch.bildspur.util

import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.pow

enum class Mapping(val mapping: (Double) -> Double, val inverseMapping: (Double) -> Double) {
    Linear({ it }, { it }),
    SCurve({ 0.5 - cos(it * PI) * 0.5; }, { acos(-2 * (it - 0.5)) / PI }),
    Quad({ it.pow(2.0) }, { it.pow(1.0 / 2.0) }),
    Cube({ it.pow(3.0) }, { it.pow(1.0 / 3.0) }),
    Quart({ it.pow(4.0) }, { it.pow(1.0 / 4.0) }),
    Quint({ it.pow(5.0) }, { it.pow(1.0 / 5.0) }),
    ;
}