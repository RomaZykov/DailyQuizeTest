package com.example.dailyquizetest.presentation.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel<WelcomeViewModel.Base>()
) {
    val uiState by viewModel.welcomeUiStateFlow().collectAsState()
    uiState.Display(
        onStartQuizClicked = {
            viewModel.navigateToFilters(navController)
        }
    )
}

@Composable
@Preview(showSystemUi = true)
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}
