package com.daniilxt.meetty.dto

import java.time.LocalDateTime

data class UserProfileInfoDto(
    val userInfo: SimpleUserDto,
    val userAdditionalInfo: UserAdditionalInfoDto,
    val userAchievements: List<UserAchievementDto>,
    val userEducation: EducationInstitutionDto,
    val lastActivity: LocalDateTime?
)
