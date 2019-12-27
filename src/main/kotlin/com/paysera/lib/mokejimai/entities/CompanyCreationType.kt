package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

sealed class CompanyCreationType {

    data class CompanyIdentifier(
        @SerializedName("country_code") val countryCode: String,
        @SerializedName("company_code") val companyCode: String
    ) : CompanyCreationType()

    data class CompanyTask(
        val id: String,
        @SerializedName("country_code") val countryCode: String,
        val solution: String
    ) : CompanyCreationType()

    fun getType(): String {
        return when(this) {
            is CompanyIdentifier -> "company_identifier"
            is CompanyTask -> "company_task"
        }
    }
}