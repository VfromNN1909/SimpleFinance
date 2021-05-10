package ru.vlasoff.simplefinance.domain.entities.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

class MoneyConverter {

    @TypeConverter
    fun fromBigDecimal(money: BigDecimal) = money.toDouble()

    @TypeConverter
    fun fromDouble(money: Double) = money.toBigDecimal()
}