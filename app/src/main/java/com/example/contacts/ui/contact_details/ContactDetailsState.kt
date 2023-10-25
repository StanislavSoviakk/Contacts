package com.example.contacts.ui.contact_details

import com.example.contacts.base.BaseState
import com.example.contacts.domain.model.Contact

data class ContactDetailsState(
    val contact: Contact = Contact(),
    val isDeleteContactDialogExpanded: Boolean = false,
) : BaseState