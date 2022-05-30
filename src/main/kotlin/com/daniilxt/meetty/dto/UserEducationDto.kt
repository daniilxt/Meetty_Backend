package com.daniilxt.meetty.dto

import java.time.LocalDate

data class UserEducationDto(
    val id: Long,
    val user: String,
    val date: LocalDate,
    val title: String
)
