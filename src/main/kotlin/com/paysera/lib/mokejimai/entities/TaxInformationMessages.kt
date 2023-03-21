package com.paysera.lib.mokejimai.entities

import java.util.Date

data class TaxInformationMessages(
    val message: String?,
    val messageCode: String?,
    val tins: List<TinInformation>?
) {
    data class TinInformation(
        val tin: Tin,
        val expiresIn: Int,
        val message: String,
        val messageCode: String
    )

    data class Tin(
        val id: String,
        val uuid: String?,
        val userId: String,
        val userType: String,
        val country: String,
        val tin: String?,
        val updatedAt: Date?,
        val restrictionId: String?
    )
}