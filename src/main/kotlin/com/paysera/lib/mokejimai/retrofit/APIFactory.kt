package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.mokejimai.clients.MokejimaiApiClient
import okhttp3.logging.HttpLoggingInterceptor

class APIFactory(
    baseUrl: String,
    userAgent: String?,
    credentials: ApiCredentials?,
    certifiedHosts: List<String>,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface
) : BaseApiFactory<MokejimaiApiClient>(
    baseUrl,
    userAgent,
    credentials,
    certifiedHosts,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger
) {
    override fun createClient(tokenRefresher: TokenRefresherInterface?): MokejimaiApiClient {
        createRetrofit(tokenRefresher).apply {
            return MokejimaiApiClient(
                retrofit.create(APIClient::class.java),
                apiRequestManager
            )
        }
    }
}