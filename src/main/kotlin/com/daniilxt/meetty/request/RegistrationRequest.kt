package com.daniilxt.meetty.request

data class RegistrationRequest(
    val userCredentials: UserCredentialsRequest,
    val userPersonalInfo: UserPersonalInfoRequest,
    val userEducationInfo: UserEducationInfoRequest,
    val professionalInterest: List<ProfessionalInterestRequest> = emptyList(),
    val userAchievements: List<UserAchievementRequest> = emptyList()
)