package com.example.dailyquizetest.presentation.welcome.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizTheme
import com.example.dailyquizetest.presentation.welcome.WelcomeUiState
import com.example.dailyquizetest.presentation.welcome.components.Logo

object Loading : WelcomeUiState {
    @Composable
    override fun Display(onStartQuizClicked: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DailyQuizTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center
        ) {
            Logo()
            Spacer(modifier = Modifier.padding(vertical = 48.dp))
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                strokeWidth = 4.dp,
                color = DailyQuizTheme.colorScheme.secondary,
                trackColor = DailyQuizTheme.colorScheme.background
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingPreview() {
    Loading.Display {

    }
}