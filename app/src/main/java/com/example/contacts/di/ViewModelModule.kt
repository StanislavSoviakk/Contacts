package com.example.contacts.di

import com.example.contacts.ui.create_user.CreateUserViewModel
import com.example.contacts.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CreateUserViewModel(saveUserUseCase = get()) }
    viewModel { MainViewModel(preferencesManager = get()) }
}