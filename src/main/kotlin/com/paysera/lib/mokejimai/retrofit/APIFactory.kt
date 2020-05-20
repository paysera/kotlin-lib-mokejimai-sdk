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
    override val baseUrl = "https://bank.paysera.com/"
    override val certifiedHosts = listOf("bank.paysera.com")

    override fun createClient(tokenRefresher: TokenRefresherInterface?): MokejimaiApiClient {
        createRetrofit(tokenRefresher).apply {
            return MokejimaiApiClient(
                retrofit.create(APIClient::class.java),
                apiRequestManager
            )
        }
    }
}