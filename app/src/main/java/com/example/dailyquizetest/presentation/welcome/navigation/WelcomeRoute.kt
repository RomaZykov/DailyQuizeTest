package com.example.dailyquizetest.presentation.welcome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dailyquizetest.presentation.navigation.Route
import com.example.dailyquizetest.presentation.welcome.WelcomeScreen
import kotlinx.serialization.Serializable

@Serializable
object WelcomeRoute : Route {
    @Composable
    override fun Content(navController: NavController) {
        WelcomeScreen(navController = navController)
    }
}
