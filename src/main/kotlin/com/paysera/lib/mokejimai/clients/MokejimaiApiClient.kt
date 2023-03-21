package com.paysera.lib.mokejimai.clients

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.paysera.lib.common.entities.BaseFilter
import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.common.serializers.DateSerializer
import com.paysera.lib.mokejimai.entities.*
import com.paysera.lib.mokejimai.filters.ContactsFilter
import com.paysera.lib.mokejimai.filters.IdentityDocumentsFilter
import com.paysera.lib.mokejimai.filters.ManualTransferConfigurationRequestFilter
import com.paysera.lib.mokejimai.retrofit.APIClient
import kotlinx.coroutines.Deferred
import retrofit2.HttpException
import retrofit2.Response
import java.util.Date

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

    fun updateUserAddress(
        userIdentifier: String,
        addressType: String,
        userAddress: UserAddress
    ): Deferred<UserAddress> {
        return apiClient.updateUserAddress(userIdentifier, addressType, userAddress)
    }

    fun getAvailableIdentityDocuments(
        userIdentifier: String,
        filter: IdentityDocumentsFilter
    ): Deferred<MetadataAwareResponse<IdentityDocuments>> {
        return apiClient.getAvailableIdentityDocuments(
            userIdentifier,
            country = filter.country,
            limit = filter.limit
        )
    }

    fun getContactPhones(
        userIdentifier: String,
        contactsFilter: ContactsFilter
    ): Deferred<MetadataAwareResponse<ContactPhone>> {
        return apiClient.getContactPhones(
            userIdentifier,
            limit = contactsFilter.limit,
            offset = contactsFilter.offset
        )
    }

    fun getContactEmails(
        userIdentifier: String,
        contactsFilter: ContactsFilter
    ): Deferred<MetadataAwareResponse<ContactEmail>> {
        return apiClient.getContactEmails(
            userIdentifier,
            limit = contactsFilter.limit,
            offset = contactsFilter.offset
        )
    }

    fun deleteContactPhone(phoneIdentifier: String): Deferred<Response<Unit>> {
        return apiClient.deleteContactPhone(phoneIdentifier)
    }

    fun deleteContactEmail(emailIdentifier: String): Deferred<Response<Unit>> {
        return apiClient.deleteContactEmail(emailIdentifier)
    }

    fun addContactPhone(addContactPhoneRequest: AddContactPhoneRequest): Deferred<ContactPhone> {
        return apiClient.addContactPhone(addContactPhoneRequest)
    }

    fun addContactEmail(addContactEmailRequest: AddContactEmailRequest): Deferred<ContactEmail> {
        return apiClient.addContactEmail(addContactEmailRequest)
    }

    fun setContactPhoneAsMain(phoneIdentifier: String): Deferred<ContactPhone> {
        return apiClient.setContactPhoneAsMain(phoneIdentifier)
    }

    fun setContactEmailAsMain(emailIdentifier: String): Deferred<ContactEmail> {
        return apiClient.setContactEmailAsMain(emailIdentifier)
    }

    fun setContactPhoneAsMain(token: String, phoneIdentifier: String): Deferred<ContactPhone> {
        return apiClient.setContactPhoneAsMain(
            "Bearer $token",
            phoneIdentifier
        )
    }

    fun setContactEmailAsMain(token: String, emailIdentifier: String): Deferred<ContactEmail> {
        return apiClient.setContactEmailAsMain(
            "Bearer $token",
            emailIdentifier
        )
    }

    fun confirmContactPhone(
        phoneIdentifier: String,
        confirmContactPhoneRequest: ConfirmContactPhoneRequest
    ): Deferred<ContactPhone> {
        return apiClient.confirmContactPhone(
            phoneIdentifier,
            confirmContactPhoneRequest
        )
    }

    fun confirmContactEmail(
        emailIdentifier: String,
        confirmContactEmailRequest: ConfirmContactEmailRequest
    ): Deferred<ContactEmail> {
        return apiClient.confirmContactEmail(
            emailIdentifier,
            confirmContactEmailRequest
        )
    }

    fun getIdentityDocuments(
        userId: String,
        filter: BaseFilter
    ): Deferred<MetadataAwareResponse<PSIdentityDocument>> {
        return apiClient.getIdentityDocuments(
            userId,
            limit = filter.limit,
            offset = filter.offset
        )
    }

    fun disableAvatar(userId: String): Deferred<Response<Unit>> {
        return apiClient.disableAvatar(userId)
    }

    fun uploadAvatar(uploadAvatarRequest: UploadAvatarRequest): Deferred<Response<Unit>> {
        return apiClient.uploadAvatar(uploadAvatarRequest)
    }

    suspend fun taxInformationMessages(userId: String): TaxInformationMessages {
        val response = apiClient.taxInformationMessages(userId).await()
        return if (response.isSuccessful()) {
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date::class.java, DateSerializer())
                .create()
                .fromJson<TaxInformationMessages>(
                    response.body()?.string() ?: "{}",
                    TaxInformationMessages::class.java
                )
        } else {
            throw HttpException(response)
        }
    }
}