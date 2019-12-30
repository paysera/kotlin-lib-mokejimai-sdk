package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.mokejimai.entities.*
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface APIClient {

    @POST("log/rest/v1/logs")
    fun postLog(
        @Body logData: LogData
    ): Deferred<LogData>

    @GET("manual-transfer-configuration/rest/v1/configurations")
    fun getManualTransferConfigurationAsync(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?,
        @Query("from_bank_key") fromBankKey: String?,
        @Query("from_country_code") fromCountryCode: String?,
        @Query("currency") currency: String?,
        @Query("to_bank_key") toBankKey: String?,
        @Query("to_country_code") toCountryCode: String?,
        @Query("to_iban") toIban: String?,
        @Query("locale") locale: String?
    ): Deferred<MetadataAwareResponse<ManualTransferConfiguration>>

    @POST("company-account/rest/v1/company-accounts")
    fun createCompanyAccount(
        @Body request: CompanyCreationRequest
    ): Deferred<CompanyAccount>
}