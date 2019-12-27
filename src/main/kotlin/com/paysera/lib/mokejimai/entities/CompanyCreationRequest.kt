package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyCreationRequest (
    @SerializedName("manager_id") val managerId: Int,
    @SerializedName("type") val type: String
)