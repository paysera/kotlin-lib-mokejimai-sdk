package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

open class CompanyCreationRequest

data class CompanyCreationRequestIdentifier (
    @SerializedName("manager_id") val managerId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("company_identifier") val identifier: CompanyCreationType.CompanyIdentifier
) : CompanyCreationRequest()

data class CompanyCreationRequestTask (
    @SerializedName("manager_id") val managerId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("company_task") val identifier: CompanyCreationType.CompanyTask
) : CompanyCreationRequest()