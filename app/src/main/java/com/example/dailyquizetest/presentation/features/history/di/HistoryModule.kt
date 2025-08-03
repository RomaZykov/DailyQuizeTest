package com.example.dailyquizetest.presentation.features.history.di

import com.example.adminnavigation.RouteBuilder
import com.example.dailyquizetest.presentation.features.history.navigation.BaseHistoryRouteProvider
import com.example.dailyquizetest.presentation.features.history.navigation.HistoryRouteBuilder
import com.example.dailyquizetest.presentation.mainNavigation.HistoryRouteProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object HistoryModule {

    @Provides
    fun provideHistoryRouteProvider(): HistoryRouteProvider = BaseHistoryRouteProvider()

    @Provides
    @IntoSet
    fun provideHistoryRouteBuilder(): RouteBuilder = HistoryRouteBuilder()
}