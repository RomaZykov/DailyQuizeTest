package com.example.dailyquizetest.presentation.features.quiz

import androidx.compose.runtime.Composable

interface QuizUiState {

    @Composable
    fun Display()

    companion object {
        const val FILTERS_SCREEN = "FiltersScreen"
        const val QUIZ_SCREEN = "QuizScreen"
        const val RESULTS_SCREEN = "ResultsScreen"
    }
}