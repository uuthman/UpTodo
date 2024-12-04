package com.uuthman.core.test

import com.uuthman.core.domain.AuthInfo
import com.uuthman.core.domain.SessionStorage

class SessionStorageFake: SessionStorage {

    private var authInfo: AuthInfo? = null


    override suspend fun get(): AuthInfo? {
       return authInfo

    }

    override suspend fun set(info: AuthInfo?) {
        authInfo = info
    }
}