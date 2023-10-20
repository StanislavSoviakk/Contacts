package com.example.contacts.di

import com.example.contacts.ui.create_user.use_cases.LoadUserEditableProfileUseCase
import com.example.contacts.ui.create_user.use_cases.SaveUserUseCase
import com.example.contacts.ui.profile_screen.use_cases.LoadUserNonEditableProfileUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        SaveUserUseCase(currentUserRepository = get(), preferencesManager = get())
    }
    single {
        LoadUserEditableProfileUseCase(currentUserRepository = get())
    }
    single {
        LoadUserNonEditableProfileUseCase(currentUserRepository = get())
    }
}