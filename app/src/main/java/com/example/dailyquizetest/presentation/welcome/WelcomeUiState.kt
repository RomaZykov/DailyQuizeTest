package com.example.dailyquizetest.presentation.welcome

import androidx.compose.runtime.Composable

interface WelcomeUiState {
    @Composable
    fun Display(
        onStartQuizClicked: () -> Unit
    )

    companion object {
        const val LOADING_SCREEN = "LoadingScreen"
        const val INITIAL_SCREEN = "InitialScreen"
    }
}
