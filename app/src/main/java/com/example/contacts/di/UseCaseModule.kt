package com.example.contacts.di

import com.example.contacts.ui.create_user.use_cases.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        SaveUserUseCase(currentUserRepository = get(), preferencesManager = get())
    }
}