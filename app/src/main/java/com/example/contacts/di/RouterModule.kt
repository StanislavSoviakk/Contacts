package com.example.contacts.di

import com.example.contacts.common.Router
import com.example.contacts.common.RouterImpl
import org.koin.dsl.module

val routerModule = module {
    single<Router> {
        RouterImpl()
    }
}