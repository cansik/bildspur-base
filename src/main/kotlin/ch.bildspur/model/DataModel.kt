package ch.bildspur.model

import ch.bildspur.event.Event
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by cansik on 09.06.17.
 */
class DataModel<T>(@Expose
                   @Volatile
                   @SerializedName("value", alternate = ["dataValue"])
                   private var dataValue: T) {
    val onChanged = Event<T>()
    private var publishActive = true

    var value: T
        get() = this.dataValue
        set(value) {
            val oldValue = dataValue
            dataValue = value

            // fire event if changed
            if (publishActive && dataValue != oldValue)
                fire()
        }

    fun setSilent(value: T) {
        publishActive = false
        this.value = value
        publishActive = true
    }

    fun fire() {
        onChanged(dataValue)
    }

    fun fireLatest() {
        onChanged.invokeLatest(dataValue)
    }

    fun bindTo(model: DataModel<T>) {
        this.onChanged += {
            publishActive = false
            model.value = value
            publishActive = true
        }
    }

    fun bindBidirectional(model: DataModel<T>) {
        this.bindTo(model)
        model.bindTo(this)
    }

    override fun toString(): String {
        return "DataModel ($value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataModel<*>

        if (dataValue != other.dataValue) return false

        return true
    }

    override fun hashCode(): Int {
        return dataValue?.hashCode() ?: 0
    }


}