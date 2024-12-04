package com.uuthman.core.presentation.ui

import com.uuthman.core.domain.util.DataError

fun DataError.asUiText(): UiText {
    return when(this) {
        DataError.Local.DISK_FULL -> UiText.StringResource(
            R.string.error_disk_full
        )
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(
            R.string.error_request_timeout
        )
        DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResource(
            R.string.error_too_many_requests
        )
        DataError.Network.NO_INTERNET -> UiText.StringResource(
            R.string.error_no_internet
        )
        DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringResource(
            R.string.error_payload_too_large
        )
        DataError.Network.SERVER_ERROR -> UiText.StringResource(
            R.string.error_server_error
        )
        DataError.Network.INVALID_EMAIL -> UiText.StringResource(
            R.string.invalid_email
        )
        DataError.Network.USER_NOT_FOUND -> UiText.StringResource(
            R.string.user_not_found
        )
        DataError.Network.EMAIL_ALREADY_EXISTS -> UiText.StringResource(
            R.string.email_exists
        )
        DataError.Network.UNAUTHORIZED -> UiText.StringResource(
            R.string.error_email_password_incorrect
        )
        else -> UiText.StringResource(R.string.error_unknown)
    }
}