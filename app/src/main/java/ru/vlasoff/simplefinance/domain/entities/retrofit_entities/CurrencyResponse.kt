package ru.vlasoff.simplefinance.domain.entities.retrofit_entities

import ru.vlasoff.simplefinance.domain.entities.Currency

data class CurrencyResponse(
    val data: List<Currency>? = null,
    val status: String? = null
)