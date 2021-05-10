package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.vlasoff.simplefinance.domain.entities.converters.MoneyConverter
import java.math.BigDecimal

@Entity(tableName = "incomes")
@TypeConverters(MoneyConverter::class)
data class Income(
    val name: String,
    val value: BigDecimal,
    val category: String,
    val createDate: Long,
    val currency: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}