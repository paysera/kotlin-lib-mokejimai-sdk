package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.common.interfaces.BaseApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.mokejimai.clients.MokejimaiApiClient
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    userAgent: String?,
    credentials: BaseApiCredentials?,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<MokejimaiApiClient>(
    baseUrl,
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger,
    certificateInterceptor
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