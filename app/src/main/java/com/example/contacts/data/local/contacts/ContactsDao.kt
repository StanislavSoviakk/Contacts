package com.example.contacts.data.local.contacts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contacts.data.local.contacts.entity.ContactEntity

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Query("SELECT * FROM contacts")
    suspend fun getContacts(): List<ContactEntity>
}