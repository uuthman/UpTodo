package com.uuthman.auth.domain

import com.uuthman.core.domain.util.DataError
import com.uuthman.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}