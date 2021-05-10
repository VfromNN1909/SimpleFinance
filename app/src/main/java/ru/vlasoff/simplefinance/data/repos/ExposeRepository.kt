package ru.vlasoff.simplefinance.data.repos

import ru.vlasoff.simplefinance.data.db.ExposesDao
import ru.vlasoff.simplefinance.domain.entities.Expose
import javax.inject.Inject

class ExposeRepository @Inject constructor(
    private val dao: ExposesDao
) : IRepository.IExposesRepository {

    override suspend fun addExpose(expose: Expose) {
       dao.insert(expose)
    }

    override suspend fun deleteExpose(expose: Expose) {
        dao.delete(expose)
    }

    override fun getAll() = dao.getAll()

}