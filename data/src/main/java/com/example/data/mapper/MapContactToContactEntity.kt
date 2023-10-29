package com.example.data.mapper

import com.example.core.base.Mapper
import com.example.data.local.contacts.entity.ContactEntity
import com.example.domain.model.Contact

class MapContactToContactEntity: Mapper<Contact, ContactEntity> {
    override fun invoke(value: Contact): ContactEntity {
        return ContactEntity(
            firstName = value.firstName,
            lastName = value.lastName,
            phoneNumber = value.phoneNumber,
            email = value.email,
            picture = value.picture,
            country = value.country,
            status = value.status,
            uuid = value.uuid
        )
    }
}