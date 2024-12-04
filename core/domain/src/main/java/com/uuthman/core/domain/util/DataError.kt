package com.uuthman.core.domain.util

sealed interface DataError: Error {
    enum class Network: DataError {
        REQUEST_TIMEOUT,
        UNAUTHORIZED,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN,
        INVALID_EMAIL,
        EMAIL_ALREADY_EXISTS,
        USER_NOT_FOUND
    }

    enum class Local: DataError {
        DISK_FULL
    }
}