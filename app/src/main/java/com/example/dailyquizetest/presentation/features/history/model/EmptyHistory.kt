package com.example.dailyquizetest.presentation.features.history.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquizetest.R
import com.example.dailyquizetest.presentation.features.history.HistoryUiState
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizTheme

object EmptyHistory : HistoryUiState {
    @Composable
    override fun Display() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DailyQuizTheme.colorScheme.primary)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = stringResource(R.string.empty_history),
                style = DailyQuizTheme.typography.title,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyHistoryPreview() {
    EmptyHistory.Display()
}