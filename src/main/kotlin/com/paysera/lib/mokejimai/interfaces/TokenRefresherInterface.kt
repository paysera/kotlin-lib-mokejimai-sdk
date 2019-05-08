package com.paysera.lib.mokejimai.interfaces

import io.reactivex.Single

interface TokenRefresherInterface {
    fun refreshToken(): Single<Any>
    fun isRefreshing(): Boolean
}