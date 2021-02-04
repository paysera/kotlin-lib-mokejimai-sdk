package com.paysera.lib.mokejimai.entities

data class UserAccount(
    val id: Int,
    val identifier: String,
    val displayName: String?,
    val type: String,
    val code: String?
)