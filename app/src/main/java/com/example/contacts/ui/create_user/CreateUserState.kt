package com.example.contacts.ui.create_user

import com.example.contacts.base.BaseState
import com.example.contacts.domain.model.User

data class CreateUserState(val currentUser: User) : BaseState
