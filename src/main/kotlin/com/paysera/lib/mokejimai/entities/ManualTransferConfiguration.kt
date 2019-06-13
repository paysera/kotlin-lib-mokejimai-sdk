package com.paysera.lib.mokejimai.entities

import com.google.gson.annotations.SerializedName

data class ManualTransferConfiguration(
    @SerializedName("from_bank_key")                var fromBankKey: String,
    @SerializedName("from_bank_key_translation")    var fromBankKeyTranslation: String,
    @SerializedName("to_bank_key")                  var toBankKey: String,
    @SerializedName("to_bank_key_translation")      var toBankKeyTranslation: String,
    @SerializedName("currency")                     var currency: String,
    @SerializedName("to_country_code")              var toCountryCode: String,
    @SerializedName("to_iban")                      var toIban: String,
    @SerializedName("to_bic")                       var toBic: String,
    @SerializedName("to_beneficiary_name")          var toBeneficiaryName: String,
    @SerializedName("commission")                   var commission: Commission,
    @SerializedName("transfer_execution_time")      var transferExecutionTime: String,
    @SerializedName("transfer_execution_time_key")  var transferExecutionTimeKey: String,

    @SerializedName("from_country_code")            var fromCountryCode: String?,
    @SerializedName("to_account_number")            var toAccountNumber: String?,
    @SerializedName("to_bank_code")                 var toBankCode: String?,
    @SerializedName("sort_order")                   var sortOrder: String?,
    @SerializedName("correspondent_bank_name")      var correspondentBankName: String?,
    @SerializedName("correspondent_bank_swift")     var correspondentBankSwift: String?,
    @SerializedName("correspondent_bank_address")   var correspondentBankAddress: String?,
    @SerializedName("bank_address")                 var bankAddress: String?,
    @SerializedName("commission_percent")           var commissionPercent: String?,
    @SerializedName("commission_max_amount")        var commissionMaxAmount: String?,
    @SerializedName("commission_min_amount")        var commissionMinAmount: String?,
    @SerializedName("name")                         var name: String?
)
{
    data class Commission(
        @SerializedName("amount")                   var amount: String,
        @SerializedName("currency")                 var currency: String
    )
}