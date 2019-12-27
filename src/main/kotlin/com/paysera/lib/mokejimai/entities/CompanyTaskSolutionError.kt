package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyTaskSolutionError(
    val id: String,
    @SerializedName("country_code") val countryCode: String,
    val type: String,
    @SerializedName("image_data") val imageData: String
)