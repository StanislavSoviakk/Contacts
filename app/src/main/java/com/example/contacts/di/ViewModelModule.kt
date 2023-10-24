package com.example.contacts.di

import com.example.contacts.ui.add_contact.AddContactViewModel
import com.example.contacts.ui.contacts.ContactsViewModel
import com.example.contacts.ui.create_user.EditProfileViewModel
import com.example.contacts.ui.main.MainViewModel
import com.example.contacts.ui.profile_screen.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        EditProfileViewModel(
            router = get(),
            saveUserUseCase = get(),
            loadUserUseCase = get()
        )
    }
    viewModel { MainViewModel(preferencesManager = get(), router = get()) }
    viewModel { ProfileViewModel(router = get(), loadUserUseCase = get()) }
    viewModel { ContactsViewModel(loadContactsUseCase = get(), filterContactsUseCase = get(), router = get()) }
    viewModel { AddContactViewModel(loadRandomContactsUseCase = get(), saveContactUseCase = get(), router = get())}
}