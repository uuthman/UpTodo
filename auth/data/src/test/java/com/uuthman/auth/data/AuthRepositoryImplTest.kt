package com.uuthman.auth.data

import android.text.TextUtils
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isTrue
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.uuthman.core.domain.util.DataError
import com.uuthman.core.domain.util.Result
import com.uuthman.core.test.SessionStorageFake
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AuthRepositoryImplTest {

    private lateinit var repositoryImpl: AuthRepositoryImpl
    private lateinit var sessionStorage: SessionStorageFake
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var mockAuthResult: AuthResult
    private lateinit var mockUser: FirebaseUser


    @BeforeEach
    fun setUp() {
        mockkStatic(TextUtils::class)
        mockkStatic("kotlinx.coroutines.tasks.TasksKt")
        every { TextUtils.isEmpty(any()) } answers { arg<String>(0).isEmpty() }
        firebaseAuth = mockk()
        mockUser = mockk<FirebaseUser>(relaxed = true)
        mockAuthResult = mockk<AuthResult>(relaxed = true)
        sessionStorage = SessionStorageFake()
        repositoryImpl = AuthRepositoryImpl(
            firebaseAuth = firebaseAuth,
            sessionStorage = sessionStorage
        )
    }

    @Test
    fun `login throws invalid email exception`() = runBlocking<Unit>{
        val exception = FirebaseAuthException(
            "ERROR_INVALID_EMAIL",
            "The email address is badly formatted."
        )


        coEvery {
            firebaseAuth.signInWithEmailAndPassword("uthman@","password123").await()
        } throws exception

        val result = repositoryImpl.login("uthman@","password123")

        assertThat(result is Result.Error).isTrue()
        val error = (result as Result.Error).error
        assertThat(error == DataError.Network.INVALID_EMAIL).isTrue()

    }

    @Test
    fun `login throws invalid credential exception`() = runBlocking<Unit>{
        val exception = FirebaseAuthException(
            "ERROR_INVALID_CREDENTIAL",
            "The email or password is incorrect."
        )


        coEvery {
            firebaseAuth.signInWithEmailAndPassword("invalid@credential.com","password123").await()
        } throws exception

        val result = repositoryImpl.login("invalid@credential.com","password123")

        assertThat(result is Result.Error).isTrue()
        val error = (result as Result.Error).error
        assertThat(error == DataError.Network.UNAUTHORIZED).isTrue()

    }


    @Test
    fun `login returns success`() = runTest{

        val mockTask = mockk<Task<AuthResult>>(relaxed = true) {
            every { isSuccessful } returns true
            every { result } returns mockAuthResult
            every { exception } returns null
        }

        coEvery { firebaseAuth.signInWithEmailAndPassword("uthman@gmail.com", "password123") } returns mockTask

        coEvery { mockTask.await() } returns mockAuthResult

        every { mockAuthResult.user } returns mockUser
        every { mockUser.email } returns "uthman@gmail.com"
        every { mockUser.uid } returns "123456"



        val result = repositoryImpl.login("uthman@gmail.com","password123")

        assertThat(result is Result.Success).isTrue()

        val authInfo = sessionStorage.get()

        assertThat(authInfo).isNotNull()
        assertThat(authInfo?.email).isEqualTo("uthman@gmail.com")
        assertThat(authInfo?.userId).isEqualTo("123456")
    }

    @Test
    fun `register throws email already in use exception`() = runTest {
        val exception = FirebaseAuthException(
            "ERROR_EMAIL_ALREADY_IN_USE",
            "The email address is already in use by another account."
        )

        coEvery {
            firebaseAuth.createUserWithEmailAndPassword("test@example.com", "password123").await()
        } throws exception


        val result = repositoryImpl.register("test@example.com", "password123")

        assertThat(result is Result.Error).isTrue()
        val error = (result as Result.Error).error
        assertThat(error == DataError.Network.EMAIL_ALREADY_EXISTS).isTrue()
    }

    @Test
    fun `register returns success`() = runTest {

        val mockTask = mockk<Task<AuthResult>>(relaxed = true) {
            every { isSuccessful } returns true
            every { result } returns mockAuthResult
            every { exception } returns null
        }

        coEvery { firebaseAuth.createUserWithEmailAndPassword("uthman@gmail.com", "password123") } returns mockTask

        coEvery { mockTask.await() } returns mockAuthResult

        val result = repositoryImpl.register("uthman@gmail.com","password123")


        assertThat(result is Result.Success).isTrue()
    }
}