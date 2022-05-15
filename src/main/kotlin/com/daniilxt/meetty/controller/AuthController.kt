package com.daniilxt.meetty.controller

import com.daniilxt.meetty.dto.TokenDto
import com.daniilxt.meetty.dto.UserDto
import com.daniilxt.meetty.repository.UserDetailsRepository
import com.daniilxt.meetty.repository.UserRepository
import com.daniilxt.meetty.request.AuthRequest
import com.daniilxt.meetty.request.RegistrationRequest
import com.daniilxt.meetty.security.jwt.JwtTokenProvider
import org.slf4j.LoggerFactory
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
        logger.info("GETTING CLASS ${registrationRequest}")
        // TODO provide token
        val userLogin = registrationRequest.userCredentials.email
        val userPassword = registrationRequest.userCredentials.password
        if (userLogin.isNotBlank() && userPassword.isNotBlank()) {
            // TODO choose another encryption algorithm
            val encryptedPassword = Base64.getEncoder().encodeToString(userPassword.toByteArray())

            val decodedBytes: ByteArray = Base64.getDecoder().decode(encryptedPassword)
            val decodedString = String(decodedBytes)
            logger.info("ENCODED $encryptedPassword   decoded $decodedString")
            registerUser(registrationRequest)
        }
    }

    private fun registerUser(userDto: UserDto) {
        //userRepository.save(userDto.toUserEntity())
    }

/*    private fun registerAndGetUser(userDto: UserDto): UserDto {
        registerUser(userDto)
    }*/

    companion object {
        private val logger = LoggerFactory.getLogger(AuthController::class.java)
    }
}

private fun RegistrationRequest.toUserDto() = UserDto(
    firstName = this.userPersonalInfo.firstName,
    lastName = this.userPersonalInfo.lastName,
    avatarLink = ""
)
