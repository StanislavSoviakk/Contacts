package com.example.contacts.ui.add_contact

import androidx.navigation.NavOptions
import com.example.contacts.ui.Screen
import com.example.contacts.ui.add_contact.use_cases.LoadRandomContactsUseCase
import com.example.contacts.ui.add_contact.use_cases.SaveContactUseCase
import com.example.core.base.BaseViewModel
import com.example.core.base.Router
import com.example.domain.model.Contact
import com.example.domain.model.Status

class AddContactViewModel(
    loadRandomContactsUseCase: LoadRandomContactsUseCase,
    saveContactUseCase: SaveContactUseCase,
    val router: Router
) : BaseViewModel<AddContactEvent, AddContactState>(
    reducer = AddContactReducer(),
    useCasesList = listOf(loadRandomContactsUseCase, saveContactUseCase)
) {
    init {
        loadUsers()
    }

    fun loadUsers() {
        handleEvent(AddContactEvent.LoadContacts)
    }

    fun addContactToDB(status: Status) {
        collapseDialog()
        state.value.selectedContact?.let { contact: Contact ->
            handleEvent(AddContactEvent.SaveContact(contact.copy(status = status)))
        }
        navigateToContactsList()
    }

    fun collapseDialog() {
        handleEvent(AddContactEvent.ChangeStatusDialogState(isExpanded = false))
    }

    private fun expandDialog() {
        handleEvent(AddContactEvent.ChangeStatusDialogState(isExpanded = true))
    }

    private fun navigateToContactsList() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.ContactsScreen.route, true).build()
        router.navigateTo(Screen.ContactsScreen.route, navOptions)
    }

    fun onContactClick(contact: Contact) {
        handleEvent(AddContactEvent.SelectContact(contact))
        expandDialog()
    }
}