package com.example.contacts.ui.contacts

import com.example.contacts.base.BaseEvent
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status

sealed interface ContactsEvent : BaseEvent {
    object LoadContacts : ContactsEvent
    data class ContactsLoaded(val contacts: List<Contact>) : ContactsEvent
    data class SelectStatus(val status: Status) : ContactsEvent
    data class ChangeFilterState(val isExpanded: Boolean) : ContactsEvent
    data class ChangeSearchText(val text: String) : ContactsEvent
    data class ContactsFiltered(val contacts: List<Contact>) : ContactsEvent
}