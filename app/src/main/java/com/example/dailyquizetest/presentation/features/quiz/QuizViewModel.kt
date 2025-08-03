package com.example.dailyquizetest.presentation.features.quiz

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.dailyquizetest.core.DispatcherList
import com.example.dailyquizetest.domain.QuizRepository
import com.example.dailyquizetest.presentation.common.Categories
import com.example.dailyquizetest.presentation.common.Difficulties
import com.example.dailyquizetest.presentation.features.quiz.model.Filters
import com.example.dailyquizetest.presentation.features.quiz.model.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface QuizViewModel {

    fun quizUiStateFlow(): StateFlow<QuizUiState>

    fun initWithFilters()

    fun quizInProcess()

    fun getQuizResults()

    fun navigateToWelcome(navController: NavController) = Unit

    @HiltViewModel
    class Base @Inject constructor(
        private val quizRepository: QuizRepository,
        private val dispatcherList: DispatcherList
    ) : ViewModel(), QuizViewModel {

        private val uiState = MutableStateFlow<QuizUiState>(Loading)

        override fun quizUiStateFlow(): StateFlow<QuizUiState> {
            return uiState.asStateFlow()
        }

        override fun initWithFilters() {
            uiState.value = Filters(
                categories = Categories.entries.toList(),
                difficulties = Difficulties.entries.toList()
            )
        }

        override fun quizInProcess() {
            TODO("Not yet implemented")
        }

        override fun getQuizResults() {
            TODO("Not yet implemented")
        }

        override fun navigateToWelcome(navController: NavController) {
            super.navigateToWelcome(navController)
        }
    }
}