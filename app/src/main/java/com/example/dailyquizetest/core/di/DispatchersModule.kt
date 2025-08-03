package com.example.dailyquizetest.core.di

import com.example.dailyquizetest.core.DispatcherList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Singleton
    fun provideDispatcherList(): DispatcherList = DispatcherList.Base()
}