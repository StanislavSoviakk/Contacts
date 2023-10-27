package com.example.contacts.ui.contacts

import com.example.contacts.common.BaseViewModel
import com.example.contacts.common.Router
import com.example.contacts.ui.Screen
import com.example.domain.contacts.ContactsEvent
import com.example.domain.contacts.ContactsReducer
import com.example.domain.contacts.ContactsState
import com.example.domain.contacts.use_cases.FilterContactsUseCase
import com.example.domain.contacts.use_cases.LoadContactsUseCase
import com.example.domain.model.Status

class ContactsViewModel(
    loadContactsUseCase: LoadContactsUseCase,
    filterContactsUseCase: FilterContactsUseCase,
    val router: Router
) : BaseViewModel<ContactsEvent, ContactsState, ContactsUIState>(
    reducer = ContactsReducer(), useCasesList = listOf(loadContactsUseCase, filterContactsUseCase)
) {

    override val uiState: ContactsUIState
        get() = state.value.toUIState()

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