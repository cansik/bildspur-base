package ch.bildspur.test

import ch.bildspur.configuration.ConfigurationController
import ch.bildspur.model.DataModel
import com.google.gson.annotations.Expose
import org.junit.Test
import java.nio.file.Files

class DataModelTest {

    @Test
    fun dataModelEqualityTest() {
        val first = DataModel(20)
        val second = DataModel(20)

        assert(first == second)
    }

    @Test
    fun unidirectionalBindingTest() {
        val first = DataModel(20)
        val second = DataModel(20)

        first.bindTo(second)
        first.value = 13

        assert(first == second)
    }

    @Test
    fun unidirectionalNotEqualBindingTest() {
        val first = DataModel(20)
        val second = DataModel(20)

        first.bindTo(second)
        first.value = 13
        second.value++

        assert(first.value == 13 && second.value == 14)
    }

    @Test
    fun bidirectionalBindingTest() {
        val first = DataModel(20)
        val second = DataModel(20)

        first.bindBidirectional(second)
        first.value = 13
        second.value = 25

        assert(first == second)
    }
}