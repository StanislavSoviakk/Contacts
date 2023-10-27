package com.example.domain.create_user

import com.example.core.base.BaseState

data class EditProfileState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
) : BaseState
