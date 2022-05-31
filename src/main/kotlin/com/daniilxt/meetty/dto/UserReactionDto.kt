package com.daniilxt.meetty.dto

data class UserReactionDto(
    val id: Long,
    val reactions:List<ReactionDto>
)
