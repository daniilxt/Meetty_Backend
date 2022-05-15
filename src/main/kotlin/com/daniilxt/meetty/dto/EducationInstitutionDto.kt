package com.daniilxt.meetty.dto

import com.daniilxt.meetty.entity.UniversityEntity

data class EducationInstitutionDto(
    val id: Long? = null,
    val name: String,
    val location: LocationInfoDto,
    val logoUri: String = ""
)

fun EducationInstitutionDto.toUniversityEntity() =
    UniversityEntity(
        name = this.name,
        locationInfo = this.location.toLocationInfoEntity(),
        logo = logoUri
    )