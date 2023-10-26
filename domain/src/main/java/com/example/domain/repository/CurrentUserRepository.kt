package com.example.domain.repository

import com.example.domain.model.User

interface CurrentUserRepository {
    suspend fun saveCurrentUser(user: User)
    suspend fun getCurrentUser(): User
}