package com.example.contacts.di

import androidx.room.Room
import com.example.contacts.data.local.UserDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(), UserDatabase::class.java, "CurrentUser"
        ).build().dao
    }
}