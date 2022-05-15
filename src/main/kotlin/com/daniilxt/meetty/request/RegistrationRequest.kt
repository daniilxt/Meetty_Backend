package com.daniilxt.meetty.request

import java.io.File
import java.time.LocalDate

data class RegistrationRequest(
    val userCredentials: UserCredentialsDto,
    val userPersonalInfo: UserPersonalInfoDto,
    val userEducationInfo: UserEducationInfoRequest,
    val professionalInterest: List<ProfessionalInterest> = emptyList(),
    val userAchievements: List<UserAchievement> = emptyList()
)

data class ProfessionalInterest(
    val id: Long,
    val interestName: String
)

data class UserAchievement(
    val title: String,
    val achievementDescription: String,
    val date: LocalDate
)

data class UserCredentialsDto(
    val email: String,
    val password: String
)

data class UserPersonalInfoDto(
    val firstName: String,
    val lastName: String,
    val birthDay: LocalDate,
    val phoneNumber: String,
    val sex: String
)

data class UserEducationInfoRequest(
    val instituteId: Long,
    val photos: List<File> = emptyList()
)
