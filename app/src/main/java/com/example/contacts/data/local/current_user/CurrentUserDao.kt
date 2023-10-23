package com.example.contacts.data.local.current_user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contacts.data.local.current_user.entity.CurrentUserEntity

@Dao
interface CurrentUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currentUser: CurrentUserEntity)

    @Query("SELECT * FROM current_user LIMIT 1")
    suspend fun getCurrentUser(): CurrentUserEntity
}