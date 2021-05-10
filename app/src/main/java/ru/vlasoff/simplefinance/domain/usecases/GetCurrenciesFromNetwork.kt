package ru.vlasoff.simplefinance.domain.usecases

import ru.vlasoff.simplefinance.data.repos.CurrencyRepository
import javax.inject.Inject

class GetCurrenciesFromNetwork @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend fun execute() = currencyRepository.getCurrencies()
}