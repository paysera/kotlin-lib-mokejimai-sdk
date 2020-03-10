package com.paysera.lib.mokejimai.entities

data class UserAddress(
    var type: String,
    var countryCode: String,
    var countryName: String,
    var cityName: String,
    var transliteratedCityName: String?,
    var postalCode: String,
    var legacyAddress: String?,
    var streetName: String,
    var houseNumber: Int,
    var apartmentNumber: Int
)