package com.example.dailyquizetest.presentation.welcome.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquizetest.R
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizTheme
import com.example.dailyquizetest.presentation.welcome.WelcomeUiState
import com.example.dailyquizetest.presentation.welcome.components.Logo

data class Initial(val shouldShowError: Boolean) : WelcomeUiState {
    @Composable
    override fun Display(onStartQuizClicked: () -> Unit) {
        val shouldShowErrorToast = rememberSaveable { mutableStateOf(shouldShowError) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DailyQuizTheme.colorScheme.primary)
        ) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Logo()
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                WelcomeCard(onStartQuizClicked)
            }
            if (shouldShowErrorToast.value) {
                ToastError()
            }
        }
    }

    @Composable
    private fun ColumnScope.ToastError() {
        Box(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .clip(
                    RoundedCornerShape(32.dp)
                )
                .background(DailyQuizTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                text = stringResource(R.string.welcome_error_text)
            )
        }
    }

    @Composable
    private fun WelcomeCard(onStartQuizClicked: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(DailyQuizTheme.colorScheme.secondary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WelcomeText()
            StartQuizButton(onStartQuizClicked = {
                onStartQuizClicked.invoke()
            })
        }
    }

    @Composable
    private fun StartQuizButton(onStartQuizClicked: () -> Unit) {
        Button(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp)),
            onClick = { onStartQuizClicked.invoke() }, colors = ButtonDefaults.buttonColors().copy(
                DailyQuizTheme.colorScheme.primary
            )
        ) {
            Text(
                stringResource(R.string.start_quiz_button_text),
                style = DailyQuizTheme.typography.button
            )
        }
    }

    @Composable
    private fun WelcomeText() {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            text = stringResource(R.string.quiz_welcome_text),
            style = DailyQuizTheme.typography.title,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun InitialPreview() {
    Initial(
        true
    ).Display {

    }
}