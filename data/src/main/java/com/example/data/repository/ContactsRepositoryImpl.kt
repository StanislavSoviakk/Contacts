package com.example.data.repository


import com.example.data.local.contacts.ContactsDao
import com.example.data.local.contacts.entity.toContact
import com.example.data.mapper.MapContactToContactEntity
import com.example.data.remote.RandomContactsApi
import com.example.data.remote.dto.toContact
import com.example.domain.model.Contact
import com.example.domain.repository.ContactsRepository

class ContactsRepositoryImpl(
    private val dao: ContactsDao,
    private val api: RandomContactsApi,
    private val mapContactToContactEntity: MapContactToContactEntity
) :
    ContactsRepository {

    override suspend fun getContactsFromApi(): List<Contact> {
        return api.getRandomUsers().results.map { it.toContact() }
    }

    override suspend fun getContactsFromDB(): List<Contact> {
        return dao.getContacts().map { it.toContact() }
    }

    override suspend fun addContact(contact: Contact) {
        dao.insert(mapContactToContactEntity(contact))
    }

    override suspend fun getContact(uuid: String): Contact {
        return dao.getContact(uuid).toContact()
    }

    override suspend fun deleteContact(uuid: String) {
        dao.deleteContact(uuid)
    }
}