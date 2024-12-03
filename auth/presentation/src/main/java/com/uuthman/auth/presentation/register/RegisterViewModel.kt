package com.uuthman.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uuthman.auth.domain.UserDataValidator
import com.uuthman.core.presentation.ui.textAsFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    userDataValidator: UserDataValidator
): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    init {
        combine(state.email.textAsFlow(),state.password.textAsFlow()) { email, password ->
            val isValidEmail = userDataValidator.isValidEmail(email.toString())
            val isValidPassword = userDataValidator.validatePassword(password.toString())

            state = state.copy(
               canRegister = isValidPassword && isValidEmail && !state.isRegistering
            )

        }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when(action) {
            RegisterAction.OnRegisterClick -> {

            }
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }
            else -> Unit
        }
    }
}