package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.request.AuthRequest
import com.daniilxt.meetty.security.jwt.JwtTokenProvider
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.GrantedAuthority
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository

) {
    @PostMapping
    fun signIn(@RequestBody authRequest: AuthRequest): TokenDto {
        val authorities = ArrayList<GrantedAuthority>()
        val name: String = authRequest.login
        val token = jwtTokenProvider.createToken(
            name, emptyList()
        )
        return TokenDto(accessToken = token)
    }
}