package com.example.data.local.contacts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.contacts.entity.ContactEntity

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Query("SELECT * FROM contacts")
    suspend fun getContacts(): List<ContactEntity>

    @Query("SELECT * FROM contacts WHERE uuid = :uuid")
    suspend fun getContact(uuid: String): ContactEntity

    @Query("DELETE FROM contacts WHERE uuid = :uuid")
    suspend fun deleteContact(uuid: String)
}