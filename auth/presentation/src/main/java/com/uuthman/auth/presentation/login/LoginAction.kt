package com.uuthman.auth.presentation.login

sealed interface LoginAction {
    data object OnLoginClick: LoginAction
    data object OnRegisterClick: LoginAction
    data object OnBackClick: LoginAction
    data object OnTogglePasswordVisibility: LoginAction
}