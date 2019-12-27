package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyCreationRequest(
    @SerializedName("manager_id") var managerId: Int,
    @SerializedName("type") var type: String,
    @SerializedName("company_identifier") val identifier: CompanyCreationType.CompanyIdentifier? = null,
    @SerializedName("company_task") val task: CompanyCreationType.CompanyTask? = null
) {

    constructor(
        managerId: Int,
        type: String,
        identifier: CompanyCreationType.CompanyIdentifier? = null
    ) : this(managerId, type, identifier, null)

    constructor(
        managerId: Int,
        type: String,
        task: CompanyCreationType.CompanyTask? = null
    ) : this(managerId, type, null, task)
}