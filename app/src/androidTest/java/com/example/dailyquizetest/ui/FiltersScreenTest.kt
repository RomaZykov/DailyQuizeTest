package com.example.dailyquizetest.ui

import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dailyquizetest.presentation.filters.FiltersViewModel
import com.example.dailyquizetest.presentation.welcome.WelcomeViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FiltersScreenTest {
    private class FakeFiltersViewModel : FiltersViewModel {

    }

    private lateinit var fakeViewModel: WelcomeViewModel

    @Before
    fun setUp() {
        restorationTester.setContent {
            WelcomeScreen(
                viewModel = fakeViewModel
            )
        }
        composeTestRule.onRoot(true).printToLog("GuideCreationScreenTag")
    }

    @Test
    fun showErrorToast_whenNoInternetConnection() {

    }

    @Test
    fun showErrorToast_whenNoInternetConnection() {

    }
}