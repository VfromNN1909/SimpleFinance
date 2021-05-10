package ru.vlasoff.simplefinance.domain.entities.retrofit_entities

data class CurrencyResponseItem(
    val currencyFromTo: String,
    val currencyValue: Double
)