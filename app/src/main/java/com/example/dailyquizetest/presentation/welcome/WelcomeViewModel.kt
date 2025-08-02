package com.example.dailyquizetest.presentation.welcome

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.dailyquizetest.domain.QuizRepository
import com.example.dailyquizetest.presentation.navigation.FiltersRouteProvider
import com.example.dailyquizetest.presentation.navigation.navigateIfResumed
import com.example.dailyquizetest.presentation.welcome.model.Initial
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface WelcomeViewModel {

    fun welcomeUiStateFlow() : StateFlow<WelcomeUiState>

    fun navigateToFilters(navController: NavController) = Unit

    fun prepareQuiz()

    class Base @Inject constructor(
        private val filtersRouteProvider: FiltersRouteProvider,
        private val quizRepository: QuizRepository
    ) : ViewModel(), WelcomeViewModel {

        private val _uiState = MutableStateFlow<WelcomeUiState>(Initial(false))

        override fun prepareQuiz() {
            TODO("Not yet implemented")
        }

        override fun welcomeUiStateFlow(): StateFlow<WelcomeUiState> {
            return _uiState.asStateFlow()
        }

        override fun navigateToFilters(navController: NavController) {
            navController.navigateIfResumed(filtersRouteProvider.route())
        }
    }
}