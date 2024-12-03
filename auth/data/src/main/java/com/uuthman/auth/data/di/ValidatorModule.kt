package com.uuthman.auth.data.di

import com.uuthman.auth.data.EmailPatternValidator
import com.uuthman.auth.domain.PatternValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ValidatorModule {

    @Binds
    @Singleton
    abstract fun bindPatternValidator(
        emailPatternValidator: EmailPatternValidator
    ): PatternValidator
}