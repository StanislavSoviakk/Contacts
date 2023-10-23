package com.example.contacts.ui.contacts

import com.example.contacts.base.BaseState
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsState(
    val contactsList: PersistentList<Contact> = persistentListOf(),
    val selectedStatus: Status = Status.NO_STATUS,
    val isFilterExpanded: Boolean = false,
    val filteredContacts: PersistentList<Contact>? = null,
    val searchText: String = "",
) : BaseState
