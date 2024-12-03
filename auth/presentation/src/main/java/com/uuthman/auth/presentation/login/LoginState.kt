package com.uuthman.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val canLogin: Boolean = false,
    val isLoggingIn: Boolean = false,
    val isPasswordVisible: Boolean = false,
)
