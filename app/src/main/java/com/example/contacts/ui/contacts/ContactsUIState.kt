package com.example.contacts.ui.contacts

import com.example.domain.contacts.ContactsState
import com.example.domain.model.Contact
import com.example.domain.model.Status
import kotlinx.collections.immutable.PersistentList

val initState = ContactsState()

data class ContactsUIState(
    val contactsList: PersistentList<Contact> = initState.contactsList,
    val selectedStatus: Status = initState.selectedStatus,
    val isFilterExpanded: Boolean = initState.isFilterExpanded,
    val filteredContacts: PersistentList<Contact>? = initState.filteredContacts,
    val searchText: String = initState.searchText,
)


fun ContactsState.toUIState(): ContactsUIState {
    return ContactsUIState(
        contactsList, selectedStatus, isFilterExpanded, filteredContacts, searchText
    )
}