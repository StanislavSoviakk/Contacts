package com.example.contacts.ui.contacts

import com.example.contacts.ui.Screen
import com.example.contacts.ui.contacts.use_cases.FilterContactsUseCase
import com.example.contacts.ui.contacts.use_cases.LoadContactsUseCase
import com.example.core.base.BaseViewModel
import com.example.core.base.Router
import com.example.domain.model.Status

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
        filterContacts()
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
        filterContacts()
    }

    private fun filterContacts() {
        handleEvent(
            ContactsEvent.FilterContacts(
                state.value.searchText, state.value.selectedStatus
            )
        )
    }

    fun openAddContactScreen() {
        router.navigateTo(Screen.AddContactScreen.route)
    }

    fun openContactDetailsScreen(uuid: String) {
        router.navigateTo(Screen.ContactDetails.route + "/${uuid}")
    }

}