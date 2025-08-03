package com.example.dailyquizetest.presentation.features.history.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dailyquizetest.presentation.features.history.HistoryScreen
import com.example.dailyquizetest.presentation.features.quiz.QuizScreen
import com.example.dailyquizetest.presentation.mainNavigation.Route
import kotlinx.serialization.Serializable

@Serializable
data object HistoryRoute : Route {
    @Composable
    override fun Content(navController: NavController) {
        HistoryScreen()
    }
}
