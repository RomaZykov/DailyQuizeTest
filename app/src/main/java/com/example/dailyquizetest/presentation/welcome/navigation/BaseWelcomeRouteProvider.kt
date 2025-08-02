package com.example.dailyquizetest.presentation.welcome.navigation

import com.example.dailyquizetest.presentation.navigation.Route
import com.example.dailyquizetest.presentation.navigation.WelcomeRouteProvider

class BaseWelcomeRouteProvider : WelcomeRouteProvider {
    override fun route(): Route = WelcomeRoute
}