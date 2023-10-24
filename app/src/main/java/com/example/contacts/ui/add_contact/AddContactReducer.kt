package com.example.contacts.ui.add_contact

import com.example.contacts.base.Reducer
import kotlinx.collections.immutable.toPersistentList

class AddContactReducer : Reducer<AddContactState, AddContactEvent> {
    override val initState: AddContactState
        get() = AddContactState()

    override fun reduce(event: AddContactEvent, state: AddContactState): AddContactState {
        return when (event) {
            is AddContactEvent.ContactsLoaded -> state.copy(contactsList = (state.contactsList + event.contacts).toPersistentList())
            is AddContactEvent.LoadContacts -> state
            is AddContactEvent.ChangeStatusDialogState -> state.copy(isStatusDialogExpanded = event.isExpanded)
            is AddContactEvent.ContactSaved -> state
            is AddContactEvent.SaveContact -> state
            is AddContactEvent.SelectContact -> state.copy(selectedContact = event.contact)
        }
    }
}