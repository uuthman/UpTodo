package com.uuthman.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uuthman.auth.domain.AuthRepository
import com.uuthman.auth.domain.UserDataValidator
import com.uuthman.core.presentation.ui.textAsFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.uuthman.core.domain.util.Result
import com.uuthman.core.presentation.ui.asUiText


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository
): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val events = eventChannel.receiveAsFlow()

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
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }
            else -> Unit
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isRegistering = true)
            val result = authRepository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isRegistering = false)

            when(result) {
                is Result.Error -> {
                    eventChannel.send(RegisterEvent.Error(result.error.asUiText()))
                }
                is Result.Success -> {
                    eventChannel.send(RegisterEvent.RegistrationSuccess)
                }
            }
        }


    }
}