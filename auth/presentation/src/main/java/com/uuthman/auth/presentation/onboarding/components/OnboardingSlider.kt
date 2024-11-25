@file:OptIn(ExperimentalFoundationApi::class)

package com.uuthman.auth.presentation.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uuthman.auth.presentation.R
import com.uuthman.auth.presentation.onboarding.model.Onboarding
import com.uuthman.core.presentation.designsystem.UpTodoTheme
import com.uuthman.core.presentation.ui.UiText

@Composable
fun OnboardingSlider(
    modifier: Modifier = Modifier,
    onboarding: List<Onboarding>,
    pagerState: PagerState
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            key = {onboarding[it].image}
        ) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(227.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = onboarding[index].image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(271.dp)
                        .width(296.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(42.dp))
        IndicatorTile(
            pageCount = onboarding.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text =  onboarding[pagerState.currentPage].title.asString(),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 32.sp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(42.dp))
        Text(
            text =  onboarding[pagerState.currentPage].description.asString(),
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun IndicatorTile(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index -> // Same number as page count
            Indicator(
                isSelected = index == currentPage
            )
        }
    }
}

@Composable
private fun Indicator(
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .width(26.dp)
            .height(4.dp)
            .background(
                color =
                if (isSelected)
                    MaterialTheme.colorScheme.onBackground.copy(alpha = 0.87f)
                else
                    MaterialTheme.colorScheme.onSurfaceVariant,
                shape = CircleShape
            )
    )
}


@Preview
@Composable
private fun OnboardingSliderPreview() {
    val pagerState = rememberPagerState(pageCount = {2})
    UpTodoTheme {
        OnboardingSlider(
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
            ),
            pagerState = pagerState

        )
    }
}