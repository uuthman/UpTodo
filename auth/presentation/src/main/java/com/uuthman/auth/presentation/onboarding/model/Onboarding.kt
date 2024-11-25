package com.uuthman.auth.presentation.onboarding.model

import androidx.annotation.DrawableRes
import com.uuthman.core.presentation.ui.UiText

data class Onboarding(
    @DrawableRes val image: Int,
    val title: UiText,
    val description: UiText
)
