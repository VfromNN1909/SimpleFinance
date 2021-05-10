package ru.vlasoff.simplefinance.data.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vlasoff.simplefinance.domain.entities.Income

@Dao
interface IncomesDao : BaseDao<Income> {

    @Query("SELECT * FROM incomes")
    fun getAll(): Flow<List<Income>>

}