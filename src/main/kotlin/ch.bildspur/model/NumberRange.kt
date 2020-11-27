package ch.bildspur.model

import com.google.gson.annotations.Expose

data class NumberRange(
        @Expose val low: Double,
        @Expose val high: Double) {

    /**
     * Map the number range to a specific percentage ratio.
     */
    fun map(ratio: Double): Double {
        return ((this.high - this.low) * ratio) + this.low
    }

    /**
     * Get the percentage ration of the input value in relation to the number range.
     */
    fun ratio(value : Double) : Double {
        return (value - this.low) / (this.high - this.low)
    }
}