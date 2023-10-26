package com.example.contacts.ui.create_user

import com.example.core.base.BaseEvent
import com.example.domain.model.User

sealed interface EditProfileEvent : BaseEvent {
    object LoadUser : EditProfileEvent
    data class UserLoaded(val user: User) : EditProfileEvent
    object SaveUser : EditProfileEvent
    object UserSaved : EditProfileEvent
    data class FirstNameChanged(val firstName: String) : EditProfileEvent
    data class LastNameChanged(val lastName: String) : EditProfileEvent
    data class PhoneNumberChanged(val phoneNumber: String) : EditProfileEvent
    data class EmailChanged(val email: String) : EditProfileEvent
    data class BirthDateChanged(val birthDate: String) : EditProfileEvent
    data class PictureSelected(val pictureUri: String) : EditProfileEvent

}