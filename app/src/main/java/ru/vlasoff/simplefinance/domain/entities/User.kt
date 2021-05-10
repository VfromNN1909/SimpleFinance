package ru.vlasoff.simplefinance.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User(
    val email: String,
    val password: String
) {
    @PrimaryKey
    val id: UUID = UUID.randomUUID()
}