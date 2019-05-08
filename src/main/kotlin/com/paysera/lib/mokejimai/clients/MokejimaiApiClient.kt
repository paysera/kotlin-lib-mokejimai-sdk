package com.paysera.lib.mokejimai.clients

import com.paysera.lib.mokejimai.entities.ManualTransferConfiguration
import com.paysera.lib.mokejimai.entities.MetadataAwareResponse
import com.paysera.lib.mokejimai.filters.ManualTransferConfigurationRequestFilter
import com.paysera.lib.mokejimai.interfaces.TokenRefresherInterface
import com.paysera.lib.mokejimai.retrofit.APIClient
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.util.concurrent.TimeUnit.SECONDS


class MokejimaiApiClient(
        private val apiClient: APIClient,
        private val tokenRefresherInterface: TokenRefresherInterface
) {

    private val retryCondition = { errors: Flowable<Throwable> ->
        errors.flatMap {
            val isUnauthorized = (it as? HttpException)?.code() == 401
            if (isUnauthorized) {
                synchronized(tokenRefresherInterface) {
                    if (tokenRefresherInterface.isRefreshing()) {
                        Flowable.timer(1, SECONDS).subscribeOn(Schedulers.io())
                    } else {
                        tokenRefresherInterface.refreshToken().toFlowable()
                    }
                }
            } else {
                Flowable.error(it)
            }
        }
    }

    fun getManualTransferConfigurationList(filter: ManualTransferConfigurationRequestFilter)
            : Single<MetadataAwareResponse<ManualTransferConfiguration>> {
        return apiClient
                .getManualTransferConfigurationAsync(
                        offset = filter.offset,
                        limit = filter.limit,
                        orderBy = filter.orderBy,
                        orderDirection = filter.orderDirection,
                        after = filter.after,
                        before = filter.before,
                        fromBankKey = filter.fromBankKey,
                        fromCountryCode = filter.fromCountryCode,
                        currency = filter.currency,
                        toBankKey = filter.toBankKey,
                        toCountryCode = filter.toCountryCode,
                        toIban = filter.toIban,
                        locale = filter.locale
                )
                .retryWhen(retryCondition)
    }
}