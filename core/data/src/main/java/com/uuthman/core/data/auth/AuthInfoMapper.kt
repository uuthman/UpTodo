package com.uuthman.core.data.auth

import com.uuthman.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        email = email,
        name= name,
        photoUrl = photoUrl,
        userId = userId
    )
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
    return AuthInfo(
        email = email,
        name= name,
        photoUrl = photoUrl,
        userId = userId
    )
}