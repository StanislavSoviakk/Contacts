package com.example.contacts.ui.profile_screen

import com.example.contacts.base.BaseEvent
import com.example.contacts.domain.model.User

sealed interface ProfileEvent : BaseEvent {
    object LoadUser : ProfileEvent
    data class UserLoaded(val user: User) : ProfileEvent
}