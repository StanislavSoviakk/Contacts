package com.example.contacts.di

import com.example.contacts.preferences.PreferencesManager
import com.example.domain.PreferencesManagerRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single {
        PreferencesManager(context = androidContext())
    }
    single<PreferencesManagerRepository> {
        PreferencesManager(context = androidContext())
    }
}