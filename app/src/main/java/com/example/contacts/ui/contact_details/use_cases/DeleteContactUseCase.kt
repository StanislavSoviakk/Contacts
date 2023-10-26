package com.example.contacts.ui.contact_details.use_cases

import com.example.contacts.ui.contact_details.ContactDetailsEvent
import com.example.contacts.ui.contact_details.ContactDetailsState
import com.example.core.base.UseCase
import com.example.domain.repository.ContactsRepository

class DeleteContactUseCase(private val contactsRepository: ContactsRepository) :
    UseCase<ContactDetailsEvent, ContactDetailsState> {
    override fun canHandle(event: ContactDetailsEvent): Boolean =
        event is ContactDetailsEvent.DeleteContact

    override suspend fun invoke(
        event: ContactDetailsEvent,
        state: ContactDetailsState
    ): ContactDetailsEvent {
        if (event is ContactDetailsEvent.DeleteContact) {
            contactsRepository.deleteContact(event.uuid)
            return ContactDetailsEvent.ContactDeleted
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}