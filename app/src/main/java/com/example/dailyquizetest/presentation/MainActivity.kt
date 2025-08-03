package com.example.dailyquizetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.dailyquizetest.presentation.mainNavigation.MainNavigation
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizeTestTheme
import com.example.dailyquizetest.presentation.features.welcome.navigation.WelcomeRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyQuizeTestTheme {
                MainNavigation(
                    navController = rememberNavController(),
                    startDestination = WelcomeRoute
                )
            }
        }
    }
}
