package com.example.contacts.ui.contact_details

import androidx.navigation.NavOptions
import com.example.contacts.common.BaseViewModel
import com.example.contacts.common.Router
import com.example.contacts.ui.Screen
import com.example.domain.contact_details.ContactDetailsEvent
import com.example.domain.contact_details.ContactDetailsReducer
import com.example.domain.contact_details.ContactDetailsState
import com.example.domain.contact_details.use_cases.DeleteContactUseCase
import com.example.domain.contact_details.use_cases.LoadContactUseCase

class ContactDetailsViewModel(
    val router: Router,
    loadContactUseCase: LoadContactUseCase,
    deleteContactUseCase: DeleteContactUseCase
) : BaseViewModel<ContactDetailsEvent, ContactDetailsState, ContactDetailsUIState>(
    reducer = ContactDetailsReducer(),
    useCasesList = listOf(loadContactUseCase, deleteContactUseCase)
) {
    override val uiState: ContactDetailsUIState
        get() = state.value.toUIState()

    fun loadContact(uuid: String?) {
        uuid?.let {
            handleEvent(ContactDetailsEvent.LoadContact(uuid))
        }
    }

    fun expandDeleteContactDialog() {
        handleEvent(ContactDetailsEvent.ChangeDeleteDialogState(true))
    }

    fun collapseDeleteContactDialog() {
        handleEvent(ContactDetailsEvent.ChangeDeleteDialogState(false))
    }

    fun deleteContact() {
        handleEvent(ContactDetailsEvent.DeleteContact(state.value.contact.uuid))
        collapseDeleteContactDialog()
        navigateToContactsList()
    }

    private fun navigateToContactsList() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.ContactsScreen.route, true).build()
        router.navigateTo(Screen.ContactsScreen.route, navOptions)
    }

}