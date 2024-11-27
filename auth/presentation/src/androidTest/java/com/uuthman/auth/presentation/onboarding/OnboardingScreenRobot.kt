package com.uuthman.auth.presentation.onboarding


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

class OnboardingScreenRobot(
    private val composeRule: ComposeContentTestRule
) {

    fun assertTitleIsDisplayed(title: String): OnboardingScreenRobot {
        composeRule.onNodeWithText(title).assertIsDisplayed()
        return this
    }

    fun assertNextButtonIsDisplayed(): OnboardingScreenRobot {
        composeRule.onNodeWithText("Next").assertIsDisplayed()
        return this
    }

    fun clickNext(): OnboardingScreenRobot {
        composeRule.onNodeWithText("Next").performClick()
        return this
    }

    fun assertGetStartedButtonIsDisplayed(): OnboardingScreenRobot {
        composeRule.onNodeWithText("Get Started").assertIsDisplayed()
        return this
    }

    fun assertBackButtonIsDisplayed(): OnboardingScreenRobot {
        composeRule.onNodeWithText("Back").assertIsDisplayed()
        return this
    }

    fun clickBack(): OnboardingScreenRobot {
        composeRule.onNodeWithText("Back").performClick()
        return this
    }

}