package com.daniilxt.meetty.dto

data class UserDto(
    val id: Long = -1,
    val firstName: String = "",
    val lastName: String = "",
    val avatarLink: String = ""
)
