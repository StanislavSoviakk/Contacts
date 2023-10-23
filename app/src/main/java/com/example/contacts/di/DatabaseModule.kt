package com.example.contacts.di

import androidx.room.Room
import com.example.contacts.data.local.contacts.ContactsDatabase
import com.example.contacts.data.local.current_user.UserDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(), UserDatabase::class.java, "CurrentUser"
        ).build().dao
    }

    single {
        Room.databaseBuilder(
            androidContext(), ContactsDatabase::class.java, "contacts"
        ).build().dao
    }
}