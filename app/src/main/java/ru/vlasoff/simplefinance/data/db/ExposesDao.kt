package ru.vlasoff.simplefinance.data.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vlasoff.simplefinance.domain.entities.Expose

@Dao
interface ExposesDao : BaseDao<Expose> {

    @Query("SELECT * FROM exposes")
    fun getAll(): Flow<List<Expose>>

}