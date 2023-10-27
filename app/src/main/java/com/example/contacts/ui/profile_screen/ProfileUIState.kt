package com.example.contacts.ui.profile_screen

import com.example.core.base.BaseState
import com.example.domain.profile.ProfileState

data class ProfileUIState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
) : BaseState

fun ProfileState.toUIState(): ProfileUIState {
    return ProfileUIState(firstName, lastName, phoneNumber, email, birthDate, picture)
}



