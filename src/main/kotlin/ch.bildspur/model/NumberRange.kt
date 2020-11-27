package ch.bildspur.model

import com.google.gson.annotations.Expose

data class NumberRange(
        @Expose val low: Double,
        @Expose val high: Double) {

    fun map(t: Float): Float {
        return ((this.high - this.low).toFloat() * t) + this.low.toFloat()
    }
}