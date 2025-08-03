package com.example.dailyquizetest.presentation.mainNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

interface Route {
    @Composable
    fun Content(navController: NavController)
}