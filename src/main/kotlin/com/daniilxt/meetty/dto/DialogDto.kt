package com.daniilxt.meetty.dto

data class DialogDto(
    val id: Long,
    val lastMessage: MessageDto,
    val firstUser: SimpleUserDto,
    val secondUser: SimpleUserDto
)