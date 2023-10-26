package com.example.contacts.ui.add_contact.use_cases

import com.example.contacts.ui.add_contact.AddContactEvent
import com.example.contacts.ui.add_contact.AddContactState
import com.example.core.base.UseCase
import com.example.domain.repository.ContactsRepository
import kotlinx.collections.immutable.toPersistentList

class LoadRandomContactsUseCase(
    private val contactsRepository: ContactsRepository
) : UseCase<AddContactEvent, AddContactState> {
    override fun canHandle(event: AddContactEvent): Boolean = event is AddContactEvent.LoadContacts

    override suspend fun invoke(event: AddContactEvent, state: AddContactState): AddContactEvent {
        if (event is AddContactEvent.LoadContacts) {
            return AddContactEvent.ContactsLoaded(
                contactsRepository.getContactsFromApi().toPersistentList()
            )
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }

}