package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.UserProfileInfoDto
import com.daniilxt.meetty.service.UserInfoProfileService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/profile")
class UserProfileController(
    private val userInfoProfileService: UserInfoProfileService,
) {
    @GetMapping("/my")
    fun getProfileInfo(@RequestHeader headers: HttpHeaders): UserProfileInfoDto {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        return userInfoProfileService.getProfileInfo(authenticatedUserEmail)
    }

    @GetMapping("/{id}")
    fun getProfileInfoById(@RequestHeader headers: HttpHeaders, @PathVariable id: Long): UserProfileInfoDto {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        return userInfoProfileService.getProfileInfoById(authenticatedUserEmail, id)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserProfileController::class.java)
    }
}