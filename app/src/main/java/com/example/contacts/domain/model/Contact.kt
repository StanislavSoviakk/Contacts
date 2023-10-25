package com.example.contacts.domain.model

import com.example.contacts.data.local.contacts.entity.ContactEntity

data class Contact(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val country: String = "",
    val email: String = "",
    val picture: String = "",
    val status: Status = Status.NO_STATUS,
    val uuid: String = ""
)

fun Contact.toContactEntity(): ContactEntity {
    return ContactEntity(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        picture = picture,
        status = status,
        country = country,
        uuid = uuid,
    )
}
