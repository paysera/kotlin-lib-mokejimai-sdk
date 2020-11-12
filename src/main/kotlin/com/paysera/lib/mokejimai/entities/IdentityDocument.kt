package com.paysera.lib.mokejimai.entities

data class IdentityDocument (
    val id: Int,
    val type: String,
    val expiry: String,
    val reviewStatus: String
)