package com.example.dailyquizetest.presentation.features.quiz

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = hiltViewModel<QuizViewModel.Base>()
) {
    val uiState by viewModel.quizUiStateFlow().collectAsStateWithLifecycle()
    viewModel.initWithFilters()
    uiState.Display()
}