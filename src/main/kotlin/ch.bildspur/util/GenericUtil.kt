package ch.bildspur.util

import kotlin.reflect.KClass

/* Convenience wrapper that allows you to call getValue<Type>() instead of of getValue(Type::class) */
inline fun <reified T: Any> getValue() : T? = getValue(T::class)

/* We have no way to guarantee that an empty constructor exists, so must return T? instead of T */
fun <T: Any> getValue(clazz: KClass<T>) : T? {
    clazz.constructors.forEach { con ->
        if (con.parameters.isEmpty()) {
            return con.call()
        }
    }
    return null
}