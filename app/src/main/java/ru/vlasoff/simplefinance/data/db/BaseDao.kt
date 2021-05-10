package ru.vlasoff.simplefinance.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface BaseDao<T> {
    @Insert
    suspend fun insert(vararg obj: T)

    @Delete
    suspend fun delete(vararg obj: T)

}