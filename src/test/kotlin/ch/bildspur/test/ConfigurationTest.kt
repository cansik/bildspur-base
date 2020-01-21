package ch.bildspur.test

import ch.bildspur.configuration.ConfigurationController
import ch.bildspur.model.DataModel
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