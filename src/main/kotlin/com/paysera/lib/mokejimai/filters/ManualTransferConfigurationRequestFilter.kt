package com.paysera.lib.mokejimai.filters

import com.paysera.lib.common.entities.BaseFilter

class ManualTransferConfigurationRequestFilter(
    offset: Int? = null,
    limit: Int? = null,
    orderBy: String? = null,
    orderDirection: String? = null,
    after: String? = null,
    before: String? = null,
    val fromBankKey: String? = null,
    val fromCountryCode: String? = null,
    val currency: String? = null,
    val toBankKey: String? = null,
    val toCountryCode: String? = null,
    val toIban: String? = null,
    val locale: String? = null
) : BaseFilter(
    offset = offset,
    limit = limit,
    orderBy = orderBy,
    orderDirection = orderDirection,
    after = after,
    before = before
)