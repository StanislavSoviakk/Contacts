package com.example.contacts.di

import com.example.contacts.ui.add_contact.use_cases.LoadRandomContactsUseCase
import com.example.contacts.ui.add_contact.use_cases.SaveContactUseCase
import com.example.contacts.ui.contact_details.use_cases.DeleteContactUseCase
import com.example.contacts.ui.contact_details.use_cases.LoadContactUseCase
import com.example.contacts.ui.contacts.use_cases.FilterContactsUseCase
import com.example.contacts.ui.contacts.use_cases.LoadContactsUseCase
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
    single {
        LoadContactsUseCase(contactsRepository = get())
    }
    single {
        FilterContactsUseCase()
    }
    single {
        LoadRandomContactsUseCase(contactsRepository = get())
    }
    single {
        SaveContactUseCase(contactsRepository = get())
    }
    single {
        LoadContactUseCase(contactsRepository = get())
    }
    single {
        DeleteContactUseCase(contactsRepository = get())
    }
}