package com.example.contacts.domain.model

import com.example.contacts.data.local.entity.CurrentUserEntity

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val birthDate: String = "",
    val picture: String = ""
)

fun User.toCurrentUserEntity(): CurrentUserEntity {
    return CurrentUserEntity(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        birthDate = birthDate,
        picture = picture
    )
}
