package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class CompanyCreationRequest(
    var managerId: Int,
    var type: String,
    val companyIdentifier: CompanyCreationType.CompanyIdentifier? = null,
    val companyTask: CompanyCreationType.CompanyTask? = null
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