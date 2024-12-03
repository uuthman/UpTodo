package com.uuthman.auth.data.di

import com.uuthman.auth.data.EmailPatternValidator
import com.uuthman.auth.domain.PatternValidator
import com.uuthman.auth.domain.UserDataValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthDataModule {

    @Provides
    @Singleton
    fun provideUserDataValidator(patternValidator: PatternValidator): UserDataValidator{
        return UserDataValidator(patternValidator)
    }
}