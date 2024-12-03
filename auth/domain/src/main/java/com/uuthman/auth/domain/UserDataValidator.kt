package com.uuthman.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {
    fun isValidEmail(email: String): Boolean {
        return  patternValidator.matches(email)
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= MIN_PASSWORD_LENGTH
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}