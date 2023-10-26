package com.example.contacts.ui.profile_screen

import com.example.core.base.BaseState

data class ProfileState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
) : BaseState