package com.example.contacts.data.local.contacts.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status

@Entity(tableName = "contacts")
data class ContactEntity(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val country: String,
    val email: String,
    val picture: String,
    val status: Status,
    @PrimaryKey val uuid: String
)

fun ContactEntity.toContact(): Contact {
    return Contact(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        picture = picture,
        status = status,
        country = country,
        uuid = uuid
    )
}
