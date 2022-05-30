package com.daniilxt.meetty.dto

import java.time.LocalDate

data class UserAdditionalInfoDto(
    val professionalInterests: List<ProfessionalInterestDto>,
    val userBirthday: LocalDate,
    val userPhone: String? = null
)
