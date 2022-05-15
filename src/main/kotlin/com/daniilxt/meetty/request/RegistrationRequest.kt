package com.daniilxt.meetty.request

data class RegistrationRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)