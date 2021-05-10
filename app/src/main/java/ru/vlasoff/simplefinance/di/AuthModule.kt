package ru.vlasoff.simplefinance.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vlasoff.simplefinance.data.repos.AuthRepository
import ru.vlasoff.simplefinance.domain.usecases.SignInUseCase
import ru.vlasoff.simplefinance.domain.usecases.SignUpUseCase
import ru.vlasoff.simplefinance.presentation.auth.AuthViewModel

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideAuthViewModel(
        signInUseCase: SignInUseCase,
        signUpUseCase: SignUpUseCase
    ) = AuthViewModel(signInUseCase, signUpUseCase)

    @Provides
    fun provideAuthRepository() = AuthRepository()
}