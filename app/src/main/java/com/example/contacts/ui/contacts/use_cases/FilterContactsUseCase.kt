package com.example.contacts.ui.contacts.use_cases

import com.example.contacts.base.UseCase
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status
import com.example.contacts.ui.contacts.ContactsEvent
import com.example.contacts.ui.contacts.ContactsState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class FilterContactsUseCase : UseCase<ContactsEvent, ContactsState> {
    override fun canHandle(event: ContactsEvent): Boolean = event is ContactsEvent.FilterContacts

    override suspend fun invoke(event: ContactsEvent, state: ContactsState): ContactsEvent {
        if (event is ContactsEvent.FilterContacts) {
            val filteredContacts: PersistentList<Contact> = state.contactsList.filter { contact ->
                val fullName = "${contact.firstName} ${contact.lastName}"
                fullName.contains(
                    state.searchText, ignoreCase = true
                ) && (contact.status == event.status || event.status == Status.NO_STATUS)

            }.toPersistentList()
            return ContactsEvent.ContactsFiltered(contacts = filteredContacts)
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}