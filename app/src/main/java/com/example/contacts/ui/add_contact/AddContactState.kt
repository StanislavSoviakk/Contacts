package com.example.contacts.ui.add_contact

import com.example.contacts.base.BaseState
import com.example.contacts.domain.model.Contact
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class AddContactState(
    val contactsList: PersistentList<Contact> = persistentListOf(),
    val isStatusDialogExpanded: Boolean = false,
    val selectedContact: Contact? = null
) : BaseState
