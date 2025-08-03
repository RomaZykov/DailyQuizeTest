package com.example.dailyquizetest.data.model.network.di

import com.example.dailyquizetest.data.model.network.NetworkQuizDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {
    @Binds
    abstract fun bindNetworkQuizDataSource(impl: NetworkQuizDataSource.Base): NetworkQuizDataSource
}