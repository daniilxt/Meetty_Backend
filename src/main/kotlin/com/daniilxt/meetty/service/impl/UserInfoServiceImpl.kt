package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.dto.UserInfoDto
import com.daniilxt.meetty.dto.UserProfileInfoDto
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
) : UserInfoService {
    override fun getAnyUser(userEmail: String): UserInfoDto {
        val users = userRepository.findAll().filter { it.email != userEmail }
        val count = users.count()
        val user = users[Random.nextInt(0 until count)]
        return userInfoProfileService.getProfileInfo(user.email).toUserInfoDto()
    }
}

private fun UserProfileInfoDto.toUserInfoDto() = UserInfoDto(
    userInfo = userInfo,
    userAdditionalInfo = userAdditionalInfo,
    userAchievements = userAchievements,
    lastActivity = lastActivity
)
