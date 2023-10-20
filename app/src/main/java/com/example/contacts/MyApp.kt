package com.example.contacts

import android.app.Application
import com.example.contacts.di.databaseModule
import com.example.contacts.di.preferencesModule
import com.example.contacts.di.repositoryModule
import com.example.contacts.di.useCaseModule
import com.example.contacts.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(viewModelModule, useCaseModule, repositoryModule, databaseModule, preferencesModule)
        }
    }
}