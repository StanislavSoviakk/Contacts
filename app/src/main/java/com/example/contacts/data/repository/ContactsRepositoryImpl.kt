package com.example.contacts.data.repository

import com.example.contacts.data.local.contacts.ContactsDao
import com.example.contacts.data.local.contacts.entity.toContact
import com.example.contacts.data.remote.RandomContactsApi
import com.example.contacts.data.remote.dto.toContact
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.toContactEntity
import com.example.contacts.domain.repository.ContactsRepository

class ContactsRepositoryImpl(private val dao: ContactsDao, private val api: RandomContactsApi) :
    ContactsRepository {

    override suspend fun getContactsFromApi(): List<Contact> {
        return api.getRandomUsers().results.map { it.toContact() }
    }

    override suspend fun getContactsFromDB(): List<Contact> {
        return dao.getContacts().map { it.toContact() }
    }

    override suspend fun addContact(contact: Contact) {
        dao.insert(contact.toContactEntity())
    }

    override suspend fun getContact(uuid: String): Contact {
        return dao.getContact(uuid).toContact()
    }

    override suspend fun deleteContact(uuid: String) {
        dao.deleteContact(uuid)
    }
}