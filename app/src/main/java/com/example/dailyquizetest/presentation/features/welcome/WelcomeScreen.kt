package com.example.dailyquizetest.presentation.features.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel<WelcomeViewModel.Base>()
) {
    val uiState by viewModel.welcomeUiStateFlow().collectAsStateWithLifecycle()
    uiState.Display(
        onStartQuizClicked = {
            viewModel.navigateToFilters(navController)
        }
    )
}
