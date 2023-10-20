package com.example.contacts.data.repository

import com.example.contacts.data.local.CurrentUserDao
import com.example.contacts.data.local.entity.toUser
import com.example.contacts.domain.model.User
import com.example.contacts.domain.model.toCurrentUserEntity
import com.example.contacts.domain.repository.CurrentUserRepository

class CurrentUserRepositoryImpl(private val dao: CurrentUserDao) : CurrentUserRepository {
    override suspend fun saveCurrentUser(user: User) {
        dao.insert(user.toCurrentUserEntity())
    }

    override suspend fun getCurrentUser(): User {
        return dao.getCurrentUser().toUser()
    }
}