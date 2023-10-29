package com.example.domain.contacts

import com.example.core.base.Reducer

class ContactsReducer : Reducer<ContactsState, ContactsEvent> {
    override val initState: ContactsState
        get() = ContactsState()

    override fun reduce(event: ContactsEvent, state: ContactsState): ContactsState {
        return when (event) {
            is ContactsEvent.ContactsLoaded -> state.copy(contactsList = event.contacts)
            is ContactsEvent.LoadContacts -> state
            is ContactsEvent.SelectStatus -> state.copy(selectedStatus = event.status)
            is ContactsEvent.ChangeFilterState -> state.copy(isFilterExpanded = event.isExpanded)
            is ContactsEvent.ChangeSearchText -> state.copy(searchText = event.text)
            is ContactsEvent.FilterContacts -> state
            is ContactsEvent.ContactsFiltered -> state.copy(filteredContacts = event.contacts)
        }
    }
}