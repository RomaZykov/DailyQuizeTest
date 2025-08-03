package com.example.dailyquizetest.data.di

import com.example.dailyquizetest.data.repository.QuizRepositoryImpl
import com.example.dailyquizetest.domain.QuizRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindQuizRepository(impl: QuizRepositoryImpl): QuizRepository
}