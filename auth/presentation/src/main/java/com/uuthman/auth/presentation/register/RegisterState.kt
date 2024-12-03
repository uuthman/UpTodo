package com.uuthman.auth.presentation.register

import androidx.compose.foundation.text.input.TextFieldState

data class RegisterState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val isRegistering: Boolean = false,
    val canRegister: Boolean = false
)