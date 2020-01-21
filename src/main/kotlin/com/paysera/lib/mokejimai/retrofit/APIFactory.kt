package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.mokejimai.clients.MokejimaiApiClient
import okhttp3.logging.HttpLoggingInterceptor

class APIFactory(
    userAgent: String?,
    credentials: ApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
) : BaseApiFactory<MokejimaiApiClient>(
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel
) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): MokejimaiApiClient {
        createRetrofit(baseUrl, tokenRefresher).apply {
            return MokejimaiApiClient(
                retrofit.create(APIClient::class.java),
                apiRequestManager
            )
        }
    }
}