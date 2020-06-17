package com.paysera.lib.mokejimai.filters

import com.paysera.lib.common.entities.BaseFilter

class IdentityDocumentsFilter(
    limit: Int? = null,
    val country: String
) : BaseFilter(
    limit = limit
)