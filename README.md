# bildspur-base [![Build Status](https://travis-ci.org/cansik/bildspur-base.svg?branch=master)](https://travis-ci.org/cansik/bildspur-base)
A library with basic components for creative applications in kotlin. The idea is to combine all the necessary and usefull utils into one framework.

## Installation

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation "com.github.cansik:bildspur-base:0.1.0"
}
```

## Examples
Here you find examples on how to use the different utilities. It is meant to give you an overview and is not a complete registry.

### Collection
#### Batching Sequence
Split a sequence of elements into different batches.

```kotlin
val numbers = sequenceOf(3, 5, 2, 6, 9, 3, 4, 6)
val parts = numbers.batch(2)

// parts = [[3, 5] [2, 6], [9, 3] [4, 6]]
```

#### Ring Buffer
A simple generic ringbuffer implementation which also works with iteration.

```kotlin
val buffer = RingBuffer<Float>(10)
buffer.add(20f)
buffer.add(10f)

buffer.forEach { 
    println(it)
}
```

### Configuration
To load and store configurations, there is a `ConfigurationController` which helps to serialize and deserialize complex objects with JSON. The configuration will be stored in the user home directory, in an app specific folder.

#### Configuration
A basic configuration is a class with fields. Each field with the annotation `Expose` will be serialized into JSON.

```kotlin
class AppConfig {
    @Expose
    var name = "Hello World"

    @Expose
    var age = 15

    @Expose
    var humidity = DataModel(88.4)
}
```

#### Controller
The controller handles loading and storing of the configuration class. It requiers following arguments:

- App Name
- Publisher Name
- App URI

```kotlin
val configController = ConfigurationController("Test", "bsp", "test")

// save
val config = AppConfig()
configController.saveAppConfig(config)

// load
val config = configController.loadAppConfig<AppConfig>()
```

### Event

### Math

### Model

### Timer

### Util


## About

- Implementaion by Florian (bildspur)
- `math` package is adapted from Romain Guy.
