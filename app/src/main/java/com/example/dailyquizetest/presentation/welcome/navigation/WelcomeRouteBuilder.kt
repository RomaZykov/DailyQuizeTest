package com.example.dailyquizetest.presentation.welcome.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.adminnavigation.RouteBuilder

class WelcomeRouteBuilder : RouteBuilder {
    override fun build(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<WelcomeRoute> {
            WelcomeRoute.Content(navController = navController)
        }
    }
}