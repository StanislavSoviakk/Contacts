package com.example.contacts.ui.contact_details

import com.example.core.base.BaseState
import com.example.domain.model.Contact

data class ContactDetailsState(
    val contact: Contact = Contact(),
    val isDeleteContactDialogExpanded: Boolean = false,
) : BaseState