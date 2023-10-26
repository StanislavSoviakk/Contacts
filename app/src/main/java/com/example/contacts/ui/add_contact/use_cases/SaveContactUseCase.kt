package com.example.contacts.ui.add_contact.use_cases

import com.example.contacts.ui.add_contact.AddContactEvent
import com.example.contacts.ui.add_contact.AddContactState
import com.example.core.base.UseCase
import com.example.domain.repository.ContactsRepository

class SaveContactUseCase(private val contactsRepository: ContactsRepository) :
    UseCase<AddContactEvent, AddContactState> {
    override fun canHandle(event: AddContactEvent): Boolean = event is AddContactEvent.SaveContact

    override suspend fun invoke(event: AddContactEvent, state: AddContactState): AddContactEvent {
        if (event is AddContactEvent.SaveContact) {
            contactsRepository.addContact(event.contact)
            return AddContactEvent.ContactSaved
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }

}