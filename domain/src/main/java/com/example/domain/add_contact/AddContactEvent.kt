package com.example.domain.add_contact

import com.example.core.base.BaseEvent
import com.example.domain.model.Contact
import kotlinx.collections.immutable.PersistentList

sealed interface AddContactEvent : BaseEvent {
    object LoadContacts : AddContactEvent
    data class ContactsLoaded(val contacts: PersistentList<Contact>) : AddContactEvent
    data class ChangeStatusDialogState(val isExpanded: Boolean) : AddContactEvent
    data class SaveContact(val contact: Contact) : AddContactEvent
    object ContactSaved : AddContactEvent
    data class SelectContact(val contact: Contact) : AddContactEvent
}