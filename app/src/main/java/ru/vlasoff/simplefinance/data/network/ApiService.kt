package ru.vlasoff.simplefinance.data.network

import retrofit2.http.GET
import ru.vlasoff.simplefinance.domain.entities.retrofit_entities.CurrencyResponseItem

interface ApiService {

    @GET
    suspend fun getCurrencies(): List<CurrencyResponseItem>

}