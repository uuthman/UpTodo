@file:OptIn(ExperimentalMaterial3Api::class)

package com.uuthman.core.presentation.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uuthman.core.presentation.designsystem.ArrowLeftIcon
import com.uuthman.core.presentation.designsystem.Poppins
import com.uuthman.core.presentation.designsystem.R
import com.uuthman.core.presentation.designsystem.UpTodoTheme

@Composable
fun UpTodoToolbar(
    showBackButton: Boolean,
    title: String,
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = Poppins
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if(showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ArrowLeftIcon,
                        contentDescription = stringResource(id = R.string.go_back),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        },
    )
}

@Preview
@Composable
private fun UpTodoToolbarPreview() {
    UpTodoTheme {
        UpTodoToolbar(
            showBackButton = true,
            title = "UpTodo",
            modifier = Modifier.fillMaxWidth(),
        )
    }
}