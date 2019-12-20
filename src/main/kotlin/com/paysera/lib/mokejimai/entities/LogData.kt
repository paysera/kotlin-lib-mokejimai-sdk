package com.paysera.lib.mokejimai.entities

data class LogData(
    val action: String,
    val userId: String,
    val context: LogContext
)

data class LogContext(
    val appVersion: String
)