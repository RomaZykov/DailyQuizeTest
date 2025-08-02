package com.example.dailyquizetest.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.dailyquizetest.R
import com.example.dailyquizetest.presentation.welcome.navigation.WelcomeRoute

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: Any,
    viewModel: NavigationViewModel = hiltViewModel<NavigationViewModel>()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                    Button(onClick = {

                    }) {
                        Text(stringResource(R.string.history_button_text))
                    }
                })
        }
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
fun MainNavigationPreview() {
    MainNavigation(
        navController = rememberNavController(),
        startDestination = WelcomeRoute,
        viewModel = hiltViewModel()
    )
}