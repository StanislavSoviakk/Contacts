package com.example.contacts.di

import com.example.contacts.data.repository.ContactsRepositoryImpl
import com.example.contacts.data.repository.CurrentUserRepositoryImpl
import com.example.contacts.domain.repository.ContactsRepository
import com.example.contacts.domain.repository.CurrentUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CurrentUserRepository> {
        CurrentUserRepositoryImpl(dao = get())
    }
    single<ContactsRepository> {
        ContactsRepositoryImpl(dao = get(), api = get())
    }
}