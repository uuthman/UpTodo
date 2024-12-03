package com.uuthman.uptodo

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uuthman.auth.presentation.login.LoginScreenRoot
import com.uuthman.auth.presentation.onboarding.OnboardingScreenRoot
import com.uuthman.auth.presentation.register.RegisterScreenRoot
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
                    navController.navigate("login")
                },
                onRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable(route = "login") {
            LoginScreenRoot(
                onLoginSuccess = {

                },
                onSignUpClick = {
                    navController.navigateWithPopUp(
                        destination = "register",
                        popUpToRoute = "login"
                    )
                },
                onBack = {
                    navController.navigateWithPopUp(
                        destination = "register",
                        popUpToRoute = "login"
                    )
                }
            )
        }


        composable(route = "register") {
            RegisterScreenRoot(
                onBackClick = {
                    navController.navigateWithPopUp(
                        destination = "login",
                        popUpToRoute = "register"
                    )
                },
                onLoginClick = {
                    navController.navigateWithPopUp(
                        destination = "login",
                        popUpToRoute = "register"
                    )
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                }
            )
        }
    }

}

private fun NavController.navigateWithPopUp(
    destination: String,
    popUpToRoute: String,
    inclusive: Boolean = true,
    saveState: Boolean = true,
    restoreState: Boolean = true
) {
    this.navigate(destination) {
        popUpTo(popUpToRoute) {
            this.inclusive = inclusive
            this.saveState = saveState
        }
        this.restoreState = restoreState
    }
}