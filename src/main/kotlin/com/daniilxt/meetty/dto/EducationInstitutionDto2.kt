package com.daniilxt.meetty.dto

data class EducationInstitutionDto2(
    val id: Long? = null,
    val name: String,
    val city: String,
    val address: String,
    val coordinates: String,
    val logoUri: String = ""
)