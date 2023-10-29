package com.example.domain.model

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

