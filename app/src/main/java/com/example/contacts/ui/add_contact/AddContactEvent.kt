package com.example.contacts.ui.add_contact

import com.example.contacts.base.BaseEvent
import com.example.contacts.domain.model.Contact
import kotlinx.collections.immutable.PersistentList

sealed interface AddContactEvent : BaseEvent {
    object LoadContacts : AddContactEvent
    data class ContactsLoaded(val contacts: PersistentList<Contact>) : AddContactEvent
    data class ChangeStatusDialogState(val isExpanded: Boolean) : AddContactEvent
    data class SaveContact(val contact: Contact) : AddContactEvent
    object ContactSaved : AddContactEvent
    data class SelectContact(val contact: Contact) : AddContactEvent
}