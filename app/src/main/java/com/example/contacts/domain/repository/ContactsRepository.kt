package com.example.contacts.domain.repository

import com.example.contacts.domain.model.Contact

interface ContactsRepository {
    suspend fun getContactsFromApi(): List<Contact>
    suspend fun getContactsFromDB(): List<Contact>
    suspend fun addContact(contact: Contact)
}