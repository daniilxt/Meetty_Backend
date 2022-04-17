package com.daniilxt.meetty.dto

import java.time.LocalDateTime

data class MessageDto(
    val id: Long,
    val dateTime: LocalDateTime,
    val content: String,
    val reactions: List<ReactionDto> = emptyList(),
    val sender: UserDto
)