package com.example.dailyquizetest.presentation.features.welcome.di

import com.example.adminnavigation.RouteBuilder
import com.example.dailyquizetest.presentation.mainNavigation.WelcomeRouteProvider
import com.example.dailyquizetest.presentation.features.welcome.navigation.BaseWelcomeRouteProvider
import com.example.dailyquizetest.presentation.features.welcome.navigation.WelcomeRouteBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object WelcomeModule {

    @Provides
    fun provideWelcomeRouteProvider(): WelcomeRouteProvider = BaseWelcomeRouteProvider()

    @Provides
    @IntoSet
    fun provideWelcomeRouteBuilder(): RouteBuilder = WelcomeRouteBuilder()
}