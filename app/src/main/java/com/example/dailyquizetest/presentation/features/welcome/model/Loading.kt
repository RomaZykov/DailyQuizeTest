package com.example.dailyquizetest.presentation.features.welcome.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyquizetest.presentation.common.screen.Loading
import com.example.dailyquizetest.presentation.features.welcome.WelcomeUiState

object Loading : WelcomeUiState {
    @Composable
    override fun Display(onStartQuizClicked: () -> Unit) {
        Loading()
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingPreview() {
    Loading.Display {}
}