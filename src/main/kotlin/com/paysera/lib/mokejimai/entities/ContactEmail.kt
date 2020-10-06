package com.paysera.lib.mokejimai.entities

data class ContactEmail (
    val id: String,
    val main: Boolean,
    val email: String,
    val active: Boolean,
    val userId: String
)