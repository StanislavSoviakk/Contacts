package com.example.contacts.di

import com.example.data.mapper.MapContactToContactEntity
import com.example.data.mapper.MapUserToContactEntity
import org.koin.dsl.module

val mappersModule = module {
    single { MapContactToContactEntity() }
    single { MapUserToContactEntity() }
}