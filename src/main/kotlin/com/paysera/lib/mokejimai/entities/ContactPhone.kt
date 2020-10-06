package com.paysera.lib.mokejimai.entities

data class ContactPhone(
    val id: String,
    val userId: String,
    val number: String,
    val status: String,
    val main: Boolean
)