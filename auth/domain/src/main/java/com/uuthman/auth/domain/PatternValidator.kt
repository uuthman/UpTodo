package com.uuthman.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}