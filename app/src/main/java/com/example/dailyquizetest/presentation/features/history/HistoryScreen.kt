package com.example.dailyquizetest.presentation.features.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel<HistoryViewModel.Base>()
) {
    val uiState by viewModel.historyUiStateFlow().collectAsStateWithLifecycle()
    uiState.Display()
}