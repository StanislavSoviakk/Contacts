package com.example.contacts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contacts.data.local.entity.CurrentUserEntity

@Database(
    entities = [CurrentUserEntity::class], version = 1, exportSchema = true
)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: CurrentUserDao
}