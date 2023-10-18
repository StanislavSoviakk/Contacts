package com.example.contacts.ui.create_user

import com.example.contacts.base.Reducer
import com.example.contacts.domain.model.User

class CreateUserReducer : Reducer<CreateUserState, CreateUserEvent> {
    override val initState: CreateUserState = CreateUserState(User())

    override fun reduce(event: CreateUserEvent, state: CreateUserState): CreateUserState {
        return when (event) {
            is CreateUserEvent.SaveUser -> state
            is CreateUserEvent.UserSaved -> state
            is CreateUserEvent.FirstNameChanged -> state.copy(currentUser = state.currentUser.copy(firstName = event.firstName))
            is CreateUserEvent.LastNameChanged -> state.copy(currentUser = state.currentUser.copy(lastName = event.lastName))
            is CreateUserEvent.EmailChanged -> state.copy(currentUser = state.currentUser.copy(email = event.email))
            is CreateUserEvent.PhoneNumberChanged -> state.copy(currentUser = state.currentUser.copy(phoneNumber = event.phoneNumber))
            is CreateUserEvent.BirthDateChanged -> state.copy(currentUser = state.currentUser.copy(birthDate = event.birthDate))
            is CreateUserEvent.PictureSelected -> state.copy(currentUser = state.currentUser.copy(picture = event.pictureUri))
        }
    }
}