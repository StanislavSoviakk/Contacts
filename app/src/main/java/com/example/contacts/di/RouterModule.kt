package com.example.contacts.di

import com.example.contacts.base.Router
import com.example.contacts.base.RouterImpl
import org.koin.dsl.module

val routerModule = module {
    single<Router> {
        RouterImpl()
    }
}