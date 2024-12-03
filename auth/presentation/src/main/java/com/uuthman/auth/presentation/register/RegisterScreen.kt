package com.uuthman.auth.presentation.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.uuthman.auth.presentation.R
import com.uuthman.auth.presentation.login.LoginAction
import com.uuthman.core.presentation.designsystem.Poppins
import com.uuthman.core.presentation.designsystem.UpTodoTheme
import com.uuthman.core.presentation.designsystem.components.UpTodoActionButton
import com.uuthman.core.presentation.designsystem.components.UpTodoPasswordTextField
import com.uuthman.core.presentation.designsystem.components.UpTodoScaffold
import com.uuthman.core.presentation.designsystem.components.UpTodoTextField
import com.uuthman.core.presentation.designsystem.components.UpTodoToolbar

@Composable
fun RegisterScreenRoot(
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
    onSuccessfulRegistration: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    RegisterScreenRootScreen(
        state = viewModel.state,
        onAction = { action ->
            when(action) {
                RegisterAction.OnLoginClick -> onLoginClick()
                RegisterAction.OnBackClick -> onBackClick()
                else -> Unit
            }
        }
    )
}

@Composable
private fun RegisterScreenRootScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit
) {

    UpTodoScaffold(
        topAppBar = {
            UpTodoToolbar(
                showBackButton = true,
                title = "",
                onBackClick = {
                    onAction(RegisterAction.OnBackClick)
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 24.dp)
                .padding(vertical = 32.dp)

        ) {
            Text(
                text = stringResource(id = R.string.register),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 32.sp
                )
            )
            Spacer(modifier = Modifier.height(55.dp))
            UpTodoTextField(
                state = state.email,
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = R.string.enter_email),
                title = stringResource(id = R.string.email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(23.dp))
            UpTodoPasswordTextField(
                state = state.password,
                hint = stringResource(id = R.string.enter_password),
                title = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth(),
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(RegisterAction.OnTogglePasswordVisibilityClick)
                }
            )
            Spacer(modifier = Modifier.height(70.dp))
            UpTodoActionButton(
                text = stringResource(id = R.string.register),
                isLoading = state.isRegistering,
                enabled = state.canRegister && !state.isRegistering,
                onClick = {

                }
            )



            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    append(stringResource(id = R.string.already_have_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(id = R.string.login)
                    )
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontFamily = Poppins
                        )
                    ) {
                        append(stringResource(id = R.string.login))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                ClickableText(
                    text = annotatedString,
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(
                            tag = "clickable_text",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            onAction(RegisterAction.OnLoginClick)
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenRootScreenPreview() {
     UpTodoTheme{
        RegisterScreenRootScreen(
            state = RegisterState(

            ),
            onAction = {}
        )
    }
}