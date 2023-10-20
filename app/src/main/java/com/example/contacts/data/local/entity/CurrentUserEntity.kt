package com.example.contacts.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contacts.domain.model.User

@Entity(tableName = "current_user")
data class CurrentUserEntity(
    @PrimaryKey val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: String,
    val picture: String
)

fun CurrentUserEntity.toUser(): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        birthDate = birthDate,
        picture = picture
    )
}