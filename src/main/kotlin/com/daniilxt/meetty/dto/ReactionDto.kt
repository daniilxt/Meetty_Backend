package com.daniilxt.meetty.dto

data class ReactionDto(
    val id: Long,
    val emojiText: String,
    val usersId: List<Long>
)
