package com.example.data.repository

import com.example.data.local.current_user.CurrentUserDao
import com.example.data.local.current_user.entity.toUser
import com.example.data.mapper.MapUserToContactEntity
import com.example.domain.model.User
import com.example.domain.repository.CurrentUserRepository

class CurrentUserRepositoryImpl(
    private val dao: CurrentUserDao,
    private val mapUserToContactEntity: MapUserToContactEntity
) : CurrentUserRepository {

    override suspend fun saveCurrentUser(user: User) {
        dao.insert(mapUserToContactEntity(user))
    }

    override suspend fun getCurrentUser(): User {
        return dao.getCurrentUser()?.toUser() ?: User()
    }
}