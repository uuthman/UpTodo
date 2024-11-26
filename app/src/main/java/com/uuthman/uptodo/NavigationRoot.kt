package com.uuthman.uptodo

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uuthman.auth.presentation.onboarding.OnboardingScreenRoot
import com.uuthman.auth.presentation.welcome.WelcomeScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "auth" else "auth"
    ) {
        authGraph(navController)
    }
}


private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "onboarding",
        route = "auth"
    ) {
        composable(route = "onboarding") {
            OnboardingScreenRoot(
                onClick = {
                    navController.navigate("welcome") {
                        popUpTo("onboarding") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = "welcome") {
            WelcomeScreenRoot(
                onLogin = {

                },
                onRegister = {

                }
            )
        }
    }


}