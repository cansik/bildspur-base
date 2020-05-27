package ch.bildspur.test

import ch.bildspur.color.RGB
import ch.bildspur.configuration.ConfigurationController
import ch.bildspur.model.DataModel
import ch.bildspur.model.ListDataModel
import com.google.gson.annotations.Expose
import org.junit.Test
import java.nio.file.Files

class ConfigurationTest {
    private val configController = ConfigurationController("Test", "bildspur", "test")

    class AppConfig {
        @Expose
        var name = "Hello World"

        @Expose
        var age = 15

        @Expose
        var humidity = DataModel(88.4)

        @Expose
        var color = DataModel(RGB(0.2f, 0.3f, .5f))

        @Expose
        val list = ListDataModel(mutableListOf(2, 3))

        @Expose
        val richList = ListDataModel(mutableListOf(
                DataModel("Max"),
                DataModel("Muster")
        ))
    }

    @Test
    fun createConfigTest() {
        val config = AppConfig()
        configController.saveAppConfig(config)

        assert(Files.exists(configController.configurationFile))
    }

    @Test
    fun loadConfigTest() {
        val config = configController.loadAppConfig<AppConfig>()
        assert(config.name == "Hello World")
    }
}