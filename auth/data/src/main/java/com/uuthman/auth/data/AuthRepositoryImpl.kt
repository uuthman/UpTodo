package com.uuthman.auth.data

import com.google.firebase.auth.FirebaseAuth
import com.uuthman.auth.domain.AuthRepository
import com.uuthman.core.data.networking.safeCall
import com.uuthman.core.domain.AuthInfo
import com.uuthman.core.domain.SessionStorage
import com.uuthman.core.domain.util.DataError
import com.uuthman.core.domain.util.EmptyResult
import com.uuthman.core.domain.util.Result
import com.uuthman.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val sessionStorage: SessionStorage
): AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = safeCall {
             firebaseAuth.signInWithEmailAndPassword(email,password).await()
        }
        if(result is Result.Success) {
            val user = result.data.user
            user?.let {
                sessionStorage.set(
                    AuthInfo(
                        email = it.email!!,
                        name = "",
                        photoUrl = "",
                        userId = it.uid
                    )
                )
            }

        }

        return  result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return safeCall {
            firebaseAuth.createUserWithEmailAndPassword(email,password).await()
        }
    }
}