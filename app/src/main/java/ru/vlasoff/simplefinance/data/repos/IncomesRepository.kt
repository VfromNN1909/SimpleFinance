package ru.vlasoff.simplefinance.data.repos

import kotlinx.coroutines.flow.Flow
import ru.vlasoff.simplefinance.data.db.IncomesDao
import ru.vlasoff.simplefinance.domain.entities.Income
import javax.inject.Inject

class IncomesRepository @Inject constructor(
    private val dao: IncomesDao
) : IRepository.IIncomesRepository {

    override suspend fun addIncome(income: Income) {
        dao.insert(income)
    }

    override suspend fun deleteIncome(income: Income) {
        dao.delete(income)
    }

    override fun getAll() = dao.getAll()

}