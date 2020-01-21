package ch.bildspur.model

import com.google.gson.annotations.Expose

data class NumberRange(
        @Expose val low: Double,
        @Expose val high: Double)