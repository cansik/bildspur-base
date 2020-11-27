package ch.bildspur.util

enum class Mapping(val mapping: (Double) -> Double, val inverseMapping: (Double) -> Double) {
    Linear({it}, {it})
}