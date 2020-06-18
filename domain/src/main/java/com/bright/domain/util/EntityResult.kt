package com.bright.domain.util

sealed class EntityResult<out T : Any> {
    class Success<out T : Any>(val data: T) : EntityResult<T>()
    class Failure(val exception: Exception) : EntityResult<Nothing>()
}
