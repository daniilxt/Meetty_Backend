package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.UserInfoDto
import com.daniilxt.meetty.dto.UserProfileInfoDto
import com.daniilxt.meetty.exception.AuthException
import com.daniilxt.meetty.repository.UserProfessionalInterestRepository
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.service.UserInfoProfileService
import com.daniilxt.meetty.service.UserInfoService
import org.springframework.stereotype.Service
import kotlin.random.Random
import kotlin.random.nextInt

@Service
class UserInfoServiceImpl(
    private val userRepository: UserRepository,
    private val userInfoProfileService: UserInfoProfileService,
    private val userProfessionalInterestRepository: UserProfessionalInterestRepository
) : UserInfoService {
    override fun getAnyUser(userEmail: String): UserInfoDto {
        val users = userRepository.findAll().filter { it.email != userEmail }
        val count = users.count()
        val user = users[Random.nextInt(0 until count)]
        return userInfoProfileService.getProfileInfo(user.email).toUserInfoDto()
    }

    override fun getMatchedUsers(userEmail: String): List<UserInfoDto> {
        val user = userRepository.getByEmail(userEmail) ?: throw AuthException.InvalidUser()
        val userInterests = userProfessionalInterestRepository.getByUserId(user.id)
        return getUsersByUserInterests(userEmail, userInterests.map { it.interest.id })
    }

    private fun getUsersByUserInterests(userEmail: String, interests: List<Long>): List<UserInfoDto> {
        val result = userProfessionalInterestRepository.getUserProfessionalInterestEntityByInterestIdIn(interests)
        val users = result.filter { it.user.email != userEmail }.groupingBy { it.user }
            .eachCount().entries.sortedByDescending { it.value }.map { it.key }
        val usersProfile = mutableListOf<UserInfoDto>()
        users.forEach { userEntity ->
            val user = userInfoProfileService.getProfileInfo(userEntity.email).toUserInfoDto()
            usersProfile.add(user)
        }
        return usersProfile
    }
}

private fun UserProfileInfoDto.toUserInfoDto() = UserInfoDto(
    userInfo = userInfo,
    userAdditionalInfo = userAdditionalInfo,
    userEducation = userEducation,
    lastActivity = lastActivity
)