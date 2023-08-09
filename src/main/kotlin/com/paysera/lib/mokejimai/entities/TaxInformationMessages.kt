package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName
import java.util.Date

data class TaxInformationMessages(
    val messages: List<TinInformation>
) {
    data class TinInformation(
        val tin: Tin?,
        @SerializedName("expires_in")
        val expiresInDays: Int?,
        val message: String,
        val messageCode: String
    )

    data class Tin(
        val uuid: String?,
        val userId: String,
        val userType: String,
        val country: String,
        val tin: String?,
        val updatedAt: Date?,
        val restrictionId: String?
    )
}