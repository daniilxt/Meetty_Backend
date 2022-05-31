package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.UserProfileInfoDto

interface UserInfoProfileService {
    fun getProfileInfo(userEmail: String): UserProfileInfoDto
    fun getProfileInfoById(senderEmail: String, requestingUserId: Long): UserProfileInfoDto
}
