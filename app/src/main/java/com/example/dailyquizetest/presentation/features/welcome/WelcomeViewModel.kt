package com.example.dailyquizetest.presentation.features.welcome

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.dailyquizetest.presentation.mainNavigation.navigateIfResumed
import com.example.dailyquizetest.presentation.features.welcome.model.Initial
import com.example.dailyquizetest.presentation.features.welcome.model.Loading
import com.example.dailyquizetest.presentation.mainNavigation.QuizRouteProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface WelcomeViewModel {

    fun welcomeUiStateFlow(): StateFlow<WelcomeUiState>

    fun navigateToFilters(navController: NavController) = Unit

    @HiltViewModel
    class Base @Inject constructor(
        private val quizRouteProvider: QuizRouteProvider
    ) : ViewModel(), WelcomeViewModel {

        private val uiState = MutableStateFlow<WelcomeUiState>(Initial(false))

        override fun welcomeUiStateFlow(): StateFlow<WelcomeUiState> {
            return uiState.asStateFlow()
        }

        override fun navigateToFilters(navController: NavController) {
            navController.navigateIfResumed(quizRouteProvider.route())
        }
    }
}