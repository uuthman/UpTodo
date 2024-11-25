package com.uuthman.auth.presentation.onboarding

import com.uuthman.auth.presentation.onboarding.model.Onboarding

data class OnboardingState(
    val onboarding: List<Onboarding> = emptyList()
)