package com.paysera.lib.mokejimai

import com.paysera.lib.mokejimai.entities.MokejimaiApiCredentials
import com.paysera.lib.mokejimai.filters.ManualTransferConfigurationRequestFilter
import com.paysera.lib.mokejimai.interfaces.TokenRefresherInterface
import com.paysera.lib.mokejimai.retrofit.APIFactory
import io.reactivex.Single

fun main(args: Array<String>) {

    val accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJtb2tlamltYWkiLCJpc3MiOiJhdXRoX2FwaSIsImV4cCI6MTU1OTM0NTIxMCwianRpIjoiRHVyaC1nQUd5cDduUFZPM3JpQ1BfQ2NTQzJoWWVaZVAiLCJwc3I6cyI6WyJsb2dnZWRfaW4iXSwicHNyOnUiOiIxODY2MDEyIiwicHNyOnNpZCI6IkkzZk02Q2tqR05OZlFGYURfN0stRzVRaVVWbnQxQ1ZxIiwicHNyOmEiOnsidXNlcl9pZCI6IjE4NjYwMTIifSwiaWF0IjoxNTU5MzAyMDEwfQ.VtWRro-hk-JQ3HkFdXL8OsPreaZtZJKKSvQm9kC8fiOpshRYQr-WL_-IFrnVY8phggwqsTPKle2iBOv5159wZ6anNXPvTXKIAfAC79tJSlkycQVJ-ncrk5tzkVYerf-wHpC_oRqMSCQzsabkjtnRPcW5tkVt_Tc123auH3Yv9TNVZOk9zMfjNPp2r-DBwBKgjMO4kjswJAdWzhO0lIeRT7Cv9of7-UtGZSxj4MB6EDjagVWTIKG-hGexYLCkHOG659ZXvZLBGyZC3f-Ol0GyiTCMQCDwTsn5PTD4jdv49ftMZK0-3NqGFVodkXqL9mJpDnxpNnPq_Sh5VL1V1wL3N7HtotAN0ukLfhEmAK9mWaAmxgOP8YRvoDF4qHX-sIgGYsiOqgFk2OH5yfRyh3dvlHr-sZqoT6uMTQJCpQZq0dmve6PlxwNe_zrcP9MJD-jmK-S9kuRVugz6oKPKnphwMFJmn_SH7MkAIBJHq9DQuT5a2-W83Fcqn31th6rJT645WyL2opz2lvomqwJht8gt4xCPaseq7mxzN0lpLmVBP8692Mnh4p7t_CCvzh3eFxIE0tsq5YauxEwIt9rjVMq0SiF8EgLQ1s0MyFFmFsDCxKBuwKWN_RM8YSpKQGLCuzPLJTaI_Qd37UwLNg9CO1UvakpkBHuVOBtGKY2rjmS9N6I"

    val creds = MokejimaiApiCredentials(accessToken)

    val filter = ManualTransferConfigurationRequestFilter(
        limit = 250,
        locale = "lt"
    )

    val tokenRefresher = object : TokenRefresherInterface {
        override fun refreshToken(): Single<Any> {
            println("refreshToken() invoked")
            return Single.just(true)
        }

        override fun isRefreshing(): Boolean {
            println("isRefreshing() invoked")
            return false
        }

    }

    val apiClient = APIFactory(creds).createClient(tokenRefresher)


    apiClient.getManualTransferConfigurationList(filter)
        .subscribe(
            { response ->
                println("Successful call:: Metadata: ${response.metadata}")
                println("Successful call:: Got ${response.items.size} items")
                response.items.let {
                    it.forEach {
                        //                    println("Item: $it")
                        println("From_translation: ${it.fromBankKeyTranslation}; To_translation: ${it.toBankKeyTranslation}; executionTime: ${it.transferExecutionTimeKey}")
                    }
                    val timeKeys = it.map { it.transferExecutionTimeKey }.distinct()
                    println("Time keys: $timeKeys")
                }
            },
            { err ->
                println("Unsuccessful call:: $err")
            })

    Thread.sleep(2500)

}
