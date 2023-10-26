package com.example.contacts.ui.contact_details

import com.example.core.base.Reducer


class ContactDetailsReducer : Reducer<ContactDetailsState, ContactDetailsEvent> {
    override val initState: ContactDetailsState
        get() = ContactDetailsState()

    override fun reduce(
        event: ContactDetailsEvent,
        state: ContactDetailsState
    ): ContactDetailsState {
        return when (event) {
            is ContactDetailsEvent.LoadContact -> state
            is ContactDetailsEvent.ContactLoaded -> state.copy(contact = event.contact)
            is ContactDetailsEvent.ChangeDeleteDialogState -> state.copy(
                isDeleteContactDialogExpanded = event.isExpanded
            )

            is ContactDetailsEvent.DeleteContact -> state
            is ContactDetailsEvent.ContactDeleted -> state
        }
    }
}