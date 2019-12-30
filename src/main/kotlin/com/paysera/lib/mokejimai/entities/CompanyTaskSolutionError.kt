package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyTaskSolutionError(
    val id: String,
    val countryCode: String,
    val type: String,
    val imageData: String
)