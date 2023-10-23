package com.example.contacts.ui.contacts.use_cases

import com.example.contacts.base.UseCase
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status
import com.example.contacts.domain.repository.ContactsRepository
import com.example.contacts.ui.contacts.ContactsEvent
import com.example.contacts.ui.contacts.ContactsState

class LoadContactsUseCase(private val contactsRepository: ContactsRepository) :
    UseCase<ContactsEvent, ContactsState> {
    override fun canHandle(event: ContactsEvent): Boolean = event is ContactsEvent.LoadContacts

    override suspend fun invoke(event: ContactsEvent, state: ContactsState): ContactsEvent {
        if (event is ContactsEvent.LoadContacts) {
            //TEMPORARY TEST DATA
            val list = listOf(
                Contact(
                    firstName = "111",
                    lastName = "111",
                    phoneNumber = "111",
                    email = "111",
                    picture = "111",
                    status = Status.FAMILY,
                    country = "111",
                    uuid = "111"
                ),
                Contact(
                    firstName = "222",
                    lastName = "222",
                    phoneNumber = "222",
                    email = "222",
                    picture = "222",
                    status = Status.FRIEND,
                    country = "222",
                    uuid = "222"
                ),
                Contact(
                    firstName = "333",
                    lastName = "333",
                    phoneNumber = "333",
                    email = "333",
                    picture = "333",
                    status = Status.WORK,
                    country = "333",
                    uuid = "333"
                )
            )
            list.forEach {
                contactsRepository.addContact(it)
            }
            val contacts = contactsRepository.getContacts()
            return ContactsEvent.ContactsLoaded(contacts)
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}