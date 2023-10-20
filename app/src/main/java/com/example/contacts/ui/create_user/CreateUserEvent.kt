package com.example.contacts.ui.create_user

import com.example.contacts.base.BaseEvent

sealed interface CreateUserEvent : BaseEvent {
    object SaveUser : CreateUserEvent
    object UserSaved : CreateUserEvent
    data class FirstNameChanged(val firstName: String) : CreateUserEvent
    data class LastNameChanged(val lastName: String) : CreateUserEvent
    data class PhoneNumberChanged(val phoneNumber: String) : CreateUserEvent
    data class EmailChanged(val email: String) : CreateUserEvent
    data class BirthDateChanged(val birthDate: String) : CreateUserEvent
    data class PictureSelected(val pictureUri: String) : CreateUserEvent

}