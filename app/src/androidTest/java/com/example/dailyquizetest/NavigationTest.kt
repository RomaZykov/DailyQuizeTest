package com.example.dailyquizetest

import android.content.Context
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.dailyquizetest.presentation.MainActivity
import com.example.dailyquizetest.presentation.navigation.MainNavigation
import com.example.dailyquizetest.presentation.welcome.navigation.WelcomeRoute
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private fun getString(@StringRes stringRes: Int, vararg args: Any): String =
        context.getString(stringRes, *args)

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        hiltRule.inject()
        composeTestRule.activity.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainNavigation(
                navController = navController,
                startDestination = WelcomeRoute
            )
        }
    }

    @Test
    fun fromWelcomeScreenToQuizCompleted() {
        composeTestRule
            .onNodeWithContentDescription(getString(R.string.quiz_welcome_screen))
            .assertIsDisplayed()
    }

    @Test
    fun fromWelcomeScreenToHistoryScreenAndBack() {
        composeTestRule
            .onNodeWithContentDescription(getString(R.string.quiz_welcome_screen))
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(getString(R.string.history_button_text))
            .assertExists()
            .assertIsDisplayed()
            .performClick()

        composeTestRule.onNodeWithContentDescription(getString(R.string.quiz_history_screen))
            .assertExists()
            .assertIsDisplayed()

        // Delete all history

        // Navigate back

        // Check welcome screen
    }
}