package com.uuthman.core.data.networking

import com.google.firebase.auth.FirebaseAuthException
import com.uuthman.core.domain.util.DataError
import com.uuthman.core.domain.util.Result
import kotlin.coroutines.cancellation.CancellationException

suspend inline fun <reified T> safeCall(execute: () -> T): Result<T, DataError.Network> {
    val result = try {
        execute()
    } catch (e: FirebaseAuthException) {
        e.printStackTrace()
        return mapFirebaseErrorToResult(e)
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        return Result.Error(DataError.Network.UNKNOWN)
    }

    return Result.Success(result)
}

inline fun <reified T> mapFirebaseErrorToResult(e: FirebaseAuthException): Result<T, DataError.Network> {
    println(e.errorCode)
    return when(e.errorCode) {
        "ERROR_INVALID_EMAIL" -> Result.Error(DataError.Network.INVALID_EMAIL)
        "ERROR_EMAIL_ALREADY_IN_USE" -> Result.Error(DataError.Network.EMAIL_ALREADY_EXISTS)
        "auth/claims-too-large" -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
        "ERROR_USER_NOT_FOUND" -> Result.Error(DataError.Network.USER_NOT_FOUND)
        "ERROR_INTERNAL_ERROR" -> Result.Error(DataError.Network.SERVER_ERROR)
        "ERROR_INVALID_CREDENTIAL" -> Result.Error(DataError.Network.UNAUTHORIZED)
        else -> Result.Error(DataError.Network.UNKNOWN)
    }
}