package com.paysera.lib.mokejimai.entities

import java.util.Date

data class UserAddress(
    var type: String,
    var countryCode: String,
    var countyName: String?,
    var cityName: String,
    var transliteratedCityName: String?,
    var postalCode: String,
    var legacyAddress: String?,
    var legacyCityName: String?,
    var streetName: String,
    var houseNumber: String,
    var apartmentNumber: String,
    var updatedAt: Date?
)