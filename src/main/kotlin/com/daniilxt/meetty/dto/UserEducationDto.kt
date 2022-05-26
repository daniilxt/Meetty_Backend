package com.daniilxt.meetty.dto

import java.time.LocalDate

data class UserEducationDto(
    val id: Long,
    val description: String,
    val date: LocalDate,
    val title: String
)
