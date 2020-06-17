package com.paysera.lib.mokejimai.clients

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.mokejimai.entities.*
import com.paysera.lib.mokejimai.filters.IdentityDocumentsFilter
import com.paysera.lib.mokejimai.filters.ManualTransferConfigurationRequestFilter
import com.paysera.lib.mokejimai.retrofit.APIClient
import kotlinx.coroutines.Deferred

class MokejimaiApiClient(
    private val apiClient: APIClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun postLog(logData: LogData): Deferred<LogData> {
        return apiClient.postLog(logData)
    }

    fun getManualTransferConfigurationList(
        filter: ManualTransferConfigurationRequestFilter
    ): Deferred<MetadataAwareResponse<ManualTransferConfiguration>> {
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
    }

    fun createCompanyAccount(request: CompanyCreationRequest): Deferred<CompanyAccount> {
        return apiClient.createCompanyAccount(request)
    }

    fun getCurrentUserAddresses(): Deferred<MetadataAwareResponse<UserAddress>> {
        return apiClient.getCurrentUserAddresses()
    }

    fun updateCurrentUserAddress(userAddress: UserAddress): Deferred<UserAddress> {
        return apiClient.updateCurrentUserAddress(userAddress)
    }

    fun getUserAccounts(userId: Int): Deferred<MetadataAwareResponse<UserAccount>> {
        return apiClient.getUserAccounts(userId)
    }

    fun getUserAddresses(userIdentifier: String): Deferred<MetadataAwareResponse<UserAddress>> {
        return apiClient.getUserAddresses(userIdentifier)
    }

    fun updateUserAddress(userIdentifier: String, addressType: String, userAddress: UserAddress): Deferred<UserAddress> {
        return apiClient.updateUserAddress(userIdentifier, addressType, userAddress)
    }

    fun getAvailableIdentityDocuments(filter: IdentityDocumentsFilter): Deferred<MetadataAwareResponse<IdentityDocuments>> {
        return apiClient.getAvailableIdentityDocuments(
            country = filter.country,
            limit = filter.limit)
    }
}