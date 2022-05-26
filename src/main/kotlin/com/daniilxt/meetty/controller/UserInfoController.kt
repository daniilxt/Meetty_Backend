package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.UserInfoDto
import com.daniilxt.meetty.service.UserInfoService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/users")
class UserInfoController(
    private val userInfoService: UserInfoService,
) {
    @GetMapping("/any")
    fun getAnyUser(@RequestHeader headers: HttpHeaders): UserInfoDto {
        val authenticatedUserEmail = SecurityContextHolder.getContext().authentication.name
        return userInfoService.getAnyUser(authenticatedUserEmail)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserInfoController::class.java)
    }
}