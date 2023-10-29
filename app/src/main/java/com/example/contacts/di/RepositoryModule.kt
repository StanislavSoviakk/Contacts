package com.example.contacts.di

import com.example.data.repository.ContactsRepositoryImpl
import com.example.data.repository.CurrentUserRepositoryImpl
import com.example.domain.repository.ContactsRepository
import com.example.domain.repository.CurrentUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CurrentUserRepository> {
        CurrentUserRepositoryImpl(dao = get(), mapUserToContactEntity = get())
    }
    single<ContactsRepository> {
        ContactsRepositoryImpl(dao = get(), api = get(), mapContactToContactEntity = get())
    }
}