package com.uuthman.auth.presentation.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.uuthman.auth.presentation.R
import com.uuthman.auth.presentation.onboarding.model.Onboarding
import com.uuthman.core.presentation.ui.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(OnboardingState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        val data = listOf(
            Onboarding(
                title =  UiText.StringResource(R.string.onboarding_one_title),
                description = UiText.StringResource(R.string.onboarding_one_description),
                image = R.drawable.onboarding_one
            ),
            Onboarding(
                title =  UiText.StringResource(R.string.onboarding_two_title),
                description = UiText.StringResource(R.string.onboarding_two_description),
                image = R.drawable.onboarding_two
            ),
            Onboarding(
                title =  UiText.StringResource(R.string.onboarding_three_title),
                description = UiText.StringResource(R.string.onboarding_three_description),
                image = R.drawable.onboarding_three
            ),
        )

        state = state.copy(onboarding = data)
    }
}