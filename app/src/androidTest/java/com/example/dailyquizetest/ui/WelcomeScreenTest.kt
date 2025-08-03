package com.example.dailyquizetest.ui

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dailyquizetest.R
import com.example.dailyquizetest.core.BaseComposeTest
import com.example.dailyquizetest.presentation.features.welcome.WelcomeScreen
import com.example.dailyquizetest.presentation.features.welcome.WelcomeUiState
import com.example.dailyquizetest.presentation.features.welcome.WelcomeViewModel
import com.example.dailyquizetest.presentation.features.welcome.model.Initial
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WelcomeScreenTest : BaseComposeTest() {

    private lateinit var navController: TestNavHostController

    private class FakeWelcomeViewModel : WelcomeViewModel {
        var welcomeUiStateFlowToReturn: WelcomeUiState = Initial(false)
        var simulateConnectionError = false
        var invokeNavigation = false

        override fun prepareQuiz() {
            if (simulateConnectionError) {
                welcomeUiStateFlowToReturn = Initial(true)
            }
        }

        override fun welcomeUiStateFlow(): StateFlow<WelcomeUiState> {
            return MutableStateFlow(welcomeUiStateFlowToReturn).asStateFlow()
        }

        override fun navigateToFilters(navController: NavController) {
            invokeNavigation = true
        }
    }

    private lateinit var fakeViewModel: FakeWelcomeViewModel

    @Test
    fun showWelcomeScreen() {
        restorationTester.setContent {
            navController = TestNavHostController(LocalContext.current)
            WelcomeScreen(
                navController = navController,
                viewModel = fakeViewModel
            )
        }
        composeTestRule.onNodeWithContentDescription(WelcomeUiState.INITIAL_SCREEN).assertExists()

        composeTestRule.onNodeWithText(string(R.string.history_button_text)).assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(string(R.string.quiz_welcome_text)).assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(string(R.string.start_quiz_button_text)).assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun showLoadingScreen_whenSuccessAfterStartButtonClicked() {
        restorationTester.setContent {
            navController = TestNavHostController(LocalContext.current)
            WelcomeScreen(
                navController = navController,
                viewModel = fakeViewModel
            )
        }
        composeTestRule.onNodeWithContentDescription(WelcomeUiState.INITIAL_SCREEN).assertExists()

        fakeViewModel.simulateConnectionError = true
    }

    @Test
    fun showErrorToast_whenNoInternetConnection() {

    }
}