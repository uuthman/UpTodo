package com.uuthman.auth.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uuthman.auth.presentation.R
import com.uuthman.core.presentation.designsystem.UpTodoTheme
import com.uuthman.core.presentation.designsystem.components.UpTodoActionButton
import com.uuthman.core.presentation.designsystem.components.UpTodoBackground
import com.uuthman.core.presentation.designsystem.components.UpTodoOutlinedActionButton

@Composable
fun WelcomeScreenRoot(
    onLogin: () -> Unit,
    onRegister: () -> Unit
) {
    WelcomeScreen(
        onRegister = onRegister,
        onLogin = onLogin
    )
}

@Composable
private fun WelcomeScreen(
    onLogin: () -> Unit,
    onRegister: () -> Unit
) {

    UpTodoBackground(
        hasToolbar = false
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = stringResource(R.string.welcome_to_uptodo),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 32.sp
                ),
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.87f
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = stringResource(R.string.login_to_your_account),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.87f
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
            )
            UpTodoActionButton(
                text = stringResource(R.string.login),
                isLoading = false,
                onClick = onLogin

            )
            Spacer(modifier = Modifier.height(28.dp))
            UpTodoOutlinedActionButton (
                text = stringResource(R.string.create_account),
                isLoading = false,
                onClick = onRegister

            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
     UpTodoTheme{
        WelcomeScreen(
            onLogin = {

            },
            onRegister = {

            }
        )
    }

}