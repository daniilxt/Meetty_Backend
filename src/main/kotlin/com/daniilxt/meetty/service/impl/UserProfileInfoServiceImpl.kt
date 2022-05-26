package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.UserAdditionalInfoDto
import com.daniilxt.meetty.dto.UserProfileInfoDto
import com.daniilxt.meetty.entity.toEducationInstitutionDto
import com.daniilxt.meetty.entity.toProfessionalInterestDto
import com.daniilxt.meetty.entity.toUserAchievementDto
import com.daniilxt.meetty.entity.toUserDto
import com.daniilxt.meetty.exception.AuthException
import com.daniilxt.meetty.repository.UserAchievementRepository
import com.daniilxt.meetty.repository.UserEducationRepository
import com.daniilxt.meetty.repository.UserProfessionalInterestRepository
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.service.UserInfoProfileService
import org.springframework.stereotype.Service

@Service
class UserProfileInfoServiceImpl(
    private val userRepository: UserRepository,
    private val userEducationRepository: UserEducationRepository,
    private val userAchievementRepository: UserAchievementRepository,
    private val userProfessionalInterestRepository: UserProfessionalInterestRepository,
) : UserInfoProfileService {
    override fun getProfileInfo(userEmail: String): UserProfileInfoDto {
        val user = userRepository.getByEmail(userEmail) ?: throw AuthException.InvalidUser()
        return UserProfileInfoDto(
            userInfo = user.toUserDto(),
            userAdditionalInfo = UserAdditionalInfoDto(
                professionalInterests = userProfessionalInterestRepository.getByUserId(user.id)
                    .map { it.toProfessionalInterestDto() },
                userBirthday = user.birthDay
            ),
            userAchievements = userAchievementRepository.getUserAchievementsEntitiesByUserId(user.id)
                .map { it.toUserAchievementDto() },
            userEducation = userEducationRepository.getUserEducationEntityByUserId(
                user.id
            ).university.toEducationInstitutionDto(),
            lastActivity = null
        )
    }
}