package com.daniilxt.meetty.service

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.request.AuthRequest
import com.daniilxt.meetty.request.RegistrationRequest

interface AuthService {
    fun getToken(authRequest: AuthRequest): TokenDto
    fun save(data: RegistrationRequest): TokenDto
}
