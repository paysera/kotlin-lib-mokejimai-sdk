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
//    fun createClient(
//        tokenRefresherInterface: TokenRefresherInterface,
//        baseUrl: String = "https://bank.paysera.com/"
//    ): MokejimaiApiClient {
//        return MokejimaiApiClient(createRetrofitClient(baseUrl), tokenRefresherInterface)
//    }
//
//    private fun createRetrofitClient(baseUrl: String): APIClient {
//        return createRetrofit(baseUrl)
//                .create(APIClient::class.java)
//    }
//
//    private fun createRetrofit(baseUrl: String) = with(Retrofit.Builder()) {
//        baseUrl(baseUrl)
//        addConverterFactory(createGsonConverterFactory())
//        addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//        client(createOkHttpClient())
//        build()
//    }
//
//    private fun createOkHttpClient() = with(OkHttpClient().newBuilder()) {
//        timeout?.let {
//            readTimeout(it, TimeUnit.MILLISECONDS)
//            writeTimeout(it, TimeUnit.MILLISECONDS)
//            connectTimeout(it, TimeUnit.MILLISECONDS)
//        }
//        addInterceptor { chain ->
//            val originalRequest = chain.request()
//            val builder =
//                    originalRequest.newBuilder().header("Authorization", "Bearer ${credentials.accessToken}")
//            val modifiedRequest = builder.build()
//            chain.proceed(modifiedRequest)
//        }
//        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
//        build()
//    }
//
//    private fun createGsonConverterFactory(): GsonConverterFactory {
//        val gsonBuilder = GsonBuilder()
//        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
//        return GsonConverterFactory.create(gsonBuilder.create())
//    }
//}