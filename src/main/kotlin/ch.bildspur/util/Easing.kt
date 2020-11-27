package ch.bildspur.util

import ch.bildspur.math.pow
import kotlin.math.cos
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * All easings are visualized here:
 * https://easings.net/
 */
enum class Easing(val method: (Float) -> Float) {
    Linear({ it }),

    EaseInSine({ 1 - cos((it * PI) / 2f).toFloat() }),
    EaseOutSine({ sin((it * PI) / 2f).toFloat() }),
    EaseInOutSine({ (-(cos(PI * it) - 1) / 2f).toFloat() }),

    EaseInQuad({ it * it }),
    EaseOutQuad({ it * (2 - it) }),
    EaseInOutQuad({ if (it < .5) 2 * it * it else -1 + (4 - 2 * it) * it }),

    EaseInCubic({ it * it * it }),
    EaseOutCubic({ var t = it; (--t) * t * t + 1 }),
    EaseInOutCubic({ if (it < .5) 4 * it * it * it else (it - 1) * (2 * it - 2) * (2 * it - 2) + 1 }),

    EaseInQuart({ it * it * it * it }),
    EaseOutQuart({ var t = it; 1 - (--t) * t * t * t }),
    EaseInOutQuart({ var t = it; if (t < .5) 8 * t * t * t * t else 1 - 8 * (--t) * t * t * t }),

    EaseInQuint({ it * it * it * it * it }),
    EaseOutQuint({ var t = it; 1 + (--t) * t * t * t * t }),
    EaseInOutQuint({ var t = it; if (t < .5) 16 * t * t * t * t * t else 1 + 16 * (--t) * t * t * t * t }),

    EaseInExponential({ if (it == 0f) 0f else pow(2f, 10 * it - 10) }),
    EaseOutExponential({ if (it == 1f) 1f else 1 - pow(2f, -10 * it) }),
    EaseInOutExponential(
            {
                when (it) {
                    0f -> 0f
                    1f -> 1f
                    else -> if (it < 0.5f) pow(2f, 20 * it - 10) / 2f else (2 - pow(2f, -20 * it + 10)) / 2f
                }
            }),

    EaseInCircular({ 1 - sqrt(1 - pow(it, 2f)) }),
    EaseOutCircular({ sqrt(1 - pow(it - 1, 2f)) }),
    EaseInOutCircular({ if (it < 0.5) (1 - sqrt(1 - pow(2 * it, 2f))) / 2 else (sqrt(1 - pow(-2 * it + 2, 2f)) + 1) / 2 }),
    ;

    operator fun invoke(t: Float): Float {
        return method(t)
    }
}