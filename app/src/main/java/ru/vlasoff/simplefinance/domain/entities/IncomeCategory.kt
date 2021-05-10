package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Income::class,
            parentColumns = arrayOf("category"),
            childColumns = arrayOf("name"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IncomeCategory(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String
)