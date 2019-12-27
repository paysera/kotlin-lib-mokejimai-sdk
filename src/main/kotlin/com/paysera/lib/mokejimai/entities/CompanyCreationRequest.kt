package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyCreationRequest(
    @SerializedName("manager_id") var managerId: Int,
    var type: String,
    @SerializedName("company_identifier") val identifier: CompanyCreationType.CompanyIdentifier? = null,
    @SerializedName("company_task") val task: CompanyCreationType.CompanyTask? = null
) {

    constructor(
        managerId: Int,
        identifier: CompanyCreationType.CompanyIdentifier
    ) : this(managerId, identifier.getType(), identifier, null)

    constructor(
        managerId: Int,
        task: CompanyCreationType.CompanyTask
    ) : this(managerId, task.getType(), null, task)
}