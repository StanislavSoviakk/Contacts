package com.example.contacts.di

import com.example.core.base.Router
import com.example.core.base.RouterImpl
import org.koin.dsl.module

val routerModule = module {
    single<Router> {
        RouterImpl()
    }
}