package com.daniilxt.meetty.request

data class AuthRequest(
    val login: String,
    val password: String
)