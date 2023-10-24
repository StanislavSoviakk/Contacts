package com.example.contacts.ui.contacts

import com.example.contacts.base.BaseViewModel
import com.example.contacts.base.Router
import com.example.contacts.domain.model.Status
import com.example.contacts.ui.Screen
import com.example.contacts.ui.contacts.use_cases.FilterContactsUseCase
import com.example.contacts.ui.contacts.use_cases.LoadContactsUseCase

class ContactsViewModel(
    loadContactsUseCase: LoadContactsUseCase,
    filterContactsUseCase: FilterContactsUseCase,
    val router: Router
) : BaseViewModel<ContactsEvent, ContactsState>(
    reducer = ContactsReducer(), useCasesList = listOf(loadContactsUseCase, filterContactsUseCase)
) {

    init {
        getContacts()
    }

    private fun getContacts() {
        handleEvent(ContactsEvent.LoadContacts)
    }

    fun selectStatus(status: Status) {
        handleEvent(ContactsEvent.SelectStatus(status))
        collapseFilterMenu()
    }

    fun collapseFilterMenu() {
        handleEvent(ContactsEvent.ChangeFilterState(isExpanded = false))
    }

    fun expandFilterMenu() {
        handleEvent(ContactsEvent.ChangeFilterState(isExpanded = true))
    }

    fun changeSearchText(text: String) {
        handleEvent(ContactsEvent.ChangeSearchText(text))
    }

    fun openAddContactScreen() {
        router.navigateTo(Screen.AddContactScreen.route)
    }
}