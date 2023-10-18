package com.example.contacts.ui.create_user

import com.example.contacts.base.Reducer

class CreateUserReducer : Reducer<CreateUserState, CreateUserEvent> {
    override val initState: CreateUserState = CreateUserState()

    override fun reduce(event: CreateUserEvent, state: CreateUserState): CreateUserState {
        return when (event) {
            is CreateUserEvent.SaveUser -> state
            is CreateUserEvent.UserSaved -> state
            is CreateUserEvent.FirstNameChanged -> state.copy(firstName = event.firstName)
            is CreateUserEvent.LastNameChanged -> state.copy(lastName = event.lastName)
            is CreateUserEvent.EmailChanged -> state.copy(email = event.email)
            is CreateUserEvent.PhoneNumberChanged -> state.copy(phoneNumber = event.phoneNumber)
            is CreateUserEvent.BirthDateChanged -> state.copy(birthDate = event.birthDate)
            is CreateUserEvent.PictureSelected -> state.copy(picture = event.pictureUri)
        }
    }
}