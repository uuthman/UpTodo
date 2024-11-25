@file:OptIn(ExperimentalFoundationApi::class)

package com.uuthman.auth.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uuthman.core.presentation.designsystem.UpTodoTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.uuthman.auth.presentation.R
import com.uuthman.auth.presentation.onboarding.components.OnboardingSlider
import com.uuthman.auth.presentation.onboarding.model.Onboarding
import com.uuthman.core.presentation.designsystem.components.UpTodoActionButton
import com.uuthman.core.presentation.designsystem.components.UpTodoBackground
import com.uuthman.core.presentation.ui.UiText
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreenRoot(
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    OnboardingScreen(
        state = viewModel.state,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardingScreen(
    state: OnboardingState,
) {
    val pagerState = rememberPagerState(pageCount = { state.onboarding.size})

    val scope = rememberCoroutineScope()


    UpTodoBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(vertical = 14.dp)
        ) {
            Text(
                text = stringResource(R.string.skip),
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.44f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable {

                    }
            )
            OnboardingSlider(
                onboarding = state.onboarding,
                pagerState = pagerState,
                modifier = Modifier
                    .weight(1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = stringResource(R.string.back),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.44f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable {
                            if (pagerState.currentPage > 0) {
                                scope.launch {
                                    pagerState
                                        .animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        }
                )

                val isLastPage by remember(pagerState.currentPage) {
                    derivedStateOf {
                        val pageCount = state.onboarding.size
                        pageCount > 0 && pagerState.currentPage == pageCount - 1
                    }
                }

               UpTodoActionButton(
                   text = if(isLastPage) stringResource(R.string.get_started) else stringResource(R.string.next),
                   onClick = {
                       if (pagerState.currentPage < pagerState.pageCount - 1) {
                           scope.launch {
                               pagerState
                                   .animateScrollToPage(pagerState.currentPage + 1)
                           }
                       }
                   },
                   isLoading = false,
                   fillWidth = false
               )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }

    }
}



@Preview
@Composable
private fun OnboardingScreenPreview() {
    UpTodoTheme {
        OnboardingScreen(
            state = OnboardingState(
                onboarding =  listOf(
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
        )
    }
}