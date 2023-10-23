package com.example.contacts.domain.repository

import com.example.contacts.domain.model.Contact

interface ContactsRepository {
    suspend fun getContacts(): List<Contact>
    suspend fun addContact(contact: Contact)
}