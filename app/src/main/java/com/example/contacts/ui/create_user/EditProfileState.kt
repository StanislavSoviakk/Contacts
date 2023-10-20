package com.example.contacts.ui.create_user

import com.example.contacts.base.BaseState

data class EditProfileState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
) : BaseState
