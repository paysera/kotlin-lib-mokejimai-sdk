package com.paysera.lib.mokejimai.entities

data class AddContactPhoneRequest (
    val userId: String,
    val number: String,
    val status: String
)