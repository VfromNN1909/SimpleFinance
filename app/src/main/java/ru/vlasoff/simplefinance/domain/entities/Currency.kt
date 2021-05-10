package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.vlasoff.simplefinance.domain.entities.converters.MoneyConverter
import java.math.BigDecimal

@Entity(tableName = "currency")
@TypeConverters(MoneyConverter::class)
data class Currency(
    val name: String,
    val valueAgainstTheDollar: BigDecimal,
) {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}