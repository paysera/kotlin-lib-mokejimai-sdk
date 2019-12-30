package com.paysera.lib.mokejimai.entities

sealed class CompanyCreationType {

    data class CompanyIdentifier(
        val countryCode: String,
        val companyCode: String
    ) : CompanyCreationType()

    data class CompanyTask(
        val id: String,
        val countryCode: String,
        val solution: String
    ) : CompanyCreationType()

    fun getType(): String {
        return when(this) {
            is CompanyIdentifier -> "company_identifier"
            is CompanyTask -> "company_task"
        }
    }
}