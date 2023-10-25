package com.example.contacts.ui.contact_details

import androidx.navigation.NavOptions
import com.example.contacts.base.BaseViewModel
import com.example.contacts.base.Router
import com.example.contacts.ui.Screen
import com.example.contacts.ui.contact_details.use_cases.DeleteContactUseCase
import com.example.contacts.ui.contact_details.use_cases.LoadContactUseCase

class ContactDetailsViewModel(
    val router: Router,
    loadContactUseCase: LoadContactUseCase,
    deleteContactUseCase: DeleteContactUseCase
) : BaseViewModel<ContactDetailsEvent, ContactDetailsState>(
    reducer = ContactDetailsReducer(),
    useCasesList = listOf(loadContactUseCase, deleteContactUseCase)
) {

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