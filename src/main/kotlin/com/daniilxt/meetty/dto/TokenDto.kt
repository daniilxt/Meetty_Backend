package com.daniilxt.meetty.dto

data class TokenDto(
    val accessToken: String,
    val refreshToken: String = "",
    val userId: Long = -1
)