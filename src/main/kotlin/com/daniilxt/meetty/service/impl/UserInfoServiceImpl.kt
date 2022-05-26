package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.UserAdditionalInfoDto
import com.daniilxt.meetty.dto.UserInfoDto
import com.daniilxt.meetty.entity.toProfessionalInterestDto
import com.daniilxt.meetty.entity.toUserDto
import com.daniilxt.meetty.repository.*
import com.daniilxt.meetty.service.UserInfoService
import org.springframework.stereotype.Service
import kotlin.random.Random
import kotlin.random.nextInt

@Service
class UserInfoServiceImpl(
    private val userDetailsRepository: UserDetailsRepository,
    private val userRepository: UserRepository,
    private val userEducationRepository: UserEducationRepository,
    private val universityRepository: UniversityRepository,
    private val userAchievementRepository: UserAchievementRepository,
    private val userProfessionalInterestRepository: UserProfessionalInterestRepository,
) : UserInfoService {
    override fun getAnyUser(userEmail: String): UserInfoDto {
        val users = userRepository.findAll().filter { it.email != userEmail }
        val count = users.count()
        val user = users[Random.nextInt(0 until count)]
        return UserInfoDto(
            userInfo = user.toUserDto(),
            userAdditionalInfo = UserAdditionalInfoDto(
                professionalInterests = userProfessionalInterestRepository.getByUserId(user.id)
                    .map { it.toProfessionalInterestDto() },
                userBirthday = user.birthDay
            )
        )
    }
}