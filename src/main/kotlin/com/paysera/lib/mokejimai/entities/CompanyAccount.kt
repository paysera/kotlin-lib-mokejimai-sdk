package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyAccount(
    val name: String,
    val countryCode: String,
    val companyCode: String
)