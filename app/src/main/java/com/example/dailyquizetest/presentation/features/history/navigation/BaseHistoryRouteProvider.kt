package com.example.dailyquizetest.presentation.features.history.navigation

import com.example.dailyquizetest.presentation.features.history.navigation.HistoryRoute
import com.example.dailyquizetest.presentation.mainNavigation.HistoryRouteProvider
import com.example.dailyquizetest.presentation.mainNavigation.QuizRouteProvider
import com.example.dailyquizetest.presentation.mainNavigation.Route

class BaseHistoryRouteProvider : HistoryRouteProvider {
    override fun route(): Route = HistoryRoute
}