package com.paysera.lib.mokejimai.retrofit

import com.paysera.lib.mokejimai.entities.ManualTransferConfiguration
import com.paysera.lib.mokejimai.entities.MetadataAwareResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIClient {

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
    ) : Single<MetadataAwareResponse<ManualTransferConfiguration>>
}