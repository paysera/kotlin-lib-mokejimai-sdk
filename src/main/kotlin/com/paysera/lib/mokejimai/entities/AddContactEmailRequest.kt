package com.paysera.lib.mokejimai.entities

data class AddContactEmailRequest (
    val userId: String,
    val email: String,
    val status: String
)