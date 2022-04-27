package com.daniilxt.meetty.dto

data class EducationInstitutionDto(
    val id: Long,
    val name: String,
    val location: LocationInfoDto,
    val logoUri: String = ""
)
