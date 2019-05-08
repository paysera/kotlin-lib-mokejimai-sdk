package com.paysera.lib.mokejimai.entities

data class Metadata(
    val total: Int,
    val limit: Int,
    val offset: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)