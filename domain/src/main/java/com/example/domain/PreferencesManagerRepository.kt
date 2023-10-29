package com.example.domain

interface PreferencesManagerRepository {
    fun saveUserWasCreated()
    fun checkIfUserWasCreated(): Boolean
}