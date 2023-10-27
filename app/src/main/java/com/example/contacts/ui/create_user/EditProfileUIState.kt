package com.example.contacts.ui.create_user

import com.example.domain.create_user.EditProfileState

data class EditProfileUIState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
)

fun EditProfileState.toUIState(): EditProfileUIState {
    return EditProfileUIState(firstName, lastName, phoneNumber, email, birthDate, picture)
}

