package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.UserInfoDto

interface UserInfoService {
    fun getAnyUser(userEmail: String): UserInfoDto
    fun getMatchedUsers(userEmail: String): List<UserInfoDto>
}
