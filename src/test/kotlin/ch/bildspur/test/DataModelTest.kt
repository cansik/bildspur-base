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
}