package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class ManualTransferConfiguration(
    var fromBankKey: String,
    var fromBankKeyTranslation: String,
    var toBankKey: String,
    var toBankKeyTranslation: String,
    var currency: String,
    var toCountryCode: String,
    var toIban: String,
    var toBic: String,
    var toBeneficiaryName: String,
    var commission: Commission,
    var transferExecutionTime: String,
    var transferExecutionTimeKey: String,

    var fromCountryCode: String?,
    var toAccountNumber: String?,
    var toBankCode: String?,
    var sortOrder: String?,
    var correspondentBankName: String?,
    var correspondentBankSwift: String?,
    var correspondentBankAddress: String?,
    var bankAddress: String?,
    var commissionPercent: String?,
    var commissionMaxAmount: String?,
    var commissionMinAmount: String?,
    var name: String?
)
{
    data class Commission(
        var amount: String,
        var currency: String
    )
}