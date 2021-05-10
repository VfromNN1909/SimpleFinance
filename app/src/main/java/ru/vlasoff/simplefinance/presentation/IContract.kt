package ru.vlasoff.simplefinance.presentation

import androidx.lifecycle.LiveData
import ru.vlasoff.simplefinance.presentation.auth.AuthState

interface IContract {
    interface IAuthViewModel {
        val state: LiveData<AuthState>
        fun signIn(email: String, password: String)
        fun signUp(email: String, password: String)
    }
}