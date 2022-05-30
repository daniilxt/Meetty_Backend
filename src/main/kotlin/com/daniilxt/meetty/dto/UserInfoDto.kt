package com.daniilxt.meetty.dto

import java.time.LocalDateTime

data class UserInfoDto(
    val userInfo: SimpleUserDto,
    val userAdditionalInfo: UserAdditionalInfoDto,
    val userEducation: EducationInstitutionDto,
    val lastActivity: LocalDateTime?
)
