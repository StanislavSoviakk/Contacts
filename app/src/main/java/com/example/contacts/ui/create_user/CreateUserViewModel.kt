package com.example.contacts.ui.create_user

import com.example.contacts.base.BaseViewModel
import com.example.contacts.ui.create_user.use_cases.SaveUserUseCase

class CreateUserViewModel(saveUserUseCase: SaveUserUseCase) :
    BaseViewModel<CreateUserEvent, CreateUserState>(
        reducer = CreateUserReducer(), useCasesList = listOf(saveUserUseCase)
    ) {

    fun saveUser() {
        handleEvent(CreateUserEvent.SaveUser)
    }

    fun changeFirstName(firstName: String) {
        handleEvent(CreateUserEvent.FirstNameChanged(firstName))
    }

    fun changeLastName(lastName: String) {
        handleEvent(CreateUserEvent.LastNameChanged(lastName))
    }

    fun changeNumber(phoneNumber: String) {
        handleEvent(CreateUserEvent.PhoneNumberChanged(phoneNumber))
    }

    fun changeEmail(email: String) {
        handleEvent(CreateUserEvent.EmailChanged(email))
    }

    fun changeBirthday(birthDate: String) {
        handleEvent(CreateUserEvent.BirthDateChanged(birthDate))
    }

    fun setPicture(pictureUri: String) {
        handleEvent(CreateUserEvent.PictureSelected(pictureUri))
    }
}