package com.example.dailyquizetest.presentation.features.quiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dailyquizetest.presentation.features.quiz.QuizScreen
import com.example.dailyquizetest.presentation.mainNavigation.Route
import com.example.dailyquizetest.presentation.features.welcome.WelcomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object QuizRoute : Route {
    @Composable
    override fun Content(navController: NavController) {
        QuizScreen()
    }
}
