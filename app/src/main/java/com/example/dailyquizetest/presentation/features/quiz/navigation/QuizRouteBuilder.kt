package com.example.dailyquizetest.presentation.features.welcome.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.adminnavigation.RouteBuilder
import com.example.dailyquizetest.presentation.features.quiz.navigation.QuizRoute

class QuizRouteBuilder : RouteBuilder {
    override fun build(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<QuizRoute> {
            QuizRoute.Content(navController = navController)
        }
    }
}