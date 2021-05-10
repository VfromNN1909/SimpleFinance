package ru.vlasoff.simplefinance.domain.entities.recycler_items

import ru.vlasoff.simplefinance.domain.entities.Expose
import ru.vlasoff.simplefinance.domain.entities.Income
import java.math.BigDecimal
import java.util.*

sealed class Item {
    data class Info(val balance: Double, val plannedExposes: Double, val currency: String): Item()
    data class Incomes(val income: Income): Item()
    data class Exposes(val expose: Expose): Item()
}