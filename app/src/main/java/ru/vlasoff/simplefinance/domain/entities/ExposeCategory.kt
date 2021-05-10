package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Expose::class,
            parentColumns = arrayOf("category"),
            childColumns = arrayOf("name"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ExposeCategory(
    @PrimaryKey
    val id: Long,
    val name: String
)