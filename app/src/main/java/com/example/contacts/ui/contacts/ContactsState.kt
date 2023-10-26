package com.example.contacts.ui.contacts

import com.example.core.base.BaseState
import com.example.domain.model.Contact
import com.example.domain.model.Status
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsState(
    val contactsList: PersistentList<Contact> = persistentListOf(),
    val selectedStatus: Status = Status.NO_STATUS,
    val isFilterExpanded: Boolean = false,
    val filteredContacts: PersistentList<Contact>? = null,
    val searchText: String = "",
) : BaseState
