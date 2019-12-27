package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyAccount(
    val name: String,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("company_code") val companyCode: String
)