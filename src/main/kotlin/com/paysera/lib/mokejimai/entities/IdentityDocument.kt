package com.paysera.lib.mokejimai.entities

data class IdentityDocument (
    val id: Int,
    val type: String,
    val dateOfExpiry: String,
    val reviewStatus: String
)