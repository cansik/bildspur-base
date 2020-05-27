package ch.bildspur.configuration

import ch.bildspur.model.DataModel
import ch.bildspur.model.ListDataModel
import ch.bildspur.util.getValue
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.InstanceCreator
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


/**
 * Created by cansik on 11.07.17.
 */
class ConfigurationController(appName: String, publisherName: String, appUri: String) {
    val configurationFileName = "$appName.json"
    val configurationPath: Path = Paths.get(System.getProperty("user.home"), ".$publisherName", appUri)
    val configurationFile: Path = Paths.get(configurationPath.toString(), configurationFileName)

    val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(DataModel::class.java, DataModelInstanceCreator())
            .registerTypeAdapter(ListDataModel::class.java, ListDataModelInstanceCreator())
            .registerTypeAdapterFactory(PostProcessingEnabler())
            .create()

    init {
        if (!Files.exists(configurationPath)) {
            Files.createDirectories(configurationPath)
        }
    }

    inline fun <reified T : Any> loadAppConfig(): T {
        if (!Files.exists(configurationFile)) {
            val config = getValue(T::class)

            if (config != null)
                saveAppConfig(config)
        }

        return loadData(configurationFile)
    }

    fun saveAppConfig(config: Any) {
        saveData(configurationFile, config)
    }

    inline fun <reified T : Any> loadData(configFile: Path): T {
        val content = String(Files.readAllBytes(configFile))
        return gson.fromJson(content)
    }

    inline fun <reified T : Any> saveData(configFile: Path, config: T) {
        val content = gson.toJson(config)
        Files.write(configFile, content.toByteArray())
    }

    private inner class DataModelInstanceCreator : InstanceCreator<DataModel<*>> {
        override fun createInstance(type: Type): DataModel<*> {
            val typeParameters = (type as ParameterizedType).actualTypeArguments
            val defaultValue = typeParameters[0]
            return DataModel(defaultValue as Class<*>)
        }
    }

    private inner class ListDataModelInstanceCreator : InstanceCreator<ListDataModel<*>> {
        override fun createInstance(type: Type): ListDataModel<*> {
            val typeParameters = (type as ParameterizedType).actualTypeArguments
            val defaultValue = typeParameters[0]

            val list = ListDataModel(mutableListOf(defaultValue as Class<*>))
            list.clear()
            return list
        }
    }
}