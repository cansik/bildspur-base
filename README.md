# bildspur-base [![Build Status](https://travis-ci.org/cansik/bildspur-base.svg?branch=master)](https://travis-ci.org/cansik/bildspur-base)
A library with basic components for creative applications in kotlin. The idea is to combine all the necessary and usefull utils into one framework.

## Installation

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation "com.github.cansik:bildspur-base:0.2.0"
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
An event is a simplified observable pattern implementation. It is possible to register to an event through the `+=` operator.

This example shows how to create an event.

```kotlin
class Person {
    var age = 10
    
    val onBirthday = Event<Int>()
    
    fun aging() {
        onBirthday(age++)
    }
}
```

The following example shows how to sign to an event and be notified.

```kotlin
val p = Person()
p.onBirthday += {
    println("He is now: $it")
}
```

### Math

### Model

### Timer

### Util


## About

- Implementaion by Florian (bildspur)
- `math` package is adapted from Romain Guy.
- `color` package is adapted from [AJ Alt](https://github.com/ajalt/colormath)
