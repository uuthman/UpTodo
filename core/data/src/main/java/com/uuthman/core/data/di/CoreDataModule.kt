package com.uuthman.core.data.di

import com.uuthman.core.data.auth.EncryptedSessionStorage
import com.uuthman.core.domain.SessionStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CoreDataModule {

    @Binds
    @Singleton
    abstract fun bindSessionStorage(
        encryptedSessionStorage: EncryptedSessionStorage
    ): SessionStorage
}