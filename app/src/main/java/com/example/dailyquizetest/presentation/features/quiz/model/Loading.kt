package com.example.dailyquizetest.presentation.features.quiz.model

import androidx.compose.runtime.Composable
import com.example.dailyquizetest.presentation.common.screen.Loading
import com.example.dailyquizetest.presentation.features.quiz.QuizUiState

object Loading : QuizUiState {
    @Composable
    override fun Display() {
        Loading()
    }
}