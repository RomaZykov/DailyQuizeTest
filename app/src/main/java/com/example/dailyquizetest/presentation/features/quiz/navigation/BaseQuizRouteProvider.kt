package com.example.dailyquizetest.presentation.features.quiz.navigation

import com.example.dailyquizetest.presentation.mainNavigation.QuizRouteProvider
import com.example.dailyquizetest.presentation.mainNavigation.Route

class BaseQuizRouteProvider : QuizRouteProvider {
    override fun route(): Route = QuizRoute
}