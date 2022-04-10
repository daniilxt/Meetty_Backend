package com.daniilxt.meetty.dto

import java.time.LocalDate
import java.time.LocalTime

data class MessageDto(
    val id: Long,
    val date: LocalDate,
    val time: LocalTime,
    val content: String,
    val reactions: List<ReactionDto> = emptyList(),
    val sender: UserDto
)