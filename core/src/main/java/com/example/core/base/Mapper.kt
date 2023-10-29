package com.example.core.base

fun interface Mapper<T, R> {
    operator fun invoke(value: T): R
}