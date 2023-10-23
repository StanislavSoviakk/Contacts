package com.example.contacts.data.repository

import com.example.contacts.data.local.contacts.ContactsDao
import com.example.contacts.data.local.contacts.entity.toContact
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.toContactEntity
import com.example.contacts.domain.repository.ContactsRepository

class ContactsRepositoryImpl(private val dao: ContactsDao) : ContactsRepository {
    override suspend fun getContacts(): List<Contact> {
        return dao.getContacts().map { it.toContact() }
    }

    override suspend fun addContact(contact: Contact) {
        dao.insert(contact.toContactEntity())
    }
}