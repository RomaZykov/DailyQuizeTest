package com.example.dailyquizetest.presentation.mainNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dailyquizetest.R
import com.example.dailyquizetest.presentation.features.history.navigation.HistoryRoute
import com.example.dailyquizetest.presentation.features.quiz.navigation.QuizRoute
import com.example.dailyquizetest.presentation.features.welcome.components.Logo
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizTheme

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: Any,
    viewModel: NavigationViewModel = hiltViewModel<NavigationViewModel>()
) {
    Scaffold(
        topBar = { QuizAppBar(navController) },
        containerColor = DailyQuizTheme.colorScheme.primary
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            viewModel.buildRoutes(this, navController)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun QuizAppBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route?.split(".")?.last()
    var isVisible by rememberSaveable { mutableStateOf(true) }
    isVisible = when (currentDestination) {
        QuizRoute.toString() -> true
        HistoryRoute.toString() -> false
        else -> true
    }
    AnimatedVisibility(isVisible) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors()
                .copy(containerColor = DailyQuizTheme.colorScheme.primary),
            title = {
                if (currentDestination == QuizRoute.toString()) {
                    Logo()
                } else {
                    Button(
                        colors = ButtonDefaults.buttonColors()
                            .copy(containerColor = DailyQuizTheme.colorScheme.secondary),
                        shape = RoundedCornerShape(24.dp),
                        onClick = {
                            navController.navigateIfResumed(HistoryRoute)
                        }) {
                        Row(
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                color = DailyQuizTheme.colorScheme.primary,
                                text = stringResource(R.string.history_button_text)
                            )
                            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                            Image(
                                painter = painterResource(R.drawable.history_icon),
                                contentDescription = null,
                            )
                        }
                    }
                }
            },
            expandedHeight = 160.dp
        )
    }
}

fun NavController.isResumed(): Boolean {
    return currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
}

fun NavController.navigateIfResumed(route: Any) {
    if (isResumed()) {
        navigate(route)
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuizAppBarPreview() {
    QuizAppBar(rememberNavController())
}