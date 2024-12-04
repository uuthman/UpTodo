package com.uuthman.core.data.auth
import kotlinx.serialization.Serializable


@Serializable
data class AuthInfoSerializable(
    val email: String,
    val name: String,
    val photoUrl: String,
    val userId: String
)