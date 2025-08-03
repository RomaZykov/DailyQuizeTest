package com.example.dailyquizetest.presentation.features.history

import androidx.lifecycle.ViewModel
import com.example.dailyquizetest.presentation.features.history.model.EmptyHistory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface HistoryViewModel {

    fun historyUiStateFlow(): StateFlow<HistoryUiState>

    @HiltViewModel
    class Base @Inject constructor() : ViewModel(), HistoryViewModel {
        private val uiState = MutableStateFlow(EmptyHistory)

        override fun historyUiStateFlow(): StateFlow<HistoryUiState> {
            return uiState.asStateFlow()
        }
    }
}