package com.example.contacts.ui.contacts.use_cases

import com.example.contacts.base.UseCase
import com.example.contacts.domain.repository.ContactsRepository
import com.example.contacts.ui.contacts.ContactsEvent
import com.example.contacts.ui.contacts.ContactsState
import kotlinx.collections.immutable.toPersistentList

class LoadContactsUseCase(private val contactsRepository: ContactsRepository) :
    UseCase<ContactsEvent, ContactsState> {
    override fun canHandle(event: ContactsEvent): Boolean = event is ContactsEvent.LoadContacts

    override suspend fun invoke(event: ContactsEvent, state: ContactsState): ContactsEvent {
        if (event is ContactsEvent.LoadContacts) {
            val contacts = contactsRepository.getContactsFromDB()
            return ContactsEvent.ContactsLoaded(contacts.toPersistentList())
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}