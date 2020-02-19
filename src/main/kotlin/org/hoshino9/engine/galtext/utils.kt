package org.hoshino9.engine.galtext

fun <T> MutableList<T>.removeLast(): T {
    return removeAt(lastIndex)
}