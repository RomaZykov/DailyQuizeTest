package com.example.dailyquizetest.presentation.features.history.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.adminnavigation.RouteBuilder

class HistoryRouteBuilder : RouteBuilder {
    override fun build(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<HistoryRoute> {
            HistoryRoute.Content(navController = navController)
        }
    }
}