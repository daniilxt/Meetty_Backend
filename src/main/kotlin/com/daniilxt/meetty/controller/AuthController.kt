package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.request.AuthRequest
import com.daniilxt.meetty.request.RegistrationRequest
import com.daniilxt.meetty.service.AuthService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun signIn(@RequestBody authRequest: AuthRequest): TokenDto {
        return authService.getToken(authRequest)
    }

    @PostMapping("/registration")
    fun register(@RequestBody registrationRequest: RegistrationRequest): TokenDto {
        logger.info("request $registrationRequest")
        return authService.save(registrationRequest)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AuthController::class.java)
    }
}