package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.mokejimai.clients.MokejimaiApiClient

class APIFactory(credentials: ApiCredentials, timeout: Long? = null) : BaseApiFactory<MokejimaiApiClient>(credentials, timeout) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): MokejimaiApiClient {
        return MokejimaiApiClient(
            createRetrofit(baseUrl, tokenRefresher).create(APIClient::class.java)
        )
    }
}