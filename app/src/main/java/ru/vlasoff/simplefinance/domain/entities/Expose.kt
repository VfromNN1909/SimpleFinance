package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.vlasoff.simplefinance.domain.entities.converters.MoneyConverter
import java.math.BigDecimal

@Entity(tableName = "exposes")
@TypeConverters(MoneyConverter::class)
data class Expose(
    val name: String,
    val value: BigDecimal,
    val limit: BigDecimal?,
    val category: String,
    val createDate: Long,
    val currency: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}