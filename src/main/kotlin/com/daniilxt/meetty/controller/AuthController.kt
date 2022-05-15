package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.dto.UserDto
import com.daniilxt.meetty.entity.UserDetailEntity
import com.daniilxt.meetty.repository.UserDetailsRepository
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.request.AuthRequest
import com.daniilxt.meetty.request.RegistrationRequest
import com.daniilxt.meetty.security.jwt.JwtTokenProvider
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.GrantedAuthority
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userDetailsRepository: UserDetailsRepository,
    private val userRepository: UserRepository

) {
    @PostMapping("/login")
    fun signIn(@RequestBody authRequest: AuthRequest): TokenDto {
        val authorities = ArrayList<GrantedAuthority>()
        val name: String = authRequest.login
        val token = jwtTokenProvider.createToken(
            name, emptyList()
        )
        return TokenDto(accessToken = token)
    }

    @PostMapping("/registration")
    fun register(@RequestBody registrationRequest: RegistrationRequest) {
        // TODO provide token
        val userLogin = registrationRequest.email
        val userPassword = registrationRequest.password
        if (userLogin.isNotBlank() && userPassword.isNotBlank()) {
            // TODO choose another encryption algorithm
            val encryptedPassword = Base64.getEncoder().encode(userPassword.toByteArray())
            registerUser(registrationRequest.toUserDto())
        }
    }

    private fun registerUser(userDto: UserDto) {
        //userRepository.save(userDto.toUserEntity())
    }

/*    private fun registerAndGetUser(userDto: UserDto): UserDto {
        registerUser(userDto)
    }*/
}

private fun RegistrationRequest.toUserDto() = UserDto(
    firstName = this.firstName,
    lastName = this.lastName,
    avatarLink = ""
)
