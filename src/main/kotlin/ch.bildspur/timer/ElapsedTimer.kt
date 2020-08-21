package ch.bildspur.timer

class ElapsedTimer(var duration : Long = 0, fireOnStart : Boolean = false) {
    var lastTimestamp = millis()
        private set

    init {
        if(fireOnStart)
            fire()
    }

    fun fire() {
        lastTimestamp = 0
    }

    fun elapsed() : Boolean {
        val m = millis()
        val result = (m - lastTimestamp) >= duration
        if(result)
            lastTimestamp = m
        return result
    }

    fun reset() {
        lastTimestamp = millis()
    }

    private fun millis() : Long
    {
        return System.currentTimeMillis()
    }
}