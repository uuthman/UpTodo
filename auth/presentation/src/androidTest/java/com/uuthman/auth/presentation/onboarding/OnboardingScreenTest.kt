package com.uuthman.auth.presentation.onboarding


import androidx.compose.ui.test.junit4.createComposeRule
import com.uuthman.auth.presentation.R
import com.uuthman.auth.presentation.onboarding.model.Onboarding
import com.uuthman.core.presentation.designsystem.UpTodoTheme
import com.uuthman.core.presentation.ui.UiText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OnboardingScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent {
            UpTodoTheme {
                OnboardingScreen(
                    state = OnboardingState(
                        onboarding = listOf(
                            Onboarding(
                                title =  UiText.StringResource(R.string.onboarding_one_title),
                                description = UiText.StringResource(R.string.onboarding_one_description),
                                image = R.drawable.onboarding_one
                            ),
                            Onboarding(
                                title =  UiText.StringResource(R.string.onboarding_two_title),
                                description = UiText.StringResource(R.string.onboarding_two_description),
                                image = R.drawable.onboarding_two
                            )
                        )
                    ),
                    onClick = {

                    }
                )
            }
        }
    }


    @Test
    fun testOnboardingScreenUi_next() {
        OnboardingScreenRobot(composeRule)
            .assertTitleIsDisplayed("Manage your tasks")
            .assertNextButtonIsDisplayed()
            .clickNext()
            .assertTitleIsDisplayed("Create daily routine")
            .assertGetStartedButtonIsDisplayed()
    }

    @Test
    fun testOnboardingScreenUi_back() {
        OnboardingScreenRobot(composeRule)
            .assertTitleIsDisplayed("Manage your tasks")
            .clickBack()
            .assertTitleIsDisplayed("Manage your tasks")
            .assertNextButtonIsDisplayed()
            .clickNext()
            .assertTitleIsDisplayed("Create daily routine")
            .clickBack()
            .assertTitleIsDisplayed("Manage your tasks")
            .assertNextButtonIsDisplayed()

    }
}