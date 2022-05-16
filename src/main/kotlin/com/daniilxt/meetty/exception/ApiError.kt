package com.daniilxt.meetty.exception

data class ApiError(
    val errorCode: Int,
    val description: String
)