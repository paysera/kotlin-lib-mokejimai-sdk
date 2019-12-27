package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyCreationRequest (
    @SerializedName("manager_id") val managerId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("company_task") val task: CompanyCreationType.CompanyTask? = null,
    @SerializedName("company_identifier") val identifier: CompanyCreationType.CompanyIdentifier? = null
)