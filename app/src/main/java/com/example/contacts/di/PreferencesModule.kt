package com.example.contacts.di

import com.example.contacts.preferences.PreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single {
        PreferencesManager(context = androidContext())
    }
}