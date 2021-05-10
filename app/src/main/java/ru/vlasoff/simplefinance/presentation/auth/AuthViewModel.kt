package ru.vlasoff.simplefinance.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.vlasoff.simplefinance.domain.usecases.SignInUseCase
import ru.vlasoff.simplefinance.domain.usecases.SignUpUseCase
import ru.vlasoff.simplefinance.presentation.IContract
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel(), IContract.IAuthViewModel {

    private val _state = MutableLiveData<AuthState>()
    override val state: LiveData<AuthState>
        get() = _state

    override fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                signInUseCase.execute(email, password).user?.let {
                    _state.postValue(AuthState.Authorized)
                } ?: run {
                    _state.postValue(AuthState.Failed)
                }
            } catch (e: FirebaseException) {
                _state.postValue(AuthState.Failed)
            }
        }
    }

    override fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                signUpUseCase.execute(email, password).user?.let {
                    _state.postValue(AuthState.Authorized)
                } ?: run {
                    _state.postValue(AuthState.Failed)
                }
            } catch (e: FirebaseException) {
                _state.postValue(AuthState.Failed)
            }
        }
    }
}

