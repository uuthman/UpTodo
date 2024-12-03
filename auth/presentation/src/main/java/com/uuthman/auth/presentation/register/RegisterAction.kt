package com.uuthman.auth.presentation.register

sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick: RegisterAction
    data object OnLoginClick: RegisterAction
    data object OnBackClick: RegisterAction
    data object OnRegisterClick: RegisterAction
}