package ru.vlasoff.simplefinance.domain.usecases

import ru.vlasoff.simplefinance.data.repos.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(email: String, password: String) = repository.signUp(email, password)
}