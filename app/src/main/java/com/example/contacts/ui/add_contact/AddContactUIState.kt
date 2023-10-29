package com.example.contacts.ui.add_contact

import com.example.domain.add_contact.AddContactState
import com.example.domain.model.Contact
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class AddContactUIState(
    val contactsList: PersistentList<Contact> = persistentListOf(),
    val isStatusDialogExpanded: Boolean = false,
    val selectedContact: Contact? = null
)


fun AddContactState.toUIState(): AddContactUIState {
    return AddContactUIState(contactsList, isStatusDialogExpanded, selectedContact)
}

