package com.example.data.local.current_user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.current_user.entity.CurrentUserEntity

@Database(
    entities = [CurrentUserEntity::class], version = 1, exportSchema = true
)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao: CurrentUserDao
}