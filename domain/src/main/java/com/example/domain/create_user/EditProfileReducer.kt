package com.example.domain.create_user

import com.example.core.base.Reducer

class EditProfileReducer : Reducer<EditProfileState, EditProfileEvent> {
    override val initState: EditProfileState = EditProfileState()

    override fun reduce(event: EditProfileEvent, state: EditProfileState): EditProfileState {
        return when (event) {
            is EditProfileEvent.SaveUser -> state
            is EditProfileEvent.UserSaved -> state
            is EditProfileEvent.FirstNameChanged -> state.copy(firstName = event.firstName)
            is EditProfileEvent.LastNameChanged -> state.copy(lastName = event.lastName)
            is EditProfileEvent.EmailChanged -> state.copy(email = event.email)
            is EditProfileEvent.PhoneNumberChanged -> state.copy(phoneNumber = event.phoneNumber)
            is EditProfileEvent.BirthDateChanged -> state.copy(birthDate = event.birthDate)
            is EditProfileEvent.PictureSelected -> state.copy(picture = event.pictureUri)
            is EditProfileEvent.LoadUser -> state
            is EditProfileEvent.UserLoaded -> state.copy(
                firstName = event.user.firstName,
                lastName = event.user.lastName,
                phoneNumber = event.user.phoneNumber,
                email = event.user.email,
                birthDate = event.user.birthDate,
                picture = event.user.picture
            )
        }
    }
}