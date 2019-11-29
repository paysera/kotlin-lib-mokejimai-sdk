package com.paysera.lib.mokejimai.retrofit

import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import com.google.gson.GsonBuilder
import com.paysera.lib.mokejimai.clients.MokejimaiApiClient
import com.paysera.lib.mokejimai.entities.MokejimaiApiCredentials
import com.paysera.lib.mokejimai.interfaces.TokenRefresherInterface
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIFactory(private val credentials: MokejimaiApiCredentials, private val timeout: Long? = null) {
    fun createClient(
        tokenRefresherInterface: TokenRefresherInterface,
        baseUrl: String = "https://bank.paysera.com/"
    ): MokejimaiApiClient {
        return MokejimaiApiClient(createRetrofitClient(baseUrl), tokenRefresherInterface)
    }

    private fun createRetrofitClient(baseUrl: String): APIClient {
        return createRetrofit(baseUrl)
                .create(APIClient::class.java)
    }

    private fun createRetrofit(baseUrl: String) = with(Retrofit.Builder()) {
        baseUrl(baseUrl)
        addConverterFactory(createGsonConverterFactory())
        addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        client(createOkHttpClient())
        build()
    }

    private fun createOkHttpClient() = with(OkHttpClient().newBuilder()) {
        timeout?.let {
            readTimeout(it, TimeUnit.MILLISECONDS)
            writeTimeout(it, TimeUnit.MILLISECONDS)
            connectTimeout(it, TimeUnit.MILLISECONDS)
        }
        addInterceptor { chain ->
            val originalRequest = chain.request()
            val builder =
                    originalRequest.newBuilder().header("Authorization", "Bearer ${credentials.accessToken}")
            val modifiedRequest = builder.build()
            chain.proceed(modifiedRequest)
        }
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        build()
    }

    private fun createGsonConverterFactory(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
        return GsonConverterFactory.create(gsonBuilder.create())
    }
}