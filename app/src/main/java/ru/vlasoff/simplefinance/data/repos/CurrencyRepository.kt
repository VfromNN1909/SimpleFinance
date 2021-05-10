package ru.vlasoff.simplefinance.data.repos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.vlasoff.simplefinance.data.network.ApiService
import ru.vlasoff.simplefinance.domain.entities.Currency
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val apiService: ApiService
) : IRepository.ICurrencyRepository {

    override suspend fun getCurrencies(): Flow<List<Currency>> = flow {
        val currencies = apiService.getCurrencies()
            .map { currency ->
                val name = currency.currencyFromTo.split("_")[1]
                val value = currency.currencyValue.toBigDecimal()
                Currency(name, value)
            }
        emit(currencies)
    }.flowOn(Dispatchers.IO)

}