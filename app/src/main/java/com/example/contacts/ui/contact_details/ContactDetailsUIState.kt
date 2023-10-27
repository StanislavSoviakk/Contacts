package com.example.contacts.ui.contact_details

import com.example.core.base.BaseState
import com.example.domain.contact_details.ContactDetailsState
import com.example.domain.model.Contact

data class ContactDetailsUIState(
    val contact: Contact = Contact(),
    val isDeleteContactDialogExpanded: Boolean = false,
) : BaseState

fun ContactDetailsState.toUIState(): ContactDetailsUIState {
    return ContactDetailsUIState(contact, isDeleteContactDialogExpanded)
}