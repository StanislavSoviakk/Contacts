package com.example.contacts.data.local.contacts

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contacts.data.local.contacts.entity.ContactEntity

@Database(entities = [ContactEntity::class] , version = 1, exportSchema = true)
abstract class ContactsDatabase : RoomDatabase() {
    abstract val dao: ContactsDao
}