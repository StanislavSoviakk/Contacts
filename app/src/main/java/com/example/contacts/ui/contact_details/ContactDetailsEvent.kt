package com.example.contacts.ui.contact_details

import com.example.contacts.base.BaseEvent
import com.example.contacts.domain.model.Contact

sealed interface ContactDetailsEvent : BaseEvent {
    data class LoadContact(val uuid: String) : ContactDetailsEvent
    data class ContactLoaded(val contact: Contact) : ContactDetailsEvent
    data class ChangeDeleteDialogState(val isExpanded: Boolean) : ContactDetailsEvent
    data class DeleteContact(val uuid: String) : ContactDetailsEvent
    object ContactDeleted : ContactDetailsEvent
}