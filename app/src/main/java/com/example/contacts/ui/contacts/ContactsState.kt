package com.example.contacts.ui.contacts

import com.example.contacts.base.BaseState
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status

data class ContactsState(
    val contactsList: List<Contact> = listOf(),
    val selectedStatus: Status = Status.NO_STATUS,
    val isFilterExpanded: Boolean = false,
    val filteredContacts: List<Contact>? = null,
    val searchText: String = "",
) : BaseState
