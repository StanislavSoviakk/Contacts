package com.example.data.mapper

import com.example.core.base.Mapper
import com.example.data.local.current_user.entity.CurrentUserEntity
import com.example.domain.model.User

class MapUserToContactEntity : Mapper<User, CurrentUserEntity> {
    override fun invoke(value: User): CurrentUserEntity {
        return CurrentUserEntity(
            firstName = value.firstName,
            lastName = value.lastName,
            phoneNumber = value.phoneNumber,
            email = value.email,
            picture = value.picture,
            birthDate = value.birthDate,
        )
    }
}