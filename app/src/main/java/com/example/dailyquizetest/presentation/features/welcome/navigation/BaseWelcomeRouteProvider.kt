package com.example.dailyquizetest.presentation.features.welcome.navigation

import com.example.dailyquizetest.presentation.mainNavigation.Route
import com.example.dailyquizetest.presentation.mainNavigation.WelcomeRouteProvider

class BaseWelcomeRouteProvider : WelcomeRouteProvider {
    override fun route(): Route = WelcomeRoute
}