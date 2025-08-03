package com.example.dailyquizetest.presentation.features.quiz.di

import com.example.adminnavigation.RouteBuilder
import com.example.dailyquizetest.presentation.features.quiz.navigation.BaseQuizRouteProvider
import com.example.dailyquizetest.presentation.features.welcome.navigation.QuizRouteBuilder
import com.example.dailyquizetest.presentation.mainNavigation.QuizRouteProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object QuizModule {

    @Provides
    fun provideQuizRouteProvider(): QuizRouteProvider = BaseQuizRouteProvider()

    @Provides
    @IntoSet
    fun provideQuizRouteBuilder(): RouteBuilder = QuizRouteBuilder()
}