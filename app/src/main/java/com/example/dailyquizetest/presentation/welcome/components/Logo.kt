package com.example.dailyquizetest.presentation.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.dailyquizetest.R

@Composable
fun Logo() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        painter = painterResource(R.drawable.logo),
        contentDescription = stringResource(R.string.logo),
        alignment = Alignment.TopCenter
    )
}