package com.example.contacts.domain.repository

import com.example.contacts.domain.model.User

interface CurrentUserRepository {
    suspend fun saveCurrentUser(user: User)
    suspend fun getCurrentUser(): User
}