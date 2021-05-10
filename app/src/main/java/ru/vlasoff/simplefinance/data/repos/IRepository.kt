package ru.vlasoff.simplefinance.data.repos

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import ru.vlasoff.simplefinance.domain.entities.Currency
import ru.vlasoff.simplefinance.domain.entities.Expose
import ru.vlasoff.simplefinance.domain.entities.Income
import ru.vlasoff.simplefinance.domain.entities.retrofit_entities.CurrencyResponseItem

interface IRepository {

    interface IAuthRepository {
        suspend fun signIn(email: String, password: String): AuthResult
        suspend fun signUp(email: String, password: String): AuthResult
    }

    interface IIncomesRepository {
        suspend fun addIncome(income: Income)
        suspend fun deleteIncome(income: Income)
        fun getAll(): Flow<List<Income>>
    }

    interface IExposesRepository {
        suspend fun addExpose(expose: Expose)
        suspend fun deleteExpose(expose: Expose)
        fun getAll(): Flow<List<Expose>>
    }

    interface ICurrencyRepository {
        suspend fun getCurrencies(): Flow<List<Currency>>
    }
}