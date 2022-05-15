package com.daniilxt.meetty.service.impl

import com.daniilxt.meetty.repository.UserDetailsRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserDetailsRepository
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userName: String): UserDetails {
        return userRepository.findUserByLogin(userName)
            ?: throw UsernameNotFoundException("Username not found")
    }
}